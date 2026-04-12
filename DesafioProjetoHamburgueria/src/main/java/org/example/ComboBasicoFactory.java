package org.example;

public class ComboBasicoFactory implements ComboFactory{

    private static ComboBasicoFactory instance;


    private ComboBasicoFactory() {}

    public static ComboBasicoFactory getInstance() {
        if (instance == null) {
            instance = new ComboBasicoFactory();
        }
        return instance;
    }

    @Override
    public Hamburguer prepararLanche() {
        Hamburguer lanche = new CarneAcem(new HamburguerBase("Pão de Batata", 4.0), new AoPonto());
        lanche = HamburguerDecoratorFactory.getInstance().obterIngrediente("Queijo", lanche);
        lanche = HamburguerDecoratorFactory.getInstance().obterIngrediente("Alface", lanche);

        return lanche;
    }

    @Override
    public String prepararAcompanhamento() {
        return "Batata Frita";
    }

    @Override
    public String prepararBebida() {
        return "Refrigerante";
    }

}
