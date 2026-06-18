package org.example;

public class Alface extends Ingrediente {

    public Alface(Lanche lanche) {
        super(lanche);
    }

    @Override
    public String getNomeIngrediente() {
        return "Alface";
    }

    @Override
    public double getPrecoIngrediente() {
        return 0.50;
    }
}
