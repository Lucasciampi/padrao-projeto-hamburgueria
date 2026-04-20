package org.example;

public class PedidoEstadoPronto extends PedidoEstado {

    private PedidoEstadoPronto() {
    }

    private static PedidoEstadoPronto instance;

    public static PedidoEstadoPronto getInstance() {
        if (instance == null) {
            instance = new PedidoEstadoPronto();
        }
        return instance;
    }

    @Override
    public String getEstado() {
        return "Pronto";
    }

    public boolean entregue(Pedido pedido) {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        return true;
    }

    public boolean emRota(Pedido pedido) {
        pedido.setEstado(PedidoEstadoEmRota.getInstance());
        return true;
    }

    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }

}
