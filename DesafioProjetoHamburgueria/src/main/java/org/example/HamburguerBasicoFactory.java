package org.example;

public class HamburguerBasicoFactory implements HamburguerFactory {

    private static HamburguerBasicoFactory instance;


    private HamburguerBasicoFactory() {}

    public static HamburguerBasicoFactory getInstance() {
        if (instance == null) {
            instance = new HamburguerBasicoFactory();
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
    public String aceitar(HamburguerFactoryVisitor visitor) {
        return visitor.exibirHamburguerBasico(this);
    }

}
