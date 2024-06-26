package br.edu.up.todolist.exceptions;

public class TarefaNotFoundException extends Exception{

    public TarefaNotFoundException(String message){
        super(message);
    }

    public TarefaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
