package org.example;

public abstract class Carne extends HamburguerDecorator {

    private PontoCarne ponto;

    public Carne(Hamburguer hamburguer, PontoCarne pontoCarne) {
        super(hamburguer);
        this.ponto = pontoCarne;
    }

    public PontoCarne getPonto() {
        return ponto;
    }

    public void setPontoCarne(PontoCarne pontoCarne) {
        this.ponto = pontoCarne;
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " + Carne " + getNomeCarne() + " (" + getPonto().getPontoCarne() + ")";    }

    public abstract String getNomeCarne();

}
