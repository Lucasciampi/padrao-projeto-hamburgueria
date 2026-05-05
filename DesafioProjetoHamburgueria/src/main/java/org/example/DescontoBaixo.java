package org.example;

public class DescontoBaixo extends Desconto{

    public DescontoBaixo(Desconto maiorDesconto) {
        listaFormaPagamento.add(FormaPagamentoCartao.getInstance());
        setMaiorDesconto(maiorDesconto);
    }

    @Override
    protected double aplicarDesconto(Pedido pedido) {
        return pedido.getLanche().getPreco() * 0.05;
    }

}
