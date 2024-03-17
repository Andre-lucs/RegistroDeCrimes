package com.registrodetreinos.main;

import com.registrodetreinos.model.Ginasio;
import com.registrodetreinos.model.Atleta;
import com.registrodetreinos.model.Treino;
import com.registrodetreinos.service.GinasioService;
import com.registrodetreinos.service.AtletaService;
import com.registrodetreinos.service.TreinoService;

public class Main {
    public static void main(String[] args) {
        // Teste do serviço de Ginasio
        testGinasioService();

        // Teste do serviço de Atleta
        //testAtletaService();

        // Teste do serviço de Treino
        //testTreinoService();
    }

    private static void testGinasioService() {
        GinasioService ginasioService = new GinasioService();

        // Teste de inserção
        Ginasio ginasio = new Ginasio(1L);
        ginasio.setNome("Ginasio A");
        ginasioService.insert(ginasio);
        System.out.println("Ginasio inserido com sucesso!");

        // Teste de busca por ID
        Ginasio ginasioEncontrado = ginasioService.findById(1L);
        if (ginasioEncontrado != null) {
            System.out.println("Ginasio encontrado: " + ginasioEncontrado.getNome());
        } else {
            System.out.println("Ginasio não encontrado!");
        }

        // Teste de update
        if (ginasioEncontrado != null) {
            ginasioEncontrado.setNome("Ginasio B");
            ginasioService.update(ginasioEncontrado);
            System.out.println("Ginasio atualizado com sucesso!");
        }

        // Teste de delete
        if (ginasioEncontrado != null) {
            ginasioService.delete(ginasioEncontrado);
            System.out.println("Ginasio deletado com sucesso!");
        }
    }

    private static void testAtletaService() {
        
    	AtletaService atletaService = new AtletaService();

        // Teste de inserção
        Atleta atleta = new Atleta(3L);
        atleta.setNome("Atleta A");
        atletaService.insert(atleta);
        System.out.println("Atleta inserido com sucesso!");

        Atleta atletaEncontrado = atletaService.findById(3L);
        // Teste de busca por ID
        if (atletaEncontrado != null) {
            System.out.println("Atleta encontrado: " + atletaEncontrado.getNome());
        } else {
            System.out.println("Atleta não encontrado!");
        }

        // Teste de update
        if (atletaEncontrado != null) {
            atletaEncontrado.setNome("Atleta B");
            atletaService.update(atletaEncontrado);
            System.out.println("Atleta atualizado com sucesso!");
        }

        // Teste de delete
        if (atletaEncontrado != null) {
            atletaService.delete(atletaEncontrado);
            System.out.println("Atleta deletado com sucesso!");
        }
    }

    private static void testTreinoService() {
        TreinoService treinoService = new TreinoService();

        // Teste de inserção
        Treino treino = new Treino(3L, "17/03/2024");
        treino.setGinasio(new Ginasio(2L)); // Supondo que já existe um ginásio com ID 1 no banco
        treinoService.insert(treino);
        System.out.println("Treino inserido com sucesso!");

        // Teste de busca por ID
        Treino treinoEncontrado = treinoService.findById(3L);
        if (treinoEncontrado != null) {
            System.out.println("Treino encontrado!");
        } else {
            System.out.println("Treino não encontrado!");
        }

        // Teste de update
        if (treinoEncontrado != null) {
            treinoEncontrado.getGinasio().setNome("Ginasio C");
            treinoService.update(treinoEncontrado);
            System.out.println("Treino atualizado com sucesso!");
        }

        // Teste de delete
        if (treinoEncontrado != null) {
            treinoService.delete(treinoEncontrado);
            System.out.println("Treino deletado com sucesso!");
        }
    }
}
