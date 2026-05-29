package org.example;

public class HamburguerEspecialFactory implements HamburguerFactory {

    private static HamburguerEspecialFactory instance;

    private HamburguerEspecialFactory() {
    }

    public static HamburguerEspecialFactory getInstance() {
        if (instance == null) {
            instance = new HamburguerEspecialFactory();
        }
        return instance;
    }

    @Override
    public Hamburguer prepararLanche() {
        Hamburguer lanche = new CarneAngus(new HamburguerBase("Pão Brioche", 8.0), new MalPassado());
        lanche = HamburguerDecoratorFactory.getInstance().obterIngrediente("Queijo", lanche);
        lanche = HamburguerDecoratorFactory.getInstance().obterIngrediente("Bacon", lanche);
        lanche = HamburguerDecoratorFactory.getInstance().obterIngrediente("Molho", lanche);

        return lanche;
    }

    @Override
    public String aceitar(HamburguerFactoryVisitor visitor) {
        return visitor.exibirHamburguerEspecial(this);
    }

}