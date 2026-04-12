package org.example;

public class ComboEspecialFactory implements ComboFactory {

    private static ComboEspecialFactory instance;

    private ComboEspecialFactory() {
    }

    public static ComboEspecialFactory getInstance() {
        if (instance == null) {
            instance = new ComboEspecialFactory();
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
    public String prepararAcompanhamento() {
        return "Batata Rústica";
    }

    @Override
    public String prepararBebida() {
        return "Milkshake";
    }
}