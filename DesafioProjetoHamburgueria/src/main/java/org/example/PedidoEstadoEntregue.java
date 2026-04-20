package org.example;

public class PedidoEstadoEntregue extends PedidoEstado {

    private PedidoEstadoEntregue() {}

    private static PedidoEstadoEntregue instance;

    public static PedidoEstadoEntregue getInstance() {
        if (instance == null) {
            instance = new PedidoEstadoEntregue();
        }
        return instance;
    }

    @Override
    public String getEstado() {
        return "Entregue";
    }

    public boolean devolver(Pedido pedido) {
        pedido.setEstado(PedidoEstadoDevolucao.getInstance());
        return true;
    }

}
