package br.edu.up.todolist.daos;

import br.edu.up.todolist.models.FormatacaoEscrita;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public abstract class BaseDao {
    private static final Logger logger = LogManager.getLogger(BaseDao.class);

    /*
     * Método responsável por escrever os dados dos objetos nos arquivos
     * @param fileName
     * @param listaDados
     * @param append
     */

    public static void escrever(String fileName, List<FormatacaoEscrita> listaDados, Boolean append) {
        logger.info("Iniciando a abertura do arquivo " + fileName);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, append))) {
            for (FormatacaoEscrita d: listaDados){
                bufferedWriter.write(d.dadosFormatado());
                bufferedWriter.newLine();
            }
        } catch(IOException ex){
            logger.error("Ocorreu um erro ao tentar remover");
        }
    }
}