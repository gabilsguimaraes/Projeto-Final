package br.edu.up.todolist;

import br.edu.up.todolist.utils.Util;
import br.edu.up.todolist.views.ToDoView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        int op = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            exibirMenu();
            op = Util.lerOpcoesMenu(scanner);
            processaEscolhaUsuario(scanner, op);

        } while (op != 0);
    }

    //método responsávelo pro processar a escolha do usuario
    private static void processaEscolhaUsuario(Scanner scanner, int op) {
        switch (op) {
            case 0 -> System.out.println("Tchauuuuuu!");
            case 1 -> ToDoView.iniciar(scanner);
            case 99 -> System.out.println("Você precisa informar um valor inteiro.");
            default -> System.out.println("Opção invalida! Escolha uma opção de acordo com o menu.");
        }
    }

    //método responsavel por exibir o menu principal
    private static void exibirMenu() {
        System.out.println("###########################");
        System.out.println("#           MENU          #");
        System.out.println("###########################");
        System.out.println("0 - SAIR");
        System.out.println("1 - TO Do LIST");
    }
}