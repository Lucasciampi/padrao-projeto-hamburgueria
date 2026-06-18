package org.example;

public class CarneAcem extends Carne {

    public CarneAcem(Lanche lanche, PontoCarne ponto) {
        super(lanche, ponto);
    }

    @Override
    public String getNomeCarne() {
        return "Acém";
    }

    @Override
    public double getPrecoIngrediente() {
        return 8.00;
    }

}