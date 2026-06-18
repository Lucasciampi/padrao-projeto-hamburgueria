package org.example;

public class CarnePeito extends Carne {

    public CarnePeito(Lanche lanche, PontoCarne ponto) {
        super(lanche, ponto);
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