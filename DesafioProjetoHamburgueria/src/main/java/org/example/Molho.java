package org.example;

public class Molho extends HamburguerDecorator{

    public Molho(Hamburguer hamburguer) {
        super(hamburguer);
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " + Molho";
    }

    @Override
    public double getPrecoIngrediente() {
        return 1.00;
    }

}
