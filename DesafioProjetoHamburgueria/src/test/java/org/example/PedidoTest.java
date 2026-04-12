package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PedidoTest {

    @Test
    public void deveRetornarDescricaoDoComboEspecial() {
        ComboFactory factory = ComboEspecialFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        String descricaoEsperada = "Pão Brioche + Carne Angus (Mal Passado) + Queijo + Bacon + Molho";
        assertEquals(descricaoEsperada, pedido.getLanche().getDescricao());
    }

    @Test
    public void deveRetornarPrecoDoComboEspecial() {
        ComboFactory factory = ComboEspecialFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        assertEquals(27.00, pedido.getLanche().getPreco());
    }

    @Test
    public void deveRetornarDescricaomDoComboBasico() {
        ComboFactory factory = ComboBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);

        String descricaoEsperada = "Pão de Batata + Carne Acém (Ao Ponto) + Queijo + Alface";
        assertEquals(descricaoEsperada, pedido.getLanche().getDescricao());
    }

    @Test
    public void deveRetornarPrecoDoComboBasico() {
        ComboFactory factory = ComboBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        assertEquals(14.50, pedido.getLanche().getPreco());
    }
}