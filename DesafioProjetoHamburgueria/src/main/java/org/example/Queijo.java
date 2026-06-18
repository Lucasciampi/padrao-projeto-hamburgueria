package org.example;

public class Queijo extends LancheDecorator {

    public Queijo(Lanche lanche) {
        super(lanche);
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " + Queijo";
    }

    @Override
    public double getPrecoIngrediente() {
        return 2.00;
    }

}
