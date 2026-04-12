package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HamburguerDecoratorFactoryTest {

    @Test
    void deveRetornarExcecaoParaChamadoInexistente() {
        try {
            Hamburguer chamado = HamburguerDecoratorFactory.getInstance().obterIngrediente("Carne de Frango", new HamburguerBase());
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Tipo de Ingrediente do Hamburguer não encontrado.", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaChamadoInvalido() {
        try {
            Hamburguer chamado = HamburguerDecoratorFactory.getInstance().obterIngrediente("Tomate", new HamburguerBase());
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Ingrediente inválido.", e.getMessage());
        }
    }


}