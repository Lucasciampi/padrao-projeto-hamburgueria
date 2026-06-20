package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    private LancheFactory factory;
    private Pedido pedido;
    DescontoBaixo descontoBaixo;
    DescontoMedio descontoMedio;
    DescontoAlto descontoAlto;

    @BeforeEach
    void setUp() {
        factory = LancheEspecialFactory.getInstance();
        pedido = new Pedido(factory);
        descontoAlto = new DescontoAlto(null);
        descontoMedio = new DescontoMedio(descontoAlto);
        descontoBaixo = new DescontoBaixo(descontoMedio);
    }

    @Test
    void deveRetornarDescricaoDoLancheEspecial() {
        String descricaoEsperada = "Hamburguer Especial: Pão Brioche + Carne Angus (Mal Passado) + Queijo + Bacon + Molho";
        assertEquals(descricaoEsperada, pedido.getLanche().getDescricao());
    }

    @Test
    void deveRetornarDescricaomDoLancheBasico() {
        factory = LancheBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        String descricaoEsperada = "Hamburguer Basico: Pão de Batata + Carne Acém (Ao Ponto) + Queijo + Alface + Tomate";
        assertEquals(descricaoEsperada, pedido.getLanche().getDescricao());
    }

    // Testes dos Estados de Pedido
    // Pedido aceito

    @Test
    void naoDeveAceitarPedidoAceito() {
        pedido.setEstado(PedidoEstadoAceito.getInstance());
        assertFalse(pedido.aceitar());
    }

    @Test
    void devePrepararPedidoAceito() {
        pedido.setEstado(PedidoEstadoAceito.getInstance());
        assertTrue(pedido.preparar());
        assertEquals("O pedido está na etapa: Em Preparação", pedido.getEstado().getUltimaNotificacao());
    }

    @Test
    void naoDeveFicarProntoPedidoAceito() {
        pedido.setEstado(PedidoEstadoAceito.getInstance());
        assertFalse(pedido.pronto());
    }

    @Test
    void naoDeveEstarEmRotaPedidoAceito() {
        pedido.setEstado(PedidoEstadoAceito.getInstance());
        assertFalse(pedido.emRota());
    }

    @Test
    void naoDeveEntregarPedidoAceito() {
        pedido.setEstado(PedidoEstadoAceito.getInstance());
        assertFalse(pedido.entregue());
    }

    @Test
    void naoDeveDevolverPedidoAceito() {
        pedido.setEstado(PedidoEstadoAceito.getInstance());
        assertFalse(pedido.devolver());
    }

    @Test
    void naoDeveCancelarPedidoAceito() {
        pedido.setEstado(PedidoEstadoAceito.getInstance());
        assertFalse(pedido.cancelar());
    }

    // Pedido em preparacao

    @Test
    void naoDeveAceitarPedidoEmPreparacao() {
        pedido.setEstado(PedidoEstadoEmPreparacao.getInstance());
        assertFalse(pedido.aceitar());
    }

    @Test
    void naoDevePreparPedidoEmPreparacao() {
        pedido.setEstado(PedidoEstadoEmPreparacao.getInstance());
        assertFalse(pedido.preparar());
    }

    @Test
    void deveFicarProntoPedidoEmPreparacao() {
        pedido.setEstado(PedidoEstadoEmPreparacao.getInstance());
        assertTrue(pedido.pronto());
        assertEquals("O pedido está na etapa: Pronto", pedido.getEstado().getUltimaNotificacao());
    }

    @Test
    void naoDeveFicarEmRotaPedidoEmPreparacao() {
        pedido.setEstado(PedidoEstadoEmPreparacao.getInstance());
        assertFalse(pedido.emRota());
    }

    @Test
    void naoDeveEntregarPedidoEmPreparacao() {
        pedido.setEstado(PedidoEstadoEmPreparacao.getInstance());
        assertFalse(pedido.entregue());
    }

    @Test
    void naoDeveDevolverPedidoEmPreparacao() {
        pedido.setEstado(PedidoEstadoEmPreparacao.getInstance());
        assertFalse(pedido.devolver());
    }

    @Test
    void deveCancelarPedidoEmPreparacao() {
        pedido.setEstado(PedidoEstadoEmPreparacao.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals("O pedido está na etapa: Cancelado", pedido.getEstado().getUltimaNotificacao());
    }

    // Pedido pronto

    @Test
    void naoDeveAceitarPedidoPronto() {
        pedido.setEstado(PedidoEstadoPronto.getInstance());
        assertFalse(pedido.aceitar());
    }

    @Test
    void naoDevePrepararPedidoPronto() {
        pedido.setEstado(PedidoEstadoPronto.getInstance());
        assertFalse(pedido.preparar());
    }

    @Test
    void naoDeveFicarProntoPedidoPronto() {
        pedido.setEstado(PedidoEstadoPronto.getInstance());
        assertFalse(pedido.pronto());
    }

    @Test
    void deveFicarEmRotaPedidoPronto() {
        pedido.setEstado(PedidoEstadoPronto.getInstance());
        assertTrue(pedido.emRota());
        assertEquals("O pedido está na etapa: Em Rota", pedido.getEstado().getUltimaNotificacao());
    }

    @Test
    void deveEntregarPedidoPronto() {
        pedido.setEstado(PedidoEstadoPronto.getInstance());
        assertTrue(pedido.entregue());
        assertEquals("O pedido está na etapa: Entregue", pedido.getEstado().getUltimaNotificacao());
    }

    @Test
    void naoDeveDevolverPedidoPronto() {
        pedido.setEstado(PedidoEstadoPronto.getInstance());
        assertFalse(pedido.devolver());
    }

    @Test
    void deveCancelarPedidoPronto() {
        pedido.setEstado(PedidoEstadoPronto.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals("O pedido está na etapa: Cancelado", pedido.getEstado().getUltimaNotificacao());
    }

    // Pedido em rota

    @Test
    void naoDeveAceitarPedidoEmRota() {
        pedido.setEstado(PedidoEstadoEmRota.getInstance());
        assertFalse(pedido.aceitar());
    }

    @Test
    void naoDevePrepararPedidoEmRota() {
        pedido.setEstado(PedidoEstadoEmRota.getInstance());
        assertFalse(pedido.preparar());
    }

    @Test
    void naoDeveFicarProntoPedidoEmRota() {
        pedido.setEstado(PedidoEstadoEmRota.getInstance());
        assertFalse(pedido.pronto());
    }

    @Test
    void naoDeveFicarEmRotaPedidoEmRota() {
        pedido.setEstado(PedidoEstadoEmRota.getInstance());
        assertFalse(pedido.emRota());
    }

    @Test
    void deveEntregarPedidoEmRota() {
        pedido.setEstado(PedidoEstadoEmRota.getInstance());
        assertTrue(pedido.entregue());
        assertEquals("O pedido está na etapa: Entregue", pedido.getEstado().getUltimaNotificacao());
    }

    @Test
    void naoDeveDevolverPedidoEmRota() {
        pedido.setEstado(PedidoEstadoEmRota.getInstance());
        assertFalse(pedido.devolver());
    }

    @Test
    void deveCancelarPedidoEmRota() {
        pedido.setEstado(PedidoEstadoEmRota.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals("O pedido está na etapa: Cancelado", pedido.getEstado().getUltimaNotificacao());
    }

    // Pedido entregue

    @Test
    void naoDeveAceitarPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.aceitar());
    }

    @Test
    void naoDevePrepararPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.preparar());
    }

    @Test
    void naoDeveFicarProntoPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.pronto());
    }

    @Test
    void naoDeveFicarEmRotaPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.emRota());
    }

    @Test
    void naoDeveEntregarPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.entregue());
    }

    @Test
    void deveDevolverPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertTrue(pedido.devolver());
        assertEquals("O pedido está na etapa: Devolução", pedido.getEstado().getUltimaNotificacao());
    }

    @Test
    void naoDeveCancelarPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.cancelar());
    }

    // Pedido devolucao

    @Test
    void naoDeveAceitarPedidoDevolucao() {
        pedido.setEstado(PedidoEstadoDevolucao.getInstance());
        assertFalse(pedido.aceitar());
    }

    @Test
    void naoDevePrepararPedidoDevolucao() {
        pedido.setEstado(PedidoEstadoDevolucao.getInstance());
        assertFalse(pedido.preparar());
    }

    @Test
    void naoDeveFicarProntoPedidoDevolucao() {
        pedido.setEstado(PedidoEstadoDevolucao.getInstance());
        assertFalse(pedido.pronto());
    }

    @Test
    void naoDeveFicarEmRotaPedidoDevolucao() {
        pedido.setEstado(PedidoEstadoDevolucao.getInstance());
        assertFalse(pedido.emRota());
    }

    @Test
    void naoDeveEntregarPedidoDevolucao() {
        pedido.setEstado(PedidoEstadoDevolucao.getInstance());
        assertFalse(pedido.entregue());
    }

    @Test
    void naoDeveDevolverPedidoDevolucao() {
        pedido.setEstado(PedidoEstadoDevolucao.getInstance());
        assertFalse(pedido.devolver());
    }

    @Test
    void deveCancelarPedidoDevolucao() {
        pedido.setEstado(PedidoEstadoDevolucao.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals("O pedido está na etapa: Cancelado", pedido.getEstado().getUltimaNotificacao());
    }

    // Pedido cancelado

    @Test
    void naoDeveAceitarPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.aceitar());
    }

    @Test
    void naoDevePrepararPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.preparar());
    }

    @Test
    void naoDeveFicarProntoPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.pronto());
    }

    @Test
    void naoDeveFicarEmRotaPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.emRota());
    }

    @Test
    void naoDeveEntregarPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.entregue());
    }

    @Test
    void naoDeveDevolverPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.devolver());
    }

    @Test
    void naoDeveCancelarPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.cancelar());
    }

    // Observer

    @Test
    void deveNotificarOEstadoInicialDoPedidoComoAceito(){
        pedido.setEstado(pedido.getEstado());
        assertEquals("O pedido está na etapa: Aceito", pedido.getEstado().getUltimaNotificacao());
    }

    @Test
    void deveNotificarPedidos(){
        Pedido pedido1 = new Pedido(factory);
        Pedido pedido2 = new Pedido(factory);
        pedido1.setEstado(PedidoEstadoCancelado.getInstance());
        pedido2.setEstado(PedidoEstadoEmRota.getInstance());
        assertEquals("O pedido está na etapa: Cancelado", pedido1.getEstado().getUltimaNotificacao());
        assertEquals("O pedido está na etapa: Em Rota", pedido2.getEstado().getUltimaNotificacao());
    }

    @Test
    void deveProcessarPagamentoComPix(){
        CalcularValorPagamento calculador = new CalcularValorPagamento();
        calculador.setFormaPagamento(FormaPagamentoPix.getInstance());
        assertEquals("Pagamento de R$ 27.0 processado via PIX.", calculador.realizarPagamento(pedido));
    }

    @Test
    void deveProcessarPagamentoComCartao(){
        // Lanche Básico
        factory = LancheBasicoFactory.getInstance();
        Pedido pedido = new Pedido(factory);
        CalcularValorPagamento calculador = new CalcularValorPagamento();
        calculador.setFormaPagamento(FormaPagamentoDebito.getInstance());
        assertEquals("Pagamento de R$ 15.0 processado via Cartão de Débito à vista.", calculador.realizarPagamento(pedido));
    }

    @Test
    void deveProcessarPagamentoComDinheiro(){
        CalcularValorPagamento calculador = new CalcularValorPagamento();
        calculador.setFormaPagamento(FormaPagamentoDinheiro.getInstance());
        assertEquals("Pagamento de R$ 27.0 será realizado em Dinheiro.", calculador.realizarPagamento(pedido));
    }

    @Test
    void deveProcessarPagamentoCartaoParcelado(){
        CalcularValorPagamento calculador = new CalcularValorPagamento();
        calculador.setFormaPagamento(FormaPagamentoCredito.getInstance());
        assertEquals("Pagamento de R$ 27.0 processado via Cartão de Crédito parcelado.", calculador.realizarPagamento(pedido));
    }

    @Test
    void nãoDeveConterFormaDePagamento(){
        try {
            CalcularValorPagamento calculador = new CalcularValorPagamento();
            calculador.realizarPagamento(null);
            fail();
        } catch (IllegalStateException e) {
            assertEquals("Forma de pagamento não definida.", e.getMessage());
        }
    }

    @Test
    void deveProcessarPagamentoCartaoComDescontoBaixo(){
        CalcularValorPagamento calculador = new CalcularValorPagamento();
        calculador.setFormaPagamento(FormaPagamentoDebito.getInstance());
        calculador.setCadeiaDeDescontos(descontoBaixo);
        assertEquals("Pagamento de R$ 25.65 processado via Cartão de Débito à vista.", calculador.realizarPagamento(pedido));
    }

    @Test
    void deveProcessarPagamentoDinheiroComDescontoMedio(){
        CalcularValorPagamento calculador = new CalcularValorPagamento();
        calculador.setFormaPagamento(FormaPagamentoDinheiro.getInstance());
        calculador.setCadeiaDeDescontos(descontoBaixo);
        assertEquals("Pagamento de R$ 24.3 será realizado em Dinheiro.", calculador.realizarPagamento(pedido));
    }

    @Test
    void deveProcessarPagamentoPixComDescontoAlto(){
        CalcularValorPagamento calculador = new CalcularValorPagamento();
        calculador.setFormaPagamento(FormaPagamentoPix.getInstance());
        calculador.setCadeiaDeDescontos(descontoBaixo);
        assertEquals("Pagamento de R$ 22.95 processado via PIX.", calculador.realizarPagamento(pedido));
    }

    @Test
    void deveProcessarPagamentoCartaoParceladoSemDesconto(){
        CalcularValorPagamento calculador = new CalcularValorPagamento();
        calculador.setFormaPagamento(FormaPagamentoCredito.getInstance());
        calculador.setCadeiaDeDescontos(descontoBaixo);
        assertEquals("Pagamento de R$ 27.0 processado via Cartão de Crédito parcelado.", calculador.realizarPagamento(pedido));
    }

    @Test
    void deveRetornarPendenciaPagamento() {
        PendenciasPagamento.getInstance().addPedidoPendente(pedido);
        assertEquals(false,pedido.verificarPendencias());
    }

    @Test
    void deveRetornarPendenciaEntrega() {
        PendenciasEntrega.getInstance().addPedidoPendente(pedido);
        assertEquals(false,pedido.verificarPendencias());
    }

    @Test
    void deveRetornarPedidoSemPendencias() {
        assertEquals(true,pedido.verificarPendencias());
    }

    @Test
    void deveRetornarValorTotalSemBebida() {
        assertEquals(27.0, pedido.getValorTotal());
    }

    @Test
    void deveRetornarValorTotalComSuco() {
        Pedido pedidoCombo = new Pedido(ComboEspecialFactory.getInstance());
        assertEquals(34.0, pedidoCombo.getValorTotal());
    }

    @Test
    void deveRetornarValorTotalComRefrigerante() {
        Pedido pedidoCombo = new Pedido(ComboBasicoFactory.getInstance());
        assertEquals(20.0, pedidoCombo.getValorTotal());
    }

    @Test
    void deveProcessarPagamentoComboComPix() {
        Pedido pedidoCombo = new Pedido(ComboEspecialFactory.getInstance());
        CalcularValorPagamento calculador = new CalcularValorPagamento();
        calculador.setFormaPagamento(FormaPagamentoPix.getInstance());
        assertEquals("Pagamento de R$ 34.0 processado via PIX.", calculador.realizarPagamento(pedidoCombo));
    }

    @Test
    void deveProcessarPagamentoComboComDescontoBaixo() {
        Pedido pedidoCombo = new Pedido(ComboEspecialFactory.getInstance());
        CalcularValorPagamento calculador = new CalcularValorPagamento();
        calculador.setFormaPagamento(FormaPagamentoDebito.getInstance());
        calculador.setCadeiaDeDescontos(descontoBaixo);
        assertEquals("Pagamento de R$ 32.65 processado via Cartão de Débito à vista.", calculador.realizarPagamento(pedidoCombo));
    }

}
