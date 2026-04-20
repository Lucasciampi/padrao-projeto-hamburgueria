package org.example;

public class PedidoEstadoCancelado extends PedidoEstado {

    private PedidoEstadoCancelado() {}

    private static PedidoEstadoCancelado instance;

    public static PedidoEstadoCancelado getInstance() {
        if (instance == null) {
            instance = new PedidoEstadoCancelado();
        }
        return instance;
    }

    @Override
    public String getEstado() {
        return "Cancelado";
    }

}
