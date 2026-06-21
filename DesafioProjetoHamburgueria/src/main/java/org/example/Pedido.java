package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Observable;

public class Pedido extends Observable implements Cloneable, IPedido {

    private int id;
    private Lanche lanche;
    private Bebida bebida;
    private PedidoEstado estado;

    public Pedido(LancheFactory factory) {
        this.lanche = factory.prepararLanche();
        this.setEstado(PedidoEstadoAceito.getInstance());
    }

    public Pedido(ComboFactory factory) {
        this.lanche = factory.prepararLanche();
        this.bebida = factory.prepararBebida();
        this.setEstado(PedidoEstadoAceito.getInstance());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValorTotal() {
        double valor = lanche.getPreco();
        if (bebida != null) {
            valor += bebida.getPreco();
        }
        return valor;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public Lanche getLanche() {
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

    @Override
    public List<String> obterDadosPedido() {
        return Arrays.asList(this.lanche.getDescricao(), this.getNomeEstado());
    }

    @Override
    public double obterValorPagamento(Funcionario funcionario) {
        return this.getValorTotal();
    }

}
