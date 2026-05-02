package org.example;

public class FormaPagamentoDinheiro implements FormaPagamento{

    @Override
    public String pagar(double valor) {
        return "Pagamento de R$ " + valor + " será realizado em Dinheiro.";
    }

}
