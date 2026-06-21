package org.example;

public class PromocaoCalculadora {

    public static double calcularValorComPromocao(double valor, String formula) {
        String expressao = formula.replace("valor", Double.toString(valor));
        InterpretadorExpressao interpretador = new InterpretadorExpressoesAritmeticas(expressao);
        return interpretador.interpretar();
    }

}