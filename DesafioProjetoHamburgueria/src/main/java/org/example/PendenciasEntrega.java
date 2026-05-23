package org.example;

public class PendenciasEntrega extends Pendencias {

    private static PendenciasEntrega instance = new PendenciasEntrega();

    private PendenciasEntrega() {}

    public static PendenciasEntrega getInstance() {
        return instance;
    }
}
