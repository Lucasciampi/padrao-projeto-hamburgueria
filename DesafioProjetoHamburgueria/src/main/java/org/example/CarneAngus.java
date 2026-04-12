package org.example;

public class CarneAngus extends Carne{

    public CarneAngus(Hamburguer hamburguer, PontoCarne pontoCarne) {
        super(hamburguer, pontoCarne);
    }

    @Override
    public String getNomeCarne() {
        return "Angus";
    }

    @Override
    public double getPrecoIngrediente() {
        return 12.0;
    }

}
