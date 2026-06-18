package org.example;

public class FormaPagamentoDebito implements FormaPagamento{

    private static FormaPagamentoDebito instance;

    private FormaPagamentoDebito() {}

    public static FormaPagamentoDebito getInstance() {
        if (instance == null) {
            instance = new FormaPagamentoDebito();
        }
        return instance;
    }

    @Override
    public String pagar(double valor) {
        return "Pagamento de R$ " + valor + " processado via Cartão de Crédito à vista.";
    }

}
