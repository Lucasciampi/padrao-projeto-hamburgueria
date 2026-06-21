package org.example;

import java.util.List;

public class PedidoProxy implements IPedido {

    private Pedido pedido;
    private int id;

    public PedidoProxy(int id) {
        this.id = id;
    }

    @Override
    public List<String> obterDadosPedido() {
        if (this.pedido == null) {
            this.pedido = PedidoRepository.buscarPorId(this.id);
        }
        return this.pedido.obterDadosPedido();
    }

    @Override
    public double obterValorPagamento(Funcionario funcionario) {
        if (!funcionario.isAutorizado()) {
            throw new IllegalArgumentException("Funcionário não autorizado");
        }
        if (this.pedido == null) {
            this.pedido = PedidoRepository.buscarPorId(this.id);
        }
        return this.pedido.obterValorPagamento(funcionario);
    }
}
