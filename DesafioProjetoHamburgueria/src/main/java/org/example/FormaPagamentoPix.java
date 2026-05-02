package org.example;

public class FormaPagamentoPix implements FormaPagamento{

    @Override
    public String pagar(double valor) {
        return "Pagamento de R$ " + valor + " processado via PIX.";
    }

}
