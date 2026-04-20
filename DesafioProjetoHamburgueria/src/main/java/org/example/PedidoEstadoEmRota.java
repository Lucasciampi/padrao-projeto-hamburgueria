package org.example;

public class PedidoEstadoEmRota extends PedidoEstado {

    private PedidoEstadoEmRota() {}

    private static PedidoEstadoEmRota instance;

    public static PedidoEstadoEmRota getInstance() {
        if (instance == null) {
            instance = new PedidoEstadoEmRota();
        }
        return instance;
    }

    @Override
    public String getEstado() {
        return "Em Rota";
    }

    public boolean entregue(Pedido pedido) {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        return true;
    }

    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }

}
