package org.example;

public class DescontoMedio extends Desconto{

    public DescontoMedio(Desconto maiorDesconto) {
        listaFormaPagamento.add(FormaPagamentoDinheiro.getInstance());
        setMaiorDesconto(maiorDesconto);
    }

    @Override
    protected double aplicarDesconto(Pedido pedido) {
        return pedido.getLanche().getPreco() * 0.10;
    }

}
