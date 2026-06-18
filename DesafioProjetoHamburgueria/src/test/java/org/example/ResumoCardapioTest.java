package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResumoCardapioTest {

    private CategoriaCardapio categoria;

    @BeforeEach
    void setUp() {
        categoria = new CategoriaCardapio("Hambúrgueres");
        categoria.addItem(new ItemSimples(new LancheBase("HamgurguerEspecial", 27.0)));
        categoria.addItem(new ItemSimples(new LancheBase("HamgurguerBasico", 14.5)));
        categoria.addItem(new ItemSimples(new LancheBase("X-Tudo", 32.0)));
        categoria.addItem(new ItemSimples(new LancheBase("X-Salada", 10.0)));
    }

    @Test
    void deveContarTotalItens() {
        assertEquals(4, ResumoCardapio.contarTotalItens(categoria));
    }

    @Test
    void deveContarItensAcimaDe() {
        assertEquals(2, ResumoCardapio.contarItensAcimaDe(categoria, 20.0));
    }

}