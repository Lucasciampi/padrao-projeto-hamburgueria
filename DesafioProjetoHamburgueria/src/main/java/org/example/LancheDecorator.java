package org.example;

public abstract class LancheDecorator implements Lanche {

    private Lanche lanche;

    public LancheDecorator(Lanche lanche){
            this.lanche = lanche;
    }

    public Lanche getLanche() {
        return lanche;
    }
    public void setLanche(Lanche lanche) {
        this.lanche = lanche;
    }

    public String getDescricao() {
        return this.lanche.getDescricao();
    }

    public double getPreco() {
        return this.lanche.getPreco() + getPrecoIngrediente();
    }

    public abstract double getPrecoIngrediente();

}
