package org.example;

public class PrecoBRL implements IPreco {

    private double preco;

    @Override
    public double getPreco() {
        return this.preco;
    }

    @Override
    public void setPreco(double preco) {
        this.preco = preco;
    }

}
