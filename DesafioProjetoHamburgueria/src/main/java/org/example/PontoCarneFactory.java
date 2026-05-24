package org.example;

import java.util.HashMap;
import java.util.Map;

public class PontoCarneFactory {

    private static Map<String, PontoCarne> pontos = new HashMap<>();

    public static PontoCarne getPontoCarne(String nome) {
        PontoCarne ponto = pontos.get(nome);
        Class classe = null;
        if (ponto == null) {
            try {
                classe = Class.forName("org.example." + nome);
                ponto = (PontoCarne) classe.getDeclaredConstructor().newInstance();
                pontos.put(nome, ponto);
            } catch (Exception e) {
                throw new IllegalArgumentException("Ponto de carne não encontrado: " + nome);
            }
        }
        return ponto;
    }

    public static int getTotalPontos() {
        return pontos.size();
    }

}
