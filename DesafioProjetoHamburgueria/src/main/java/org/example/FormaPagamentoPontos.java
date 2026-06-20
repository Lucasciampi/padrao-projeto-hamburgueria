package org.example;

public class FormaPagamentoPontos implements FormaPagamento {

    private static FormaPagamentoPontos instance;

    private FormaPagamentoPontos() {}

    public static FormaPagamentoPontos getInstance() {
        if (instance == null) {
            instance = new FormaPagamentoPontos();
        }
        return instance;
    }

    @Override
    public String pagar(double valor) {
        return "Pagamento de R$ " + valor + " processado via Pontos de Fidelidade.";
    }

}
