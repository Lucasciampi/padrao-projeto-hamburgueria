package org.example;

import java.util.ArrayList;
import java.util.List;

public class Grelha {

    private List<Carne> carnes = new ArrayList<>();

    public void adicionarCarne(Hamburguer hamburguer, String nomeCarne, String nomePonto) {
        PontoCarne ponto = PontoCarneFactory.getPontoCarne(nomePonto);
        Class classe = null;
        try {
            classe = Class.forName("org.example." + nomeCarne);
            Carne carne = (Carne) classe.getDeclaredConstructor(Hamburguer.class, PontoCarne.class)
                    .newInstance(hamburguer, ponto);
            carnes.add(carne);
        } catch (Exception e) {
            throw new IllegalArgumentException("Carne não encontrada: " + nomeCarne);
        }
    }

    public List<String> obterCarnes() {
        List<String> saida = new ArrayList<>();
        for (Carne carne : carnes) {
            saida.add(carne.getDescricao());
        }
        return saida;
    }

}
