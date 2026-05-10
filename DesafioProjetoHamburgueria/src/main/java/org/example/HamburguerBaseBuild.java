package org.example;

public class HamburguerBaseBuild {

    private HamburguerBase hamburguerBase;

    public HamburguerBaseBuild() {
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

    public HamburguerBaseBuild setDescricao(String descricao) {
        hamburguerBase.setDescricao(descricao);
        return this;
    }

    public HamburguerBaseBuild setPreco(double preco) {
        hamburguerBase.setPreco(preco);
        return this;
    }


}
