/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Erivando
 */
public class TableModelEspecial extends DefaultTableModel {

    private static final long serialVersionUID = 1L;
    private final List entidadesParaLista;
    private final Class entidadeClasseParaLista;
    private List<Method> campoParaDado = new LinkedList<Method>();
    private final JTable tabelaParaControle;

    public TableModelEspecial(Class entidadeClasseParaLista, List entidadesParaLista, JTable tabelaParaControle) {
        super();

        this.entidadeClasseParaLista = entidadeClasseParaLista;
        this.entidadesParaLista = entidadesParaLista;
        this.tabelaParaControle = tabelaParaControle;

        try {
            iniciaAddColunas();
            iniciaAddValores();
        } catch (Exception ex) {
            Logger.getLogger(TableModelEspecial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void iniciaAddColunas() throws NoSuchMethodException, InstantiationException, IllegalAccessException {
        for (Field campo : entidadeClasseParaLista.getDeclaredFields()) {
            ColunaSwing anotacao = campo.getAnnotation(ColunaSwing.class);
            if (anotacao != null) {
                addColumn(anotacao.descricao());
             //   tabelaParaControle.getColumnModel().getColumn(getColumnCount() - 1).setCellRenderer(anotacao.renderizador().newInstance());
                anotacao.corDeFundo();
                String nomeMetodo = "get" + campo.getName().toUpperCase().charAt(0) + campo.getName().substring(1);
                campoParaDado.add(entidadeClasseParaLista.getDeclaredMethod(nomeMetodo));
            }
        }
    }

    private void iniciaAddValores() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        for (Object entidade : entidadesParaLista) {
            List<Object> valoresParaAdd = new LinkedList<Object>();

            for (Method metodo : campoParaDado) {
                valoresParaAdd.add(metodo.invoke(entidade));
            }

            addRow(valoresParaAdd.toArray());
        }

    }

    /*
     * Trava a edicao das celulas
     */
    @Override
    public boolean isCellEditable(int rowIndex, int mColIndex) {
        return false;
    }
}
