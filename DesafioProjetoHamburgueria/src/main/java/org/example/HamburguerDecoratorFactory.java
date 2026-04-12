package org.example;

public class HamburguerDecoratorFactory {

    private static HamburguerDecoratorFactory instance;

    private HamburguerDecoratorFactory() {}

    public static HamburguerDecoratorFactory getInstance() {
        if (instance == null) {
            instance = new HamburguerDecoratorFactory();
        }
        return instance;
    }

    public Hamburguer obterIngrediente(String ingrediente, Hamburguer hamburguer){

        Class classe = null;
        Object objeto = null;

        try {
            classe = Class.forName("org.example." + ingrediente);
            objeto = classe.getDeclaredConstructor(Hamburguer.class).newInstance(hamburguer);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Tipo de Ingrediente do Hamburguer não encontrado.");
        }
        if (!(objeto instanceof Hamburguer)) {
            throw new IllegalArgumentException("Ingrediente inválido.");
        }
        return (Hamburguer) objeto;
    }

}
