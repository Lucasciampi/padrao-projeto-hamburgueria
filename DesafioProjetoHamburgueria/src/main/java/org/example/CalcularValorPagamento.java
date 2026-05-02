package org.example;

public class CalcularValorPagamento {

    private FormaPagamento formaPagamento;

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String realizarPagamento(Pedido pedido) {
        if (this.formaPagamento == null) {
            throw new IllegalStateException("Forma de pagamento não definida.");
        }
        double valorTotal = pedido.getLanche().getPreco();
        return this.formaPagamento.pagar(valorTotal);
    }

}
