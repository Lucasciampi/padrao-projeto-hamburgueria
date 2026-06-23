package org.example;

public class CarnePatinho extends Carne {

    public CarnePatinho(Lanche lanche, PontoCarne ponto) {
        super(lanche, ponto);
    }

    @Override
    public String getNomeCarne() {
        return "Patinho";
    }

    @Override
    public double getPrecoIngrediente() {
        return 8.00;
    }

}