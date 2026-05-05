package org.example;

public class FormaPagamentoPix implements FormaPagamento{

    private static FormaPagamentoPix instance;

    private FormaPagamentoPix() {}

    public static FormaPagamentoPix getInstance() {
        if (instance == null) {
            instance = new FormaPagamentoPix();
        }
        return instance;
    }

    @Override
    public String pagar(double valor) {
        return "Pagamento de R$ " + valor + " processado via PIX.";
    }

}
