package org.example;

public class FormaPagamentoCartao implements FormaPagamento{

    private static FormaPagamentoCartao instance;

    private FormaPagamentoCartao() {}

    public static FormaPagamentoCartao getInstance() {
        if (instance == null) {
            instance = new FormaPagamentoCartao();
        }
        return instance;
    }

    @Override
    public String pagar(double valor) {
        return "Pagamento de R$ " + valor + " processado via Cartão de Crédito.";
    }

}
