package org.example;

public class PedidoRepository {

    public static Pedido buscarPorId(int id) {
        return BD.getPedido(id);
    }

}