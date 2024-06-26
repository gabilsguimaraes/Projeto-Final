package br.edu.up.todolist.views;

import br.edu.up.todolist.controllers.UsuarioController;
import br.edu.up.todolist.models.Usuario;

import java.util.List;

public class UsuarioView {

    public static void exibirDadosUsuarios() {
        var usuarios = UsuarioController.listar();
        System.out.println("######## LISTA DE USUARIOS ############");
        usuarios.forEach(usuario -> {
            System.out.println("UUID: " + usuario.getUuid());
            System.out.println("NOME: " + usuario.getNome());
            System.out.println("-----------------------------------------");
        });
        System.out.println("########################################");

    }
}