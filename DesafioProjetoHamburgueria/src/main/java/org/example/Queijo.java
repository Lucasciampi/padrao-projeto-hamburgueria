package org.example;

public class Queijo extends Ingrediente {

    public Queijo(Lanche lanche) {
        super(lanche);
    }

    @Override
    public String getNomeIngrediente() {
        return "Queijo";
    }

    @Override
    public double getPrecoIngrediente() {
        return 2.00;
    }

}
