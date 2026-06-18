package org.example;

public abstract class Ingrediente extends LancheDecorator {

    public Ingrediente(Lanche lanche) {
        super(lanche);
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " + " + getNomeIngrediente();
    }

    public abstract String getNomeIngrediente();

}
