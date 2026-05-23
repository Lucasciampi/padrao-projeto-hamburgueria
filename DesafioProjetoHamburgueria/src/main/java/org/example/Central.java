package org.example;

public class Central {

    private static Central instance = new Central();

    private Central() {}

    public static Central getInstance() {
        return instance;
    }

    public String realizarPedido(String mensagem) {
        return "A Central agradece seu contato.\n" +
                "A Cozinha respondeu sua demanda conforme mensagem a seguir.\n" +
                ">>" + Cozinha.getInstance().realizarPedido(mensagem);
    }

    public String cancelarPedido(String mensagem) {
        return "A Central agradece seu contato.\n" +
                "A Cozinha respondeu sua demanda conforme mensagem a seguir.\n" +
                ">>" + Cozinha.getInstance().cancelarPedido(mensagem);
    }

    public String verificarPedido(String mensagem) {
        return "A Central agradece seu contato.\n" +
                "A Cozinha respondeu sua demanda conforme mensagem a seguir.\n" +
                ">>" + Cozinha.getInstance().verificarPedido(mensagem);
    }

}
