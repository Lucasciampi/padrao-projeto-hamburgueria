package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LancheInfoVisitorTest {

    private LancheInfoVisitor visitor;

    @BeforeEach
    void setUp() {
        visitor = new LancheInfoVisitor();
    }

    @Test
    void deveExibirLancheBasico() {
        assertEquals("Lanche Basico{descricao = Hamburguer Basico: Pão de Batata + Carne Patinho (Ao Ponto) + Queijo + Alface + Tomate, preco = 15.0}",
                visitor.exibir(LancheBasicoFactory.getInstance()));
    }

    @Test
    void deveExibirLancheEspecial() {
        assertEquals("Lanche Especial{descricao = Hamburguer Especial: Pão Brioche + Carne Angus (Mal Passado) + Queijo + Bacon + Molho, preco = 27.0}",
                visitor.exibir(LancheEspecialFactory.getInstance()));
    }

}