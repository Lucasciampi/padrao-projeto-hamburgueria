package org.example;

public class Suco implements Bebida {

    @Override
    public String getDescricao() {
        return "Suco Natural";
    }

    @Override
    public double getPreco() {
        return 7.0;
    }
}
