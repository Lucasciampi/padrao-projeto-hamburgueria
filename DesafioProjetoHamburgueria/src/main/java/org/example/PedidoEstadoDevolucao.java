package org.example;

public class PedidoEstadoDevolucao extends PedidoEstado{

    private PedidoEstadoDevolucao() {}

    private static PedidoEstadoDevolucao instance;

    public static PedidoEstadoDevolucao getInstance() {
        if (instance == null) {
            instance = new PedidoEstadoDevolucao();
        }
        return instance;
    }

    @Override
    public String getEstado() {
        return "Devolução";
    }

    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }

}
