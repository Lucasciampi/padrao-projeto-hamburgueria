package org.example;

public class Pessoa {

    public String realizarPedido(String mensagem) {
        return Central.getInstance().realizarPedido(mensagem);
    }

    public String cancelarPedido(String mensagem) {
        return Central.getInstance().cancelarPedido(mensagem);
    }

    public String verificarPedido(String mensagem) {
        return Central.getInstance().verificarPedido(mensagem);
    }

}
