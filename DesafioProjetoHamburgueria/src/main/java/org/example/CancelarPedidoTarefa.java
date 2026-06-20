package org.example;

public class CancelarPedidoTarefa implements Tarefa {

    private Pedido pedido;

    public CancelarPedidoTarefa(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void executar() {
        this.pedido.cancelar();
    }

    @Override
    public void cancelar() {
        this.pedido.preparar(); // silenciosamente irá retornar false, já que um pedido cancelado é um estado final
    }

}
