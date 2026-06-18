package org.example;

public class Molho extends Ingrediente {

    public Molho(Lanche lanche) {
        super(lanche);
    }

    @Override
    public String getNomeIngrediente() {
        return "Molho";
    }

    @Override
    public double getPrecoIngrediente() {
        return 1.00;
    }

}
