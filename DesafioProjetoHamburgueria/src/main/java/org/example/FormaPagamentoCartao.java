package org.example;

public class FormaPagamentoCartao implements FormaPagamento{

    @Override
    public String pagar(double valor) {
        return "Pagamento de R$ " + valor + " processado via Cartão de Crédito.";
    }

}
