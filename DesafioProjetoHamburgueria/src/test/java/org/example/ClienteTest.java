package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    private Cliente cliente;
    private HamburguerFactory factory;
    private Pedido pedido;

    @BeforeEach
    void setUp() {
        cliente = new Cliente();
        factory = HamburguerEspecialFactory.getInstance();
        pedido = new Pedido(factory);
    }


    @Test
    void deveRealizarPedido() {
        assertEquals("A Central agradece seu contato.\n" +
                        "A Cozinha respondeu sua demanda conforme mensagem a seguir.\n" +
                        ">>A Cozinha recebeu o pedido: X-Bacon",
                cliente.realizarPedido("X-Bacon"));
    }

    @Test
    void deveCancelarPedido() {
        assertEquals("A Central agradece seu contato.\n" +
                        "A Cozinha respondeu sua demanda conforme mensagem a seguir.\n" +
                        ">>A Cozinha cancelou o pedido: X-Bacon",
                cliente.cancelarPedido("X-Bacon"));
    }

    @Test
    void deveVerificarPedido() {
        assertEquals("A Central agradece seu contato.\n" +
                        "A Cozinha respondeu sua demanda conforme mensagem a seguir.\n" +
                        ">>A Cozinha verificou o pedido: X-Bacon",
                cliente.verificarPedido("X-Bacon"));
    }

    @Test
    void deveArmazenarPedidos() {
        Pedido pedido2 = new Pedido(HamburguerBasicoFactory.getInstance());
        cliente.registrarPedido(pedido);
        cliente.registrarPedido(pedido2);
        assertEquals(2, cliente.getHistorico().size());
    }

    @Test
    void deveRetornarExcecaoIndiceInvalido() {
        try {
            cliente.repetirPedido(0);
            fail();
        } catch (Exception e) {
            assertEquals("Índice inválido", e.getMessage());
        }
    }

    @Test
    void deveRepetirPedidoComEstadoInicial() throws CloneNotSupportedException {
        pedido.preparar();
        pedido.pronto();
        cliente.registrarPedido(pedido);
        Pedido pedidoRepetido = cliente.repetirPedido(0);
        assertEquals("Pronto", pedido.getNomeEstado());
        assertEquals("Aceito", pedidoRepetido.getNomeEstado());
    }

    @Test
    void deveRepetirPedidoComMesmoLanche() throws CloneNotSupportedException {
        cliente.registrarPedido(pedido);
        Pedido pedidoRepetido = cliente.repetirPedido(0);
        assertEquals(pedido.getLanche().getDescricao(), pedidoRepetido.getLanche().getDescricao());
    }

    @Test
    void deveRepetirPedidoIndependenteDoOriginal() throws CloneNotSupportedException {
        cliente.registrarPedido(pedido);
        Pedido pedidoRepetido = cliente.repetirPedido(0);
        pedidoRepetido.preparar();
        assertEquals("Aceito", pedido.getNomeEstado());
        assertEquals("Em Preparação", pedidoRepetido.getNomeEstado());
    }

}