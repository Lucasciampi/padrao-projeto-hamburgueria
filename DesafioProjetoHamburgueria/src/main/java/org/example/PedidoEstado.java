package org.example;

public abstract class PedidoEstado {

    public abstract String getEstado();

    public boolean aceitar(Pedido pedido) {
        return false;
    }

    public boolean preparar(Pedido pedido) {
        return false;
    }

    public boolean pronto(Pedido pedido) {
        return false;
    }

    public boolean emRota(Pedido pedido) {
        return false;
    }

    public boolean entregue(Pedido pedido) {
        return false;
    }

    public boolean devolver(Pedido pedido) {
        return false;
    }

    public boolean cancelar(Pedido pedido) {
        return false;
    }

}
