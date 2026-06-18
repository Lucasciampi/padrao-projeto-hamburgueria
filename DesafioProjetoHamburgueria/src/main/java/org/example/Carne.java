package org.example;

public abstract class Carne extends LancheDecorator {

    private PontoCarne ponto;

    public Carne(Lanche lanche, PontoCarne pontoCarne) {
        super(lanche);
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
