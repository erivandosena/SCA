package br.net.rwd.sca.cobranca;

import org.jrimum.bopepo.campolivre.CampoLivre;
import org.jrimum.utilix.text.Field;
import org.jrimum.utilix.text.Filler;

public class CampoLivreCefSIGCB implements CampoLivre {

    private static final long serialVersionUID = 6194405988187683102L;
    String campoLivreFormatado = null;

    public CampoLivreCefSIGCB(String numeroConta, String dvNumConta, String nossoNumero) {
        String campo1 = formataCampo1(new Field<String>(numeroConta.substring(0, 5), 5, Filler.ZERO_LEFT).write());
        String campo2 = formataCampo2(numeroConta, dvNumConta, nossoNumero);
        String campo3 = formataCampo3(nossoNumero, campo1, campo2);
        campoLivreFormatado = campo1 + campo2 + campo3;
    }

    @Override
    public void read(String arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public String write() {
        // TODO Auto-generated method stub
        return campoLivreFormatado;
    }

    private static String formataCampo1(String numero) {
        return numero;
    }

    public static String formataCampo2(String numeroCedente, String dvNumCedente, String nossoNumero) {
        numeroCedente = numeroCedente.substring(5, 6);
        String modalidade = nossoNumero.substring(0, 1);
        String identificador = nossoNumero.substring(1, 2);
        String nossoNumero1 = nossoNumero.substring(2, 5);
        String nossoNumero2 = nossoNumero.substring(5, 8);
        String numeroFormatado = numeroCedente + dvNumCedente + nossoNumero1 + modalidade + nossoNumero2 + identificador;

        return numeroFormatado;
    }

    public static String formataCampo3(String nossoNumero, String campo1, String campo2) {
        nossoNumero = nossoNumero.substring(8, 17);
        Integer dv = calculeDVModulo11(campo1 + campo2 + nossoNumero);

        return nossoNumero + dv;
    }

    public static int calculeDVModulo11(String numero) {
        int dv = 0;
        int[] values = new int[numero.length()];
        for (int i = 0; i < numero.length(); i++) {
            values[i] = Integer.parseInt(numero.charAt(i) + "");
        }
        int soma = 0;
        int vetpos = numero.length() - 1;
        while (vetpos >= 0) {
            for (int i = 2; i < 10; i++) {
                soma += values[vetpos] * i;
                vetpos--;
                if (vetpos < 0) {
                    break;
                }
            }
        }

        if (soma < 11) {
            dv = soma - 11;
        } else {
            int resto = soma % 11;
            dv = 11 - resto;
        }

        if (dv > 9) {
            dv = 0;
        }

        return dv;
    }
}