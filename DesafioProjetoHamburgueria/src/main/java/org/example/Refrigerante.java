package org.example;

public class Refrigerante implements Bebida {

    @Override
    public String getDescricao() {
        return "Refrigerante";
    }

    @Override
    public double getPreco() {
        return 5.0;
    }
}
