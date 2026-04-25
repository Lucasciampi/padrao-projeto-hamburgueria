package org.example;

import java.util.Observable;
import java.util.Observer;

public abstract class PedidoEstado implements Observer {

    private String ultimaNotificacao;

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

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void atualizarEstadoPedido(Pedido pedido) {
        pedido.addObserver(this);
    }

    public void update(Observable pedido, Object arg1) {
        this.ultimaNotificacao = "O pedido está na etapa: " + pedido.toString();
    }

}
