package org.example;

public interface HamburguerFactory {

    Hamburguer prepararLanche();
    String aceitar(HamburguerFactoryVisitor visitor);

}