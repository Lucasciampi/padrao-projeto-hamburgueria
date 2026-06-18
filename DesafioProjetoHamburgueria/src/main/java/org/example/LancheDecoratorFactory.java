package org.example;

public class LancheDecoratorFactory {

    private static LancheDecoratorFactory instance;

    private LancheDecoratorFactory() {}

    public static LancheDecoratorFactory getInstance() {
        if (instance == null) {
            instance = new LancheDecoratorFactory();
        }
        return instance;
    }

    public Lanche obterIngrediente(String ingrediente, Lanche lanche){

        Class classe = null;
        Object objeto = null;

        try {
            classe = Class.forName("org.example." + ingrediente);
            objeto = classe.getDeclaredConstructor(Lanche.class).newInstance(lanche);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Tipo de Ingrediente do Lanche não encontrado.");
        }
        if (!(objeto instanceof Lanche)) {
            throw new IllegalArgumentException("Ingrediente inválido.");
        }
        return (Lanche) objeto;
    }

}
