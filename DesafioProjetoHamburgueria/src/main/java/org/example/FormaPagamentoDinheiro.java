package org.example;

public class FormaPagamentoDinheiro implements FormaPagamento{

    private static FormaPagamentoDinheiro instance;

    private FormaPagamentoDinheiro() {}

    public static FormaPagamentoDinheiro getInstance() {
        if (instance == null) {
            instance = new FormaPagamentoDinheiro();
        }
        return instance;
    }

    @Override
    public String pagar(double valor) {
        return "Pagamento de R$ " + valor + " será realizado em Dinheiro.";
    }

}
