package org.example;

public class PedidoEstadoAceito extends PedidoEstado {

    private PedidoEstadoAceito() {}

    private static PedidoEstadoAceito instance;

    public static PedidoEstadoAceito getInstance() {
        if (instance == null) {
            instance = new PedidoEstadoAceito();
        }
        return instance;
    }

    @Override
    public String getEstado() {
        return "Aceito";
    }

    public boolean preparar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoEmPreparacao.getInstance());
        return true;
    }

}
