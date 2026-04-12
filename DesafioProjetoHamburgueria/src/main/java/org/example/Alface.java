package org.example;

public class Alface extends HamburguerDecorator {

    public Alface(Hamburguer hamburguer) {
        super(hamburguer);
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " + Alface";
    }

    @Override
    public double getPrecoIngrediente() {
        return 0.50;
    }
}
