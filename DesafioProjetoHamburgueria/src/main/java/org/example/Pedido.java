package org.example;

public class Pedido {

    private Hamburguer lanche;

    public Pedido(HamburguerFactory factory) {
        this.lanche = factory.prepararLanche();
    }

    public Hamburguer getLanche() {
        return lanche;
    }

}
