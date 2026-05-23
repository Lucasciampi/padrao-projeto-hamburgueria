package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Pendencias {

    private List<Pedido> pedidosPendentes = new ArrayList<Pedido>();

    public void addPedidoPendente(Pedido pedido) {
        this.pedidosPendentes.add(pedido);
    }

    public boolean verificarPedidoComPendencia(Pedido pedido) {
        return this.pedidosPendentes.contains(pedido);
    }

}
