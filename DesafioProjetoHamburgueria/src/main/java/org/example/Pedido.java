package org.example;

import java.util.Observable;

public class Pedido extends Observable implements Cloneable {

    private Hamburguer lanche;
    private PedidoEstado estado;

    public Pedido(HamburguerFactory factory) {
        this.lanche = factory.prepararLanche();
        this.setEstado(PedidoEstadoAceito.getInstance());
    }

    public Hamburguer getLanche() {
        return lanche;
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
        atualizarPedido();
    }

    public PedidoEstado getEstado() {
        return estado;
    }

    public String getNomeEstado() {
        return estado.getEstado();
    }

    public boolean aceitar() {
        return estado.aceitar(this);
    }

    public boolean preparar() {
        return estado.preparar(this);
    }

    public boolean pronto() {
        return estado.pronto(this);
    }

    public boolean emRota() {
        return estado.emRota(this);
    }

    public boolean entregue() {
        return estado.entregue(this);
    }

    public boolean devolver() {
        return estado.devolver(this);
    }

    public boolean cancelar() {
        return estado.cancelar(this);
    }

    public void atualizarPedido() {
        estado.atualizarEstadoPedido(this);
        setChanged();
        notifyObservers();
    }

    public boolean verificarPendencias() {
        return PedidoFacade.verificarPendencias(this);
    }

    @Override
    public Pedido clone() throws CloneNotSupportedException {
        Pedido pedidoClone = (Pedido) super.clone();
        pedidoClone.setEstado(PedidoEstadoAceito.getInstance());
        return pedidoClone;
    }

    public String toString() {
        return this.getNomeEstado();
    }

}
