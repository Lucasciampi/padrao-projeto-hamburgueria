package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GrelhaTest {

    private Grelha grelha;

    @BeforeEach
    void setUp() {
        grelha = new Grelha();
    }

    @Test
    void deveRetornarCarnes() {
        grelha.adicionarCarne(
                new HamburguerBaseBuilder().setDescricao("Pão Brioche").setPreco(8.0).build(),
                "CarneAngus", "MalPassado");
        grelha.adicionarCarne(
                new HamburguerBaseBuilder().setDescricao("Pão de Batata").setPreco(4.0).build(),
                "CarneAcem", "AoPonto");
        grelha.adicionarCarne(
                new HamburguerBaseBuilder().setDescricao("Pão Brioche").setPreco(8.0).build(),
                "CarneAngus", "MalPassado");

        List<String> saida = Arrays.asList(
                "Pão Brioche + Carne Angus (Mal Passado)",
                "Pão de Batata + Carne Acém (Ao Ponto)",
                "Pão Brioche + Carne Angus (Mal Passado)"
        );

        assertEquals(saida, grelha.obterCarnes());
    }

    @Test
    void deveRetornarTotalPontos() {
        grelha.adicionarCarne(
                new HamburguerBaseBuilder().setDescricao("Pão Brioche").setPreco(8.0).build(),
                "CarneAngus", "MalPassado");
        grelha.adicionarCarne(
                new HamburguerBaseBuilder().setDescricao("Pão de Batata").setPreco(4.0).build(),
                "CarneAcem", "AoPonto");
        grelha.adicionarCarne(
                new HamburguerBaseBuilder().setDescricao("Pão Brioche").setPreco(8.0).build(),
                "CarneAngus", "MalPassado");

        assertEquals(2, PontoCarneFactory.getTotalPontos());
    }

    @Test
    void deveRetornarExcecaoParaPontoInexistente() {
        try {
            grelha.adicionarCarne(
                    new HamburguerBaseBuilder().setDescricao("Pão Brioche").setPreco(8.0).build(),
                    "CarneAngus", "Grelhado");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Ponto de carne não encontrado: Grelhado", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaCarneInexistente() {
        try {
            grelha.adicionarCarne(
                    new HamburguerBaseBuilder().setDescricao("Pão Brioche").setPreco(8.0).build(),
                    "CarneFrango", "AoPonto");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Carne não encontrada: CarneFrango", e.getMessage());        }
    }



}