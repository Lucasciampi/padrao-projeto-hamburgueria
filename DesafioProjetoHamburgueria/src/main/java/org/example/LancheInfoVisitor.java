package org.example;

public class LancheInfoVisitor implements LancheFactoryVisitor {

    public String exibir(LancheFactory factory) {
        return factory.aceitar(this);
    }

    @Override
    public String exibirLancheBasico(LancheBasicoFactory factory) {
        Lanche lanche = factory.prepararLanche();
        return "Lanche Basico{" +
                "descricao = " + lanche.getDescricao() + "" +
                ", preco = " + lanche.getPreco() +
                "}";
    }

    @Override
    public String exibirLancheEspecial(LancheEspecialFactory factory) {
        Lanche lanche = factory.prepararLanche();
        return "Lanche Especial{" +
                "descricao = " + lanche.getDescricao() + "" +
                ", preco = " + lanche.getPreco() +
                "}";
    }

}
