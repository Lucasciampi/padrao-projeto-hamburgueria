package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    @Test
    public void deveRetornarDescricaoDoComboEspecial() {
        HamburguerFactory factory = HamburguerEspecialFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        String descricaoEsperada = "Pão Brioche + Carne Angus (Mal Passado) + Queijo + Bacon + Molho";
        assertEquals(descricaoEsperada, pedido.getLanche().getDescricao());
    }

    @Test
    public void deveRetornarPrecoDoComboEspecial() {
        HamburguerFactory factory = HamburguerEspecialFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        assertEquals(27.00, pedido.getLanche().getPreco());
    }

    @Test
    public void deveRetornarDescricaomDoComboBasico() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        String descricaoEsperada = "Pão de Batata + Carne Acém (Ao Ponto) + Queijo + Alface";
        assertEquals(descricaoEsperada, pedido.getLanche().getDescricao());
    }

    @Test
    public void deveRetornarPrecoDoComboBasico() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        assertEquals(14.50, pedido.getLanche().getPreco());
    }

    // Testes dos Estados de Pedido
    // Pedido aceito

    @Test
    public void naoDeveAceitarPedidoAceito() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoAceito.getInstance());
        assertFalse(pedido.aceitar());
    }

    @Test
    public void devePrepararPedidoAceito() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoAceito.getInstance());
        assertTrue(pedido.preparar());
        assertEquals(PedidoEstadoEmPreparacao.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveFicarProntoPedidoAceito() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoAceito.getInstance());
        assertFalse(pedido.pronto());
    }

    @Test
    public void naoDeveEstarEmRotaPedidoAceito() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoAceito.getInstance());
        assertFalse(pedido.emRota());
    }

    @Test
    public void naoDeveEntregarPedidoAceito() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoAceito.getInstance());
        assertFalse(pedido.entregue());
    }

    @Test
    public void naoDeveDevolverPedidoAceito() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoAceito.getInstance());
        assertFalse(pedido.devolver());
    }

    @Test
    public void naoDeveCancelarPedidoAceito() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoAceito.getInstance());
        assertFalse(pedido.cancelar());
    }

    // Pedido em preparacao

    @Test
    public void naoDeveAceitarPedidoEmPreparacao() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoEmPreparacao.getInstance());
        assertFalse(pedido.aceitar());
    }

    @Test
    public void naoDevePreparPedidoEmPreparacao() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoEmPreparacao.getInstance());
        assertFalse(pedido.preparar());
    }

    @Test
    public void deveFicarProntoPedidoEmPreparacao() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoEmPreparacao.getInstance());
        assertTrue(pedido.pronto());
        assertEquals(PedidoEstadoPronto.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveFicarEmRotaPedidoEmPreparacao() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoEmPreparacao.getInstance());
        assertFalse(pedido.emRota());
    }

    @Test
    public void naoDeveEntregarPedidoEmPreparacao() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoEmPreparacao.getInstance());
        assertFalse(pedido.entregue());
    }

    @Test
    public void naoDeveDevolverPedidoEmPreparacao() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoEmPreparacao.getInstance());
        assertFalse(pedido.devolver());
    }

    @Test
    public void deveCancelarPedidoEmPreparacao() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoEmPreparacao.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    // Pedido pronto

    @Test
    public void naoDeveAceitarPedidoPronto() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoPronto.getInstance());
        assertFalse(pedido.aceitar());
    }

    @Test
    public void naoDevePrepararPedidoPronto() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoPronto.getInstance());
        assertFalse(pedido.preparar());
    }

    @Test
    public void naoDeveFicarProntoPedidoPronto() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoPronto.getInstance());
        assertFalse(pedido.pronto());
    }

    @Test
    public void deveFicarEmRotaPedidoPronto() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoPronto.getInstance());
        assertTrue(pedido.emRota());
        assertEquals(PedidoEstadoEmRota.getInstance(), pedido.getEstado());
    }

    @Test
    public void deveEntregarPedidoPronto() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoPronto.getInstance());
        assertTrue(pedido.entregue());
        assertEquals(PedidoEstadoEntregue.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveDevolverPedidoPronto() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoPronto.getInstance());
        assertFalse(pedido.devolver());
    }

    @Test
    public void deveCancelarPedidoPronto() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoPronto.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    // Pedido em rota

    @Test
    public void naoDeveAceitarPedidoEmRota() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoEmRota.getInstance());
        assertFalse(pedido.aceitar());
    }

    @Test
    public void naoDevePrepararPedidoEmRota() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoEmRota.getInstance());
        assertFalse(pedido.preparar());
    }

    @Test
    public void naoDeveFicarProntoPedidoEmRota() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoEmRota.getInstance());
        assertFalse(pedido.pronto());
    }

    @Test
    public void naoDeveFicarEmRotaPedidoEmRota() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoEmRota.getInstance());
        assertFalse(pedido.emRota());
    }

    @Test
    public void deveEntregarPedidoEmRota() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoEmRota.getInstance());
        assertTrue(pedido.entregue());
        assertEquals(PedidoEstadoEntregue.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveDevolverPedidoEmRota() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoEmRota.getInstance());
        assertFalse(pedido.devolver());
    }

    @Test
    public void deveCancelarPedidoEmRota() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoEmRota.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    // Pedido entregue

    @Test
    public void naoDeveAceitarPedidoEntregue() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.aceitar());
    }

    @Test
    public void naoDevePrepararPedidoEntregue() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.preparar());
    }

    @Test
    public void naoDeveFicarProntoPedidoEntregue() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.pronto());
    }

    @Test
    public void naoDeveFicarEmRotaPedidoEntregue() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.emRota());
    }

    @Test
    public void naoDeveEntregarPedidoEntregue() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.entregue());
    }

    @Test
    public void deveDevolverPedidoEntregue() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertTrue(pedido.devolver());
        assertEquals(PedidoEstadoDevolucao.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveCancelarPedidoEntregue() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.cancelar());
    }

    // Pedido devolucao

    @Test
    public void naoDeveAceitarPedidoDevolucao() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoDevolucao.getInstance());
        assertFalse(pedido.aceitar());
    }

    @Test
    public void naoDevePrepararPedidoDevolucao() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoDevolucao.getInstance());
        assertFalse(pedido.preparar());
    }

    @Test
    public void naoDeveFicarProntoPedidoDevolucao() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoDevolucao.getInstance());
        assertFalse(pedido.pronto());
    }

    @Test
    public void naoDeveFicarEmRotaPedidoDevolucao() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoDevolucao.getInstance());
        assertFalse(pedido.emRota());
    }

    @Test
    public void naoDeveEntregarPedidoDevolucao() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoDevolucao.getInstance());
        assertFalse(pedido.entregue());
    }

    @Test
    public void naoDeveDevolverPedidoDevolucao() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoDevolucao.getInstance());
        assertFalse(pedido.devolver());
    }

    @Test
    public void deveCancelarPedidoDevolucao() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoDevolucao.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    // Pedido cancelado

    @Test
    public void naoDeveAceitarPedidoCancelado() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.aceitar());
    }

    @Test
    public void naoDevePrepararPedidoCancelado() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.preparar());
    }

    @Test
    public void naoDeveFicarProntoPedidoCancelado() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.pronto());
    }

    @Test
    public void naoDeveFicarEmRotaPedidoCancelado() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.emRota());
    }

    @Test
    public void naoDeveEntregarPedidoCancelado() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.entregue());
    }

    @Test
    public void naoDeveDevolverPedidoCancelado() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.devolver());
    }

    @Test
    public void naoDeveCancelarPedidoCancelado() {
        HamburguerFactory factory = HamburguerBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.cancelar());
    }

}
