package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardapioTest {

    @Test
    void deveRetornarCardapioCompleto() {
        CategoriaCardapio categoriaCardapio1 = new CategoriaCardapio("Bebidas");
        ItemSimples itemSimples11 = new ItemSimples("Refrigerante", 2.50);
        categoriaCardapio1.addItem(itemSimples11);

        CategoriaCardapio categoriaCardapio2 = new CategoriaCardapio("Hambúrgueres");
        ItemSimples itemSimples21 = new ItemSimples("HamgurguerBasico", 14.50);
        ItemSimples itemSimples22 = new ItemSimples("HamgurguerPremium", 27.00);
        categoriaCardapio2.addItem(itemSimples21);
        categoriaCardapio2.addItem(itemSimples22);

        CategoriaCardapio categoriaCardapio3 = new CategoriaCardapio("Acompanhamento");
        ItemSimples itemSimples31 = new ItemSimples("Batata Frita", 4.00);
        ItemSimples itemSimples32 = new ItemSimples("Batata Rustica", 6.00);
        categoriaCardapio3.addItem(itemSimples31);
        categoriaCardapio3.addItem(itemSimples32);

        CategoriaCardapio itemsCardapio = new CategoriaCardapio("Cardapio da Hamburgueria");
        itemsCardapio.addItem(categoriaCardapio1);
        itemsCardapio.addItem(categoriaCardapio2);
        itemsCardapio.addItem(categoriaCardapio3);

        Cardapio cardapio = new Cardapio();
        cardapio.setItemCardapio(itemsCardapio);

        assertEquals("Categoria: Cardapio da Hamburgueria\n" +
                "Categoria: Bebidas\n" +
                "Refrigerante - R$ 2.5\n" +
                "Categoria: Hambúrgueres\n" +
                "HamgurguerBasico - R$ 14.5\n" +
                "HamgurguerPremium - R$ 27.0\n" +
                "Categoria: Acompanhamento\n" +
                "Batata Frita - R$ 4.0\n" +
                "Batata Rustica - R$ 6.0\n", cardapio.getCardapio());

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