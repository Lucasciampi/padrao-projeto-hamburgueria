package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LancheDecoratorFactoryTest {

    @Test
    void deveRetornarExcecaoParaIngredienteInexistente() {
        try {
            LancheDecoratorFactory.getInstance().obterIngrediente("Carne de Frango", new LancheBase());
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Tipo de Ingrediente do Lanche não encontrado.", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaIngredienteInvalido() {
        try {
            LancheDecoratorFactory.getInstance().obterIngrediente("Tomate", new LancheBase());
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Ingrediente inválido.", e.getMessage());
        }
    }


}