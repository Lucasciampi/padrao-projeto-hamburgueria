package org.example;

public class HamburguerBase implements Hamburguer {
    private String descricao;
    private double preco;

    public HamburguerBase() {}

    public HamburguerBase(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    @Override
    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public double getPreco() {
        return this.preco;
    }

}
