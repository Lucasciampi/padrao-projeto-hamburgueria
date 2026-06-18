package org.example;

public class Molho extends LancheDecorator {

    public Molho(Lanche lanche) {
        super(lanche);
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
