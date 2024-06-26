package br.edu.up.todolist.models;

import java.util.UUID;

public class Usuario {
    private UUID uuid;
    private String nome;

    public Usuario() {
    }

    public Usuario(UUID uuid, String nome) {
        this.uuid = uuid;
        this.nome = nome;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}