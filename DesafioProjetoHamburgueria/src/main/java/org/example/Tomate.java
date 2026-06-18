package org.example;

public class Tomate extends Ingrediente {

    public Tomate(Lanche lanche) {
        super(lanche);
    }

    @Override
    public String getNomeIngrediente() {
        return "Tomate";
    }

    public double getPrecoIngrediente() {
        return 0.50;
    }
}
