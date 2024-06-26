package br.edu.up.todolist.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {

    private static final Logger logger = LogManager.getLogger(Util.class);

    /*
     * Método responsável por realizar a leitura do console
     * @param scanner
     * @return
     */
    public static int lerOpcoesMenu(Scanner scanner) {
        logger.info("Iniciando o processo de leitura do console");
        try {
            int opcao = scanner.nextInt();
            return opcao;
        } catch (InputMismatchException ex) {
            logger.error("Ocorreu um erro ao tentar ler o console. Input diferente de INT!", ex);
            return 99;
        } finally {
            scanner.nextLine();
        }
    }

    public static void showFeedbackMessage(String message) {
        System.out.println("--------------------");
        System.out.println(message);
        System.out.println("-------------------");
    }

    public static void showFeedbackMessage(String message, boolean isError) {
        System.out.println("--------------------");
        System.out.println("ERROR: " + message);
        System.out.println("--------------------");
    }
}