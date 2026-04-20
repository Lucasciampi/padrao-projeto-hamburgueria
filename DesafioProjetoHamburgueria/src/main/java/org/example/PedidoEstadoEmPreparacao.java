package org.example;

public class PedidoEstadoEmPreparacao extends PedidoEstado {

    private PedidoEstadoEmPreparacao() {}

    private static PedidoEstadoEmPreparacao instance;

    public static PedidoEstadoEmPreparacao getInstance() {
        if (instance == null) {
            instance = new PedidoEstadoEmPreparacao();
        }
        return instance;
    }

    @Override
    public String getEstado() {
        return "Em Preparação";
    }

    public boolean pronto(Pedido pedido) {
        pedido.setEstado(PedidoEstadoPronto.getInstance());
        return true;
    }

    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }

}
