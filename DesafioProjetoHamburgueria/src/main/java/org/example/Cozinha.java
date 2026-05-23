package org.example;

public class Cozinha implements Setor {

    private static Cozinha instance = new Cozinha();

    private Cozinha() {}

    public static Cozinha getInstance() {
        return instance;
    }

    @Override
    public String realizarPedido(String mensagem) {
        return "A Cozinha recebeu o pedido: " + mensagem;
    }

    @Override
    public String cancelarPedido(String mensagem) {
        return "A Cozinha cancelou o pedido: " + mensagem;
    }

    @Override
    public String verificarPedido(String mensagem) {
        return "A Cozinha verificou o pedido: " + mensagem;
    }
}
