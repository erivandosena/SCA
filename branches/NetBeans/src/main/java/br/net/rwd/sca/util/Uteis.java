package br.net.rwd.sca.util;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.Document;
import javax.swing.text.EditorKit;
import javax.swing.text.html.HTMLEditorKit;

public class Uteis {

	// data formato: 2010
	public static String getAnoAtual() {
		Date hoje = Calendar.getInstance().getTime();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy");
		String formatoSaida = formato.format(hoje);
		return formatoSaida;
	}

	// data formato: 16/12/10
	public static String getDataCurta() {
		Date dt = new Date();
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		return df.format(dt);
	}

	// data formato: 16/12/2010
	public static String getDataAbreviada() {
		Date dt = new Date();
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		return df.format(dt);
	}

	// data formato: 16 de Dezembro de 2010
	public static String getDataLonga() {
		Date dt = new Date();
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
		return df.format(dt);
	}

	// data formato: Quinta-feira, 16 de Dezembro de 2010
	public static String getDataCompleta() {
		Date dt = new Date();
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
		return df.format(dt);
	}
	
	//html para texto
	public static final String html2text(String html) {
		EditorKit kit = new HTMLEditorKit();
		Document doc = kit.createDefaultDocument();
		doc.putProperty("IgnoreCharsetDirective", Boolean.TRUE);
		try {
			Reader reader = new StringReader(html);
			kit.read(reader, doc, 0);
			return doc.getText(0, doc.getLength());
		} catch (Exception e) {
			return "";
		}
	}
	
	/**
     * Retorna apenas numeros de uma String informada
     * 
     * @param str
     * @return String ou null se vazio
     */
	public static String retornaNumeros(String str) {
		if (str != null) {
			return str.replaceAll("[^0123456789]", "");
		} else {
			return null;
		}
	}
	
	/**
     * Inclui o numero 3 a String informada se igual a 9 caracteres
     * 
     * @param str
     * @return String ou null se vazio
     */
	private static String ajustaNumTelefone(String str) {
		if (str != null)
			if (str.length() == 9)
				return str.substring(0, 2).concat("3").concat(str.substring(2, str.length()));
			else
				return str;
		else
			return null;
	}

	/**
     * Inclui os numeros 00 a String informada se igual a 8 caracteres
     * 
     * @param str
     * @return String ou null se vazio
     */
	public static String ajustaDddTelefone(String str) {
		if (str != null)
			if (str.length() == 8)
				return ajustaNumTelefone("00".concat(str));
			else
				return ajustaNumTelefone(str);
		else
			return null;
	}
	
                /**
     * Exibe o arquivo na tela.
     * 
     * @param arquivoBoleto
     */
    public static void exibeArquivoNaTela(File arquivoBoleto) {
        try {
            Desktop.getDesktop().open(new File(arquivoBoleto.getAbsolutePath())); 
            //java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
        } catch (IOException ex) {
            ex.getStackTrace();
        }

    }
}
