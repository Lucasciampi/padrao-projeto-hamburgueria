package org.example;

public class CarneAngus extends Carne{

    public CarneAngus(Lanche lanche, PontoCarne pontoCarne) {
        super(lanche, pontoCarne);
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
