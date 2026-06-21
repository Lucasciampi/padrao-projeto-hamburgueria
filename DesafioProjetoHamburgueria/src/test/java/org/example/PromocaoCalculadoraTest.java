package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PromocaoCalculadoraTest {

    @Test
    void deveCalcularValorComDescontoEAcrescimo() {
        // promoção: 20% de desconto + taxa fixa de 2 reais
        String formula = "valor * 0.8 + 2";
        assertEquals(23.6, PromocaoCalculadora.calcularValorComPromocao(27.0, formula));
    }

    @Test
    void deveCalcularValorComFormulaSimples() {
        String formula = "valor - 5";
        assertEquals(22.0, PromocaoCalculadora.calcularValorComPromocao(27.0, formula));
    }

}