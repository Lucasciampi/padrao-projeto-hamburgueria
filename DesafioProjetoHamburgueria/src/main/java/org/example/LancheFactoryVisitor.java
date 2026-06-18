package org.example;

public interface LancheFactoryVisitor {

    String exibirLancheBasico(LancheBasicoFactory factory);
    String exibirLancheEspecial(LancheEspecialFactory factory);

}
