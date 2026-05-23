package org.example;

public class PedidoFacade {

    public static boolean verificarPendencias(Pedido pedido) {
        if (PendenciasPagamento.getInstance().verificarPedidoComPendencia(pedido)) {
            return false;
        }
        if (PendenciasEntrega.getInstance().verificarPedidoComPendencia(pedido)) {
            return false;
        }
        return true;
    }

}
