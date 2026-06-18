package org.example;

public interface LancheFactory {

    Lanche prepararLanche();
    String aceitar(LancheFactoryVisitor visitor);

}