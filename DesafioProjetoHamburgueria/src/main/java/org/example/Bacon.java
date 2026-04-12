package org.example;

public class Bacon extends HamburguerDecorator {

    public Bacon(Hamburguer hamburguer) {
        super(hamburguer);
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " + Bacon";
    }

    @Override
    public double getPrecoIngrediente() {
        return 4.00;
    }
}
