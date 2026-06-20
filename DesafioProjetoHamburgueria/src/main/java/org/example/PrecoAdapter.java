package org.example;

public class PrecoAdapter extends PrecoPontos {

    private IPreco precoBRL;
    private static final double CONVERSAO = 10;

    public PrecoAdapter(IPreco precoBRL) {
        this.precoBRL = precoBRL;
    }

    public void salvarPreco() {
        this.setPontos((int) (precoBRL.getPreco() * CONVERSAO));
    }

    public double recuperarPreco() {
        this.precoBRL.setPreco(this.getPontos() / CONVERSAO);
        return precoBRL.getPreco();
    }

}
