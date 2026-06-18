package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardapioTest {

    @Test
    void deveRetornarCardapioCompleto() {
        CategoriaCardapio bebidas = new CategoriaCardapio("Bebidas");
        ItemSimples refrigerante = new ItemSimples(new LancheBase("Refrigerante", 2.50));
        bebidas.addItem(refrigerante);

        CategoriaCardapio hamburgueres = new CategoriaCardapio("Hambúrgueres");
        ItemSimples hamgurguerBasico = new ItemSimples(LancheBasicoFactory.getInstance().prepararLanche());
        ItemSimples hamgurguerEspecial = new ItemSimples(LancheEspecialFactory.getInstance().prepararLanche());
        hamburgueres.addItem(hamgurguerBasico);
        hamburgueres.addItem(hamgurguerEspecial);

        CategoriaCardapio acompanhamento = new CategoriaCardapio("Acompanhamento");
        ItemSimples batataFrita = new ItemSimples(new LancheBase("Batata Frita", 4.00));
        ItemSimples batataRustica = new ItemSimples(new LancheBase("Batata Rústica", 6.00));
        acompanhamento.addItem(batataFrita);
        acompanhamento.addItem(batataRustica);

        CategoriaCardapio itemsCardapio = new CategoriaCardapio("Cardapio da Hamburgueria");
        itemsCardapio.addItem(bebidas);
        itemsCardapio.addItem(hamburgueres);
        itemsCardapio.addItem(acompanhamento);

        Cardapio cardapio = new Cardapio();
        cardapio.setItemCardapio(itemsCardapio);

        assertEquals("""
                Categoria: Cardapio da Hamburgueria
                Categoria: Bebidas
                Refrigerante - R$ 2.5
                Categoria: Hambúrgueres
                Hamburguer Basico: Pão de Batata + Carne Acém (Ao Ponto) + Queijo + Alface - R$ 14.5
                Hamburguer Especial: Pão Brioche + Carne Angus (Mal Passado) + Queijo + Bacon + Molho - R$ 27.0
                Categoria: Acompanhamento
                Batata Frita - R$ 4.0
                Batata Rústica - R$ 6.0
                """, cardapio.getCardapio());

    }

    @Test
    void deveRetornarCardapioSemItems() {
        try {
            Cardapio cardapio = new Cardapio();
            cardapio.getCardapio();
            fail();
        }
        catch (NullPointerException e) {
            assertEquals("Cardápio não pode ser nulo", e.getMessage());
        }
    }

}