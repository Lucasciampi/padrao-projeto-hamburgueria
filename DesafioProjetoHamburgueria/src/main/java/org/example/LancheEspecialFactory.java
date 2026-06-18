package org.example;

public class LancheEspecialFactory implements LancheFactory {

    private static LancheEspecialFactory instance;

    private LancheEspecialFactory() {
    }

    public static LancheEspecialFactory getInstance() {
        if (instance == null) {
            instance = new LancheEspecialFactory();
        }
        return instance;
    }

    @Override
    public Lanche prepararLanche() {
        Lanche lanche = new CarneAngus(new LancheBase("Hamburguer Especial: Pão Brioche", 8.0), new MalPassado());
        lanche = LancheDecoratorFactory.getInstance().obterIngrediente("Queijo", lanche);
        lanche = LancheDecoratorFactory.getInstance().obterIngrediente("Bacon", lanche);
        lanche = LancheDecoratorFactory.getInstance().obterIngrediente("Molho", lanche);

        return lanche;
    }

    @Override
    public String aceitar(LancheFactoryVisitor visitor) {
        return visitor.exibirLancheEspecial(this);
    }

}