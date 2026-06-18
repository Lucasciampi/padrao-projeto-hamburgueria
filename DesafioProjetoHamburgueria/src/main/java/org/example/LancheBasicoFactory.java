package org.example;

public class LancheBasicoFactory implements LancheFactory {

    private static LancheBasicoFactory instance;


    private LancheBasicoFactory() {}

    public static LancheBasicoFactory getInstance() {
        if (instance == null) {
            instance = new LancheBasicoFactory();
        }
        return instance;
    }

    @Override
    public Lanche prepararLanche() {
        Lanche lanche = new CarneAcem(new LancheBase("Hamburguer Basico: Pão de Batata", 4.0), new AoPonto());
        lanche = LancheDecoratorFactory.getInstance().obterIngrediente("Queijo", lanche);
        lanche = LancheDecoratorFactory.getInstance().obterIngrediente("Alface", lanche);
        lanche = LancheDecoratorFactory.getInstance().obterIngrediente("Tomate", lanche);

        return lanche;
    }

    @Override
    public String aceitar(LancheFactoryVisitor visitor) {
        return visitor.exibirLancheBasico(this);
    }

}
