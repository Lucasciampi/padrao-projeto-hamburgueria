package org.example;

public class DescontoAlto extends Desconto {

    public DescontoAlto(Desconto maiorDesconto) {
        listaFormaPagamento.add(FormaPagamentoPix.getInstance());
        setMaiorDesconto(maiorDesconto);
    }

    @Override
    protected double aplicarDesconto(Pedido pedido) {
        return pedido.getLanche().getPreco() * 0.15;
    }

}
