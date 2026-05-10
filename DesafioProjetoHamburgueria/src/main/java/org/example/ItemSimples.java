package org.example;

public class ItemSimples extends ItemCardapio {

    private double preco;

    public ItemSimples(String descricao, double preco) {
        super(descricao);
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String getConteudo() {
        return getDescricao() + " - R$ " + preco + "\n";
    }

}
