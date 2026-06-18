package org.example;

public class Alface extends LancheDecorator {

    public Alface(Lanche lanche) {
        super(lanche);
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
