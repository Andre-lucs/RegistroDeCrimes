package com.registrodetreinos.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.registrodetreinos.model.Ginasio;
import com.registrodetreinos.model.Atleta;
import com.registrodetreinos.model.Treino;
import com.registrodetreinos.service.GinasioService;
import com.registrodetreinos.service.AtletaService;
import com.registrodetreinos.service.TreinoService;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);
    private static final GinasioService ginasioService = new GinasioService();
    private static final AtletaService atletaService = new AtletaService();
    private static final TreinoService treinoService = new TreinoService();

    public static void main(String[] args) {
        int opcao;
        do {
        	limparTela();
            System.out.println("Menu:");
            System.out.println("-------------------------------");
            System.out.println("GERENCIAR GINÁSIOS");
            System.out.println("-------------------------------");
            System.out.println("1. Adicionar Ginásio");
            System.out.println("2. Encontrar Ginásio por ID");
            System.out.println("3. Atualizar Ginásio");
            System.out.println("4. Deletar Ginásio por ID");
            System.out.println("-------------------------------");
            System.out.println("GERENCIAR ATLETAS");
            System.out.println("-------------------------------");
            System.out.println("5. Adicionar Atleta");
            System.out.println("6. Encontrar Atleta por ID");
            System.out.println("7. Atualizar Atleta");
            System.out.println("8. Deletar Atleta por ID");
            System.out.println("-------------------------------");
            System.out.println("GERENCIAR TREINOS");
            System.out.println("-------------------------------");
            System.out.println("9. Adicionar Treino");
            System.out.println("10. Encontrar Treino por ID");
            System.out.println("11. Atualizar Treino");
            System.out.println("12. Deletar Treino por ID");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    adicionarGinasio();
                    break;
                case 2:
                    encontrarGinasioPorId();
                    break;
                case 3:
                	atualizarGinasio();
                	break;
                case 4:
                    deletarGinasioPorId();
                    break;
                case 5:
                    adicionarAtleta();
                    break;
                case 6:
                    encontrarAtletaPorId();
                    break;
                case 7:
                	atualizarAtleta();
                	break;
                case 8:
                    deletarAtletaPorId();
                    break;
                case 9:
                    adicionarTreino();
                    break;
                case 10:
                    encontrarTreinoPorId();
                    break;
                case 11:
                	atualizarTreino();
                	break;
                case 12:
                    deletarTreinoPorId();
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
    
    
    private static void adicionarGinasio() {
    	System.out.println("Digite o id do Ginásio: ");
    	Long id = scanner.nextLong();
    	scanner.nextLine();
    	Ginasio ginasioExiste = ginasioService.findById(id);
    	if(ginasioExiste == null) {
    		System.out.println("Digite o nome do Ginásio: ");
    		String nome = scanner.nextLine();
    		Ginasio ginasio = new Ginasio();
    		ginasio.setId(id);
    		ginasio.setNome(nome);
    		ginasioService.insert(ginasio);
    		System.out.println("Ginásio adicionado com sucesso!");
    	} else {
    		System.out.println("Já existe um ginásio com esse ID cadastrado");
    	}
    }

    private static void encontrarGinasioPorId() {
        System.out.print("Digite o ID do Ginásio: ");
        Long id = scanner.nextLong();
        Ginasio ginasio = ginasioService.findById(id);
        if (ginasio != null) {
            System.out.println("Ginásio encontrado: " + ginasio.getNome());
            scanner.nextLine();
        } else {
            System.out.println("Ginásio não encontrado!");
            scanner.nextLine();
        }
    }

    private static void visualizarTodosOsGinasios() {
        System.out.println("Lista de todos os Ginásios:");
        Iterable<Ginasio> ginasios = ginasioService.findAll();
        for (Ginasio ginasio : ginasios) {
            System.out.println("ID: " + ginasio.getId() + ", Nome: " + ginasio.getNome());
        }
    }

    private static void deletarGinasioPorId() {
        System.out.print("Digite o ID do Ginásio que deseja deletar: ");
        Long id = scanner.nextLong();
        Ginasio ginasio = ginasioService.findById(id);
        if (ginasio != null) {
            ginasioService.delete(ginasio);
            System.out.println("Ginásio deletado com sucesso!");
        } else {
            System.out.println("Ginásio não encontrado!");
        }
    }
    
    private static void atualizarGinasio() {
        System.out.print("Digite o ID do Ginásio que deseja atualizar: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        
        Ginasio ginasio = ginasioService.findById(id);
        if (ginasio != null) {
            System.out.print("Digite o novo nome do Ginásio: ");
            String novoNome = scanner.nextLine();
            ginasio.setNome(novoNome);
            ginasioService.update(ginasio);
            System.out.println("Ginásio atualizado com sucesso!");
        } else {
            System.out.println("Ginásio não encontrado!");
        }
    }
    
    private static void limparTela () {
    	System.out.println("\n\n\n");
    }
    
    private static void adicionarAtleta() {
    	System.out.println("Informe o ID do atleta:");
    	long id = scanner.nextLong();
    	Atleta atletaExiste = atletaService.findById(id);
    	if(atletaExiste == null) {
    		scanner.nextLine();
    		System.out.print("Digite o nome do Atleta: ");
    		String nome = scanner.nextLine();
    		Atleta atleta = new Atleta();
    		atleta.setNome(nome);
    		atleta.setId(id);
    		atletaService.insert(atleta);
    		System.out.println("Atleta adicionado com sucesso!");
    	} else {
    		System.out.println("Já existe um atleta com esse ID cadastrado");
    	}
    }
    
    private static void atualizarAtleta() {
        System.out.print("Digite o ID do Atleta que deseja atualizar: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); 
        
        Atleta atleta = atletaService.findById(id);
        if (atleta != null) {
            System.out.print("Digite o novo nome do Atleta: ");
            String novoNome = scanner.nextLine();
            atleta.setNome(novoNome);
            atletaService.update(atleta);
            System.out.println("Atleta atualizado com sucesso!");
        } else {
            System.out.println("Atleta não encontrado!");
        }
    }

    private static void encontrarAtletaPorId() {
        System.out.print("Digite o ID do Atleta: ");
        Long id = scanner.nextLong();
        Atleta atleta = atletaService.findById(id);
        if (atleta != null) {
            System.out.println("Atleta encontrado: " + atleta.getNome());
        } else {
            System.out.println("Atleta não encontrado!");
        }
    }

    private static void visualizarTodosOsAtletas() {
        System.out.println("Lista de todos os Atletas:");
        Iterable<Atleta> atletas = atletaService.findAll();
        for (Atleta atleta : atletas) {
            System.out.println("ID: " + atleta.getId() + ", Nome: " + atleta.getNome());
        }
    }

    private static void deletarAtletaPorId() {
        System.out.print("Digite o ID do Atleta que deseja deletar: ");
        Long id = scanner.nextLong();
        Atleta atleta = atletaService.findById(id);
        if (atleta != null) {
            atletaService.delete(atleta);
            System.out.println("Atleta deletado com sucesso!");
        } else {
            System.out.println("Atleta não encontrado!");
        }
    }
    
    
    private static void adicionarTreino() {
       
        System.out.print("Digite o ID do Ginásio: ");
        Long ginasioId = scanner.nextLong();
        Treino treinoExiste = treinoService.findById(ginasioId);
        if(treinoExiste == null) {
        	
        	Ginasio ginasio = ginasioService.findById(ginasioId);
        	if(ginasio == null) System.out.println("Ginásio não encontrado");
        	List<Atleta> atletas = new ArrayList<Atleta>();
        	int option = 1;
        	do {
        		System.out.println("\n1 - Adicionar atleta\n0- Sair\n");
        		option = scanner.nextInt();
        		if(option == 1) {
        			System.out.print("Digite o ID do Atleta: ");
        			Long atletaId = scanner.nextLong();
        			scanner.nextLine();
        			Atleta atleta = atletaService.findById(atletaId);
        			if(atleta == null) {
        				System.out.println("Atleta não encontrado!");
        			} else {
        				atletas.add(atleta);
        				System.out.println("Atleta adicionado ao treino com sucesso!");
        			}
        		}
        	}while (option != 0);
        	
        	
        	Treino treino = new Treino();
        	System.out.println("Informe o id do treino:");
        	treino.setId(scanner.nextLong());
        	scanner.nextLine();
        	System.out.println("Informe a data do treino:");
        	treino.setData(scanner.nextLine());
        	treino.setAtletas(atletas);
        	treino.setGinasio(ginasio);
        	treinoService.insert(treino);
        	System.out.println("Treino adicionado com sucesso!");
        }
    }

    private static void encontrarTreinoPorId() {
        System.out.print("Digite o ID do Treino: ");
        Long id = scanner.nextLong();
        Treino treino = treinoService.findById(id);
        if (treino != null) {
            System.out.println("Treino encontrado: " + treino.toString());
        } else {
            System.out.println("Treino não encontrado!");
        }
    }

    private static void visualizarTodosOsTreinos() {
        System.out.println("Lista de todos os Treinos:");
        Iterable<Treino> treinos = treinoService.findAll();
        for (Treino treino : treinos) {
            System.out.println(treino.toString());
        }
    }

    private static void deletarTreinoPorId() {
        System.out.print("Digite o ID do Treino que deseja deletar: ");
        Long id = scanner.nextLong();
        Treino treino = treinoService.findById(id);
        if (treino != null) {
            treinoService.delete(treino);
            System.out.println("Treino deletado com sucesso!");
        } else {
            System.out.println("Treino não encontrado!");
        }
    }
    
    
    private static void atualizarTreino() {
        System.out.print("Digite o ID do Treino que deseja atualizar: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        
        Treino treino = treinoService.findById(id);
        if (treino != null) {
            
            System.out.print("Digite a nova data do Treino (YYYY-MM-DD): ");
            String novaData = scanner.nextLine();
            treino.setData(novaData);
            treinoService.update(treino);
            System.out.println("Treino atualizado com sucesso!");
        } else {
            System.out.println("Treino não encontrado!");
        }
    }

}
