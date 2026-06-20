package org.example;

public class ComboBasicoFactory implements ComboFactory {

    private static ComboBasicoFactory instance;

    private ComboBasicoFactory() {}

    public static ComboBasicoFactory getInstance() {
        if (instance == null) {
            instance = new ComboBasicoFactory();
        }
        return instance;
    }

    @Override
    public Lanche prepararLanche() {
        return LancheBasicoFactory.getInstance().prepararLanche();
    }

    @Override
    public Bebida prepararBebida() {
        return new Refrigerante();
    }
}
