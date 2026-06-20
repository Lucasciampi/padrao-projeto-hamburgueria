package org.example;

public class ComboEspecialFactory implements ComboFactory {

    private static ComboEspecialFactory instance;

    private ComboEspecialFactory() {}

    public static ComboEspecialFactory getInstance() {
        if (instance == null) {
            instance = new ComboEspecialFactory();
        }
        return instance;
    }

    @Override
    public Lanche prepararLanche() {
        return LancheEspecialFactory.getInstance().prepararLanche();
    }

    @Override
    public Bebida prepararBebida() {
        return new Suco();
    }
}
