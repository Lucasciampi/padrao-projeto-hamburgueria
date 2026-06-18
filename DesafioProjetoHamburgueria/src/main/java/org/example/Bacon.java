package org.example;

public class Bacon extends LancheDecorator {

    public Bacon(Lanche lanche) {
        super(lanche);
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
