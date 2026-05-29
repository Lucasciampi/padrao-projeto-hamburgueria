package org.example;

public class HamburguerInfoVisitor implements HamburguerFactoryVisitor {

    public String exibir(HamburguerFactory factory) {
        return factory.aceitar(this);
    }

    @Override
    public String exibirHamburguerBasico(HamburguerBasicoFactory factory) {
        Hamburguer lanche = factory.prepararLanche();
        return "HamburguerBasico{" +
                "descricao = '" + lanche.getDescricao() + "'" +
                ", preco = " + lanche.getPreco() +
                "}";
    }

    @Override
    public String exibirHamburguerEspecial(HamburguerEspecialFactory factory) {
        Hamburguer lanche = factory.prepararLanche();
        return "HamburguerEspecial{" +
                "descricao = '" + lanche.getDescricao() + "'" +
                ", preco = " + lanche.getPreco() +
                "}";
    }

}
