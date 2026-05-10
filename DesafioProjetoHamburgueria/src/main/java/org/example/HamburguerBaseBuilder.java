package org.example;

public class HamburguerBaseBuilder {

    private HamburguerBase hamburguerBase;

    public HamburguerBaseBuilder() {
        this.hamburguerBase = new HamburguerBase();
    }

    public HamburguerBase build() {
        if (hamburguerBase.getDescricao() == null) {
            throw new IllegalArgumentException("Descrição inválida");
        }
        if (hamburguerBase.getPreco() <= 0) {
            throw new IllegalArgumentException("Preço inválido");
        }
        return hamburguerBase;
    }

    public HamburguerBaseBuilder setDescricao(String descricao) {
        hamburguerBase.setDescricao(descricao);
        return this;
    }

    public HamburguerBaseBuilder setPreco(double preco) {
        hamburguerBase.setPreco(preco);
        return this;
    }


}
