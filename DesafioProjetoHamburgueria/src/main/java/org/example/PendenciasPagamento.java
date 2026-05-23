package org.example;

public class PendenciasPagamento extends Pendencias {

    private static PendenciasPagamento instance = new PendenciasPagamento();

    private PendenciasPagamento() {}

    public static PendenciasPagamento getInstance() {
        return instance;
    }

}
