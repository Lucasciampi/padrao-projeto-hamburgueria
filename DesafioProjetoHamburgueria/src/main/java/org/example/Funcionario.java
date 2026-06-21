package org.example;

public class Funcionario {

    private String nome;
    private boolean autorizado;

    public Funcionario(String nome, boolean autorizado) {
        this.nome = nome;
        this.autorizado = autorizado;
    }

    public String getNome() {
        return nome;
    }

    public boolean isAutorizado() {
        return autorizado;
    }
}
