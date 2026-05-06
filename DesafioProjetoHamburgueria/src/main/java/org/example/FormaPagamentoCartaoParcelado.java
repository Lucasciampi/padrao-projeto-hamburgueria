package org.example;

public class FormaPagamentoCartaoParcelado implements FormaPagamento {

    private static FormaPagamentoCartaoParcelado instance;

    private FormaPagamentoCartaoParcelado() {}

    public static FormaPagamentoCartaoParcelado getInstance() {
        if (instance == null) {
            instance = new FormaPagamentoCartaoParcelado();
        }
        return instance;
    }

    @Override
    public String pagar(double valor) {
        return "Pagamento de R$ " + valor + " processado via Cartão de Crédito parcelado.";
    }


}
