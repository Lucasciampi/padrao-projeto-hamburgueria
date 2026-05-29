package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HamburguerInfoVisitorTest {

    private  HamburguerInfoVisitor visitor;

    @BeforeEach
    void setUp() {
        visitor = new HamburguerInfoVisitor();
    }


    @Test
    void deveExibirHamburguerBasico() {
        assertEquals("HamburguerBasico{descricao = 'Pão de Batata + Carne Acém (Ao Ponto) + Queijo + Alface', preco = 14.5}",
                visitor.exibir(HamburguerBasicoFactory.getInstance()));
    }

    @Test
    void deveExibirHamburguerEspecial() {
        assertEquals("HamburguerEspecial{descricao = 'Pão Brioche + Carne Angus (Mal Passado) + Queijo + Bacon + Molho', preco = 27.0}",
                visitor.exibir(HamburguerEspecialFactory.getInstance()));
    }

}