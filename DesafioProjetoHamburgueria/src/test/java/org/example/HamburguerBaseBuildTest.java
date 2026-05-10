package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HamburguerBaseBuildTest {

    @Test
    void deveRetornarExcecaoParaHamburguerBaseSemDescricao() {
        try {
            HamburguerBaseBuild hamburguerBaseBuild = new HamburguerBaseBuild();
            HamburguerBase hamburguerBase = hamburguerBaseBuild
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
            HamburguerBaseBuild hamburguerBaseBuild = new HamburguerBaseBuild();
            HamburguerBase hamburguerBase = hamburguerBaseBuild
                    .setDescricao("Pão de Batata")
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Preço inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarHamburguerBaseValido() {
        HamburguerBaseBuild hamburguerBaseBuild = new HamburguerBaseBuild();
        HamburguerBase hamburguerBase = hamburguerBaseBuild
                .setDescricao("Pão de Batata")
                .setPreco(10.0)
                .build();
        assertNotNull(hamburguerBase);
    }

}