package org.example;

public class CarneAcem extends Carne {

    public CarneAcem(Hamburguer hamburguer, PontoCarne ponto) {
        super(hamburguer, ponto);
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