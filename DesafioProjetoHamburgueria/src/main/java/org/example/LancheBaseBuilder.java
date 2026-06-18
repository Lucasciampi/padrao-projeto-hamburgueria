package org.example;

public class LancheBaseBuilder {

    private LancheBase lancheBase;

    public LancheBaseBuilder() {
        this.lancheBase = new LancheBase();
    }

    public LancheBase build() {
        if (lancheBase.getDescricao() == null) {
            throw new IllegalArgumentException("Descrição inválida");
        }
        if (lancheBase.getPreco() <= 0) {
            throw new IllegalArgumentException("Preço inválido");
        }
        return lancheBase;
    }

    public LancheBaseBuilder setDescricao(String descricao) {
        lancheBase.setDescricao(descricao);
        return this;
    }

    public LancheBaseBuilder setPreco(double preco) {
        lancheBase.setPreco(preco);
        return this;
    }


}
