package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LancheBaseBuilderTest {

    private LancheBaseBuilder lancheBaseBuilder;

    @BeforeEach
    void setUp() {
        lancheBaseBuilder = new LancheBaseBuilder();
    }

    @Test
    void deveRetornarExcecaoParaLancheBaseSemDescricao() {
        try {
            lancheBaseBuilder.setPreco(10.0).build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Descrição inválida", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaLancheBaseSemPreco() {
        try {
            lancheBaseBuilder.setDescricao("Pão de Batata").build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Preço inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarLancheBaseValido() {
        LancheBase lancheBase = lancheBaseBuilder
                .setDescricao("Pão de Batata")
                .setPreco(10.0)
                .build();
        assertNotNull(lancheBase);
    }

}