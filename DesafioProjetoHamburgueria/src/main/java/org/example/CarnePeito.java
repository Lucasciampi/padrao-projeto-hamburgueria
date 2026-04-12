package org.example;

public class CarnePeito extends Carne {

    public CarnePeito(Hamburguer hamburguer, PontoCarne ponto) {
        super(hamburguer, ponto);
    }

    @Override
    public String getNomeCarne() {
        return "Peito";
    }

    @Override
    public double getPrecoIngrediente() {
        return 10.00;
    }

}