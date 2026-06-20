package org.example;

public class CalcularValorPagamento {

    private FormaPagamento formaPagamento;
    private Desconto cadeiaDeDescontos;

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public void setCadeiaDeDescontos(Desconto cadeiaDeDescontos) {
        this.cadeiaDeDescontos = cadeiaDeDescontos;
    }

    public String realizarPagamento(Pedido pedido) {
        if (this.formaPagamento == null) {
            throw new IllegalStateException("Forma de pagamento não definida.");
        }
        double valorBase = pedido.getValorTotal();
        double descontoTotal = 0.0;
        if (this.cadeiaDeDescontos != null) {
            Pagamento pagamento = new Pagamento(this.formaPagamento);
            descontoTotal = this.cadeiaDeDescontos.calcularDesconto(pedido, pagamento);
        }
        double valorFinal = valorBase - descontoTotal;
        return this.formaPagamento.pagar(valorFinal);
    }

}
