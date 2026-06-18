package org.example;

public class FormaPagamentoCredito implements FormaPagamento {

    private static FormaPagamentoCredito instance;

    private FormaPagamentoCredito() {}

    public static FormaPagamentoCredito getInstance() {
        if (instance == null) {
            instance = new FormaPagamentoCredito();
        }
        return instance;
    }

    @Override
    public String pagar(double valor) {
        return "Pagamento de R$ " + valor + " processado via Cartão de Crédito parcelado.";
    }


}
