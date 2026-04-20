package org.example;

public class Pedido {

    private Hamburguer lanche;
    private PedidoEstado estado;

    public Pedido(HamburguerFactory factory) {
        this.lanche = factory.prepararLanche();
        this.estado = PedidoEstadoAceito.getInstance();
    }

    public Hamburguer getLanche() {
        return lanche;
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
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

}
