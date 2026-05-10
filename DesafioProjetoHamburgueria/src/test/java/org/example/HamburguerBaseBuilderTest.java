package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HamburguerBaseBuilderTest {

    private HamburguerBaseBuilder hamburguerBaseBuilder;

    @BeforeEach
    void setUp() {
        hamburguerBaseBuilder = new HamburguerBaseBuilder();
    }

    @Test
    void deveRetornarExcecaoParaHamburguerBaseSemDescricao() {
        try {
            HamburguerBase hamburguerBase = hamburguerBaseBuilder
                    .setPreco(10.0)
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Descrição inválida", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaHamburguerBaseSemPreco() {
        try {
            HamburguerBase hamburguerBase = hamburguerBaseBuilder
                    .setDescricao("Pão de Batata")
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Preço inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarHamburguerBaseValido() {
        HamburguerBase hamburguerBase = hamburguerBaseBuilder
                .setDescricao("Pão de Batata")
                .setPreco(10.0)
                .build();
        assertNotNull(hamburguerBase);
    }

}