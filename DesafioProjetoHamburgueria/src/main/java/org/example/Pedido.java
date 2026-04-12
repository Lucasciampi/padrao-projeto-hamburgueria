package org.example;

public class Pedido {

    private Hamburguer lanche;
    private String acompanhamento;
    private String bebida;

    public Pedido(ComboFactory factory) {
        this.lanche = factory.prepararLanche();
        this.acompanhamento = factory.prepararAcompanhamento();
        this.bebida = factory.prepararBebida();
    }

    public Hamburguer getLanche() {
        return lanche;
    }

}
