package org.example;

public interface HamburguerFactoryVisitor {

    String exibirHamburguerBasico(HamburguerBasicoFactory factory);
    String exibirHamburguerEspecial(HamburguerEspecialFactory factory);

}
