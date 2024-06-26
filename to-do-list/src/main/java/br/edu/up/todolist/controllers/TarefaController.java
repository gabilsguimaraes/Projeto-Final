package br.edu.up.todolist.controllers;

import br.edu.up.todolist.daos.TarefaDao;
import br.edu.up.todolist.exceptions.TarefaNotFoundException;
import br.edu.up.todolist.models.FormatacaoEscrita;
import br.edu.up.todolist.models.Tarefa;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public abstract class TarefaController {
    private static final Logger logger = LogManager.getLogger(TarefaController.class);
    private static final String TAREFA_FILE_NAME = "tarefa.txt";

    /*
     * Método responsável por listar as tarefas cadastradas
     * @return
     */
    public static List<Tarefa> listar() {
        return TarefaDao.listarTarefas(TAREFA_FILE_NAME);
    }

    /*
     * Método responsável por buscar as tarefa por UUID
     * @param uuid
     * @return
     */
    public static Tarefa buscarTarefaPorUuid(UUID uuid) throws TarefaNotFoundException {
        //busca as tarefas cadastradas no arquivo .txt
        var listaTarefas = listar();
        //verificando se a tarefa existe
        Optional<Tarefa> tarefa = listaTarefas.stream()
                .filter(t -> t.getUuid().equals(uuid))
                .findFirst();

        if(tarefa.isEmpty()) {
            throw new TarefaNotFoundException("Não foi encontrada nenhuma tarefa com UUID: " + uuid);
        }

        return tarefa.get();
    }

    /*
     * Método responsável por cadastrar uma tarefa
     * @param tarefa
     */
    public static void cadastrar(Tarefa tarefa) {
        TarefaDao.escrever(TAREFA_FILE_NAME, List.of(tarefa), true);
    }

    /*
     * Método responsável por atualizar os dados de um tarefa
     * @param uuid
     * @param tarefa
     */
    public static void atualizar(UUID uuid, Tarefa tarefaAtualizada) throws TarefaNotFoundException {
        //verifica se a tarefa existe
        var tarefa = buscarTarefaPorUuid(uuid);
        
        //Atualizando os dados da tarefa
        tarefa.atualizarDados(tarefaAtualizada);

        //Removendo tarefa da lista e criando uma nova lista valida
        var novaListaDeTarefas = removerTarefaDaListaPorUuid(uuid);
        //Adicionando a tarefa atualizada para a lista valida
        novaListaDeTarefas.add(tarefa);
        //Escrever arquivo de tarefa
        TarefaDao.escrever(TAREFA_FILE_NAME, novaListaDeTarefas, false);
    }

    /*
     * Método responsável por remover uma tarefa por UUID
     * @param uuid
     */
    public static void remover(UUID uuid) throws TarefaNotFoundException {
        var tarefa = buscarTarefaPorUuid(uuid);
        var dados = removerTarefaDaListaPorUuid(uuid);
        TarefaDao.escrever(TAREFA_FILE_NAME, dados, false);
    }

    private static List<FormatacaoEscrita> removerTarefaDaListaPorUuid(UUID uuid) {
        List<FormatacaoEscrita> dados = new ArrayList<>();
        var tarefas = listar();
        tarefas.forEach(t -> {
            if (!t.getUuid().equals(uuid)) {
                dados.add(t);
            }
        });
        return dados;
    }
}
                