package org.example;

import java.util.ArrayList;

public abstract class Desconto {

    protected ArrayList<FormaPagamento> listaFormaPagamento = new ArrayList();
    private Desconto maiorDesconto;

    public Desconto getMaiorDesconto() {
        return maiorDesconto;
    }

    public void setMaiorDesconto(Desconto maiorDesconto) {
        this.maiorDesconto = maiorDesconto;
    }

    protected abstract double aplicarDesconto(Pedido pedido);

    public double calcularDesconto(Pedido pedido, Pagamento pagamento) {
        if (listaFormaPagamento.contains(pagamento.getFormaPagamento())) {
            return aplicarDesconto(pedido);
        }
        else {
            if(maiorDesconto != null) {
                return maiorDesconto.calcularDesconto(pedido, pagamento);
            } else {
                return 0.0;
            }
        }
    }

}
