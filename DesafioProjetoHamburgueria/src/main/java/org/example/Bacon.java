package org.example;

public class Bacon extends Ingrediente {

    public Bacon(Lanche lanche) {
        super(lanche);
    }

    @Override
    public String getNomeIngrediente() {
        return "Bacon";
    }

    @Override
    public double getPrecoIngrediente() {
        return 4.00;
    }
}
