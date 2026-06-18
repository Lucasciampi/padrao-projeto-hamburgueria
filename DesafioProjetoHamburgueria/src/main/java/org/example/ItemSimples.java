package org.example;

public class ItemSimples extends ItemCardapio {

    private Lanche lanche;

    public ItemSimples(Lanche lanche) {
        super(lanche.getDescricao());
        this.lanche = lanche;
    }

    public double getPreco() {
        return lanche.getPreco();
    }

    @Override
    public String getConteudo() {
        return getDescricao() + " - R$ " + getPreco() + "\n";
    }

}
