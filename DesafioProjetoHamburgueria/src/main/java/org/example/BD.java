package org.example;

import java.util.HashMap;
import java.util.Map;

public class BD {

    private static Map<Integer, Pedido> pedidos = new HashMap<>();

    public static void addPedido(int id, Pedido pedido) {
        pedido.setId(id);
        pedidos.put(id, pedido);
    }

    public static Pedido getPedido(Integer id) {
        return pedidos.get(id);
    }

    public static void limpar() {
        pedidos.clear();
    }
}
