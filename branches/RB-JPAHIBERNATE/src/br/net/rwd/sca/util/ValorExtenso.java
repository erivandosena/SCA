/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.util;

import net.sf.jasperreports.engine.JRDefaultScriptlet;

/**
 *
 * @author Administrador
 */
public class ValorExtenso extends JRDefaultScriptlet {

    public String valorRealExtenso(String valor) {
        String extenso = "";        //variavel que retornará o valor por extenso
        String tipo = "";           //variavel que definirá o tipo de número ( unitario, dezena, centena)
        String parte1 = "";         //variavel que armazenará temporáriamente o valor que foi analizado
        int cont = valor.length();  //conta quantas números tem o valor
        int i = 0;                  //variavel de controle do while
        int somar = 1;              //variavel que dirá o valor a ser somado à variável "i"

        while (i < cont) {
            somar = 1;
            //verifica se o caracter atual é número ou uma "," ou "."
            if (valor.substring(i, i + 1).equals(",") == false && valor.substring(i, i + 1).equals(".") == false) {
                //o valor passado tem 3 dígitos, ex: R$ 1,20
                if (cont == 4 && i == 0) {
                    tipo = "unitario";
                } else if (cont == 4 && i == 2) {
                    tipo = "dezena";
                } else if (cont == 4 && i == 3) {
                    tipo = "unitario";
                } //o valor passado tem 4 dígitos, ex: R$ 11,20
                else if (cont == 5 && i == 0) {
                    tipo = "dezena";
                } else if (cont == 5 && i == 1) {
                    tipo = "unitario";
                } else if (cont == 5 && i == 3) {
                    tipo = "dezena";
                } else if (cont == 5 && i == 4) {
                    tipo = "unitario";
                } //o valor passado tem 5 dígitos, ex: R$ 111,20
                else if (cont == 6 && i == 0) {
                    tipo = "centena";
                } else if (cont == 6 && i == 1) {
                    tipo = "dezena";
                } else if (cont == 6 && i == 2) {
                    tipo = "unitario";
                } else if (cont == 6 && i == 4) {
                    tipo = "dezena";
                } else if (cont == 6 && i == 5) {
                    tipo = "unitario";
                } //o valor passado tem 6 dígitos, ex: R$ 1.111,20
                else if (cont == 8 && i == 0) {
                    tipo = "unitario";
                } else if (cont == 8 && i == 2) {
                    tipo = "centena";
                } else if (cont == 8 && i == 3) {
                    tipo = "dezena";
                } else if (cont == 8 && i == 4) {
                    tipo = "unitario";
                } else if (cont == 8 && i == 6) {
                    tipo = "dezena";
                } else if (cont == 8 && i == 7) {
                    tipo = "unitario";
                } //o valor passado tem 7 dígitos, ex: R$ 11.111,20
                else if (cont == 9 && i == 0) {
                    tipo = "dezena";
                } else if (cont == 9 && i == 1) {
                    tipo = "unitario";
                } else if (cont == 9 && i == 3) {
                    tipo = "centena";
                } else if (cont == 9 && i == 4) {
                    tipo = "dezena";
                } else if (cont == 9 && i == 5) {
                    tipo = "unitario";
                } else if (cont == 9 && i == 7) {
                    tipo = "dezena";
                } else if (cont == 9 && i == 8) {
                    tipo = "unitario";
                } //o valor passado tem 8 dígitos, ex: R$ 111.111,20
                else if (cont == 10 && i == 0) {
                    tipo = "centena";
                } else if (cont == 10 && i == 1) {
                    tipo = "dezena";
                } else if (cont == 10 && i == 2) {
                    tipo = "unitario";
                } else if (cont == 10 && i == 4) {
                    tipo = "centena";
                } else if (cont == 10 && i == 5) {
                    tipo = "dezena";
                } else if (cont == 10 && i == 6) {
                    tipo = "unitario";
                } else if (cont == 10 && i == 8) {
                    tipo = "dezena";
                } else if (cont == 10 && i == 9) {
                    tipo = "unitario";
                }

                // se o tipo analisado for do tipo unitário, define a variável "parte1"
                if ("unitario".equals(tipo)) {
                    if (valor.substring(i, i + 1).equals("1")) {
                        parte1 = "Um ";
                    } else if (valor.substring(i, i + 1).equals("2")) {
                        parte1 = "Dois ";
                    } else if (valor.substring(i, i + 1).equals("3")) {
                        parte1 = "Três ";
                    } else if (valor.substring(i, i + 1).equals("4")) {
                        parte1 = "Quatro ";
                    } else if (valor.substring(i, i + 1).equals("5")) {
                        parte1 = "Cinco ";
                    } else if (valor.substring(i, i + 1).equals("6")) {
                        parte1 = "Seis ";
                    } else if (valor.substring(i, i + 1).equals("7")) {
                        parte1 = "Sete ";
                    } else if (valor.substring(i, i + 1).equals("8")) {
                        parte1 = "Oito ";
                    } else if (valor.substring(i, i + 1).equals("9")) {
                        parte1 = "Nove ";
                    } else if (valor.substring(i, i + 1).equals("0")) {
                        parte1 = "";
                    }
                }
                // se o tipo analisado for do tipo dezena, define a variável "parte1"
                if ("dezena".equals(tipo)) {
                    if (valor.substring(i, i + 1).equals("1")) {
                        //se o caracter começa com "1" é avaliado tb o caracter seguinte
                        if (valor.substring(i, i + 2).equals("10")) {
                            parte1 = "Dez ";
                        } else if (valor.substring(i, i + 2).equals("11")) {
                            parte1 = "Onze ";
                        } else if (valor.substring(i, i + 2).equals("12")) {
                            parte1 = "Doze ";
                        } else if (valor.substring(i, i + 2).equals("13")) {
                            parte1 = "Treze ";
                        } else if (valor.substring(i, i + 2).equals("14")) {
                            parte1 = "Quatorze ";
                        } else if (valor.substring(i, i + 2).equals("15")) {
                            parte1 = "Quinze ";
                        } else if (valor.substring(i, i + 2).equals("16")) {
                            parte1 = "Dezesseis ";
                        } else if (valor.substring(i, i + 2).equals("17")) {
                            parte1 = "Dezesete ";
                        } else if (valor.substring(i, i + 2).equals("18")) {
                            parte1 = "Dezoito ";
                        } else if (valor.substring(i, i + 2).equals("19")) {
                            parte1 = "Dezenove ";
                        }
                        somar = 2; //como foi analisado duas casas do valor, a variável "i" será acrescentada em 2
                    } //se o caracter não começa com "1", já é definido a variável parte1
                    else if (valor.substring(i, i + 1).equals("2")) {
                        parte1 = "Vinte ";
                    } else if (valor.substring(i, i + 1).equals("3")) {
                        parte1 = "Trinta ";
                    } else if (valor.substring(i, i + 1).equals("4")) {
                        parte1 = "Quarenta ";
                    } else if (valor.substring(i, i + 1).equals("5")) {
                        parte1 = "Cinquenta ";
                    } else if (valor.substring(i, i + 1).equals("6")) {
                        parte1 = "Sessenta ";
                    } else if (valor.substring(i, i + 1).equals("7")) {
                        parte1 = "Setenta ";
                    } else if (valor.substring(i, i + 1).equals("8")) {
                        parte1 = "Oitenta ";
                    } else if (valor.substring(i, i + 1).equals("9")) {
                        parte1 = "Noventa ";
                    } else if (valor.substring(i, i + 1).equals("0")) {
                        parte1 = "";
                    }
                }
                // se o tipo analisado for do tipo centena, define a variável "parte1"
                if ("centena".equals(tipo)) {
                    if (valor.substring(i, i + 1).equals("1")) {
                        //se o caracter começa com "1", avalia os proximos dois caracteres, para
                        //definir se é "Cem" ou "Cento"
                        if (valor.substring(i, i + 3).equals("100")) {
                            parte1 = "Cem ";
                        } else {
                            parte1 = "Cento ";
                        }
                    } else if (valor.substring(i, i + 1).equals("2")) {
                        parte1 = "Duzentos ";
                    } else if (valor.substring(i, i + 1).equals("3")) {
                        parte1 = "Trezentos ";
                    } else if (valor.substring(i, i + 1).equals("4")) {
                        parte1 = "Quatrocentos ";
                    } else if (valor.substring(i, i + 1).equals("5")) {
                        parte1 = "Quinhentos ";
                    } else if (valor.substring(i, i + 1).equals("6")) {
                        parte1 = "Seiscentos ";
                    } else if (valor.substring(i, i + 1).equals("7")) {
                        parte1 = "Setecentos ";
                    } else if (valor.substring(i, i + 1).equals("8")) {
                        parte1 = "Oitocentos ";
                    } else if (valor.substring(i, i + 1).equals("9")) {
                        parte1 = "Novecentos ";
                    } else if (valor.substring(i, i + 1).equals("0")) {
                        parte1 = "";
                    }
                }
                //se o caracter é igual a "0" ou "," não é adicionado a palavra "e "
                if (i == 0 || valor.substring(i - 1, i).equals(",")) {
                    extenso = extenso + parte1;
                } else if (valor.substring(i, i + 1).equals("0") == false) { //se o caracter é igual à "0"
                    if (extenso.equals("")) { //verifica se a variável extenso é nula
                        extenso = extenso + parte1;
                    } else {
                        extenso = extenso + "e " + parte1;
                    }
                }


            } //verifica se o caracter atual é ","
            else if (valor.substring(i, i + 1).equals(",")) {
                if (cont == 4 && Integer.parseInt(valor.substring(i - 1, i)) == 1) {
                    //se o valor tem 3 dígitos e começa com "1", adiciona a palavra Real
                    extenso = extenso + "Real ";
                } else if (cont > 4 || Integer.parseInt(valor.substring(i - 1, i)) > 1) {
                    //se o valor tem mais 3 dígitos ou não começa com "1", adiciona a palavra Reais
                    extenso = extenso + "Reais ";
                }


            } //verifica se o caracter atual é "."
            else if (valor.substring(i, i + 1).equals(".")) {
                extenso = extenso + "Mil "; //se sim, acrescenta a palavra "Mil"
            }

            i = i + somar;

        }
        //verifica se as duas casas decimais é maior que 1
        if (Integer.parseInt(valor.substring(cont - 2, cont)) > 1) {
            extenso = extenso + "Centavos"; //se sim, acrescenta a palavra Centavos
        } else if (Integer.parseInt(valor.substring(cont - 2, cont)) == 1) {
            extenso = extenso + "Centavo"; //se não, acrescenta a palavra Centavo
        }

        return extenso;
    }
}
