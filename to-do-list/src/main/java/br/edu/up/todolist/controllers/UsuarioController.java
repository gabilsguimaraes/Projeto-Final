package br.edu.up.todolist.controllers;

import br.edu.up.todolist.models.Usuario;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class UsuarioController {

    private static List<Usuario> usuarios = List.of(
            new Usuario(UUID.fromString("1c30ac00-f5ff-4a6e-bf5e-fcac61bb61d1"), "João"),
            new Usuario(UUID.fromString("a4efb4fe-2c43-4a41-bc35-1332af1117fe"), "Anna")
    );

    public static List<Usuario> listar() {
        return usuarios;
    }

    public static Usuario buscarUsuarioPorUUID(UUID uuid) {
        Optional<Usuario> usuario = usuarios.stream()
                .filter(u -> u.getUuid().equals(uuid))
                .findFirst();
        return usuario.isPresent() ? usuario.get() : null;
    }

    public static Usuario buscarUsuarioPorNome(String nome) {
        Optional<Usuario> usuario = usuarios.stream()
                .filter(u -> u.getNome().equals(nome))
                .findFirst();
        return usuario.isPresent() ? usuario.get() : null;

    }

}
