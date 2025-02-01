/* Trabalho Final - Cinema
 * Aluna: Marina Laura Villaça e Melo
 * Disciplina: POO - Coltec
 * Prof: Leandro Maia
*/

import java.util.Scanner;

abstract public class Main {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            SistemaCinema sistema = new SistemaCinema();
            
            // Criando instâncias de cinemas (uso do padrão Singleton)
            CineArtPalacio cineAP = CineArtPalacio.getInstance();
            CineBelasArtes cineBelas = CineBelasArtes.getInstance();

            // Adicionando cinemas ao sistema
            sistema.adicionarCinema(cineAP);
            sistema.adicionarCinema(cineBelas);
 
            // Serializando o sistema de cinema
            SerializacaoCinema.salvarSistemaCinema(sistema);
            
            // Criado salas associadas aos cinemas
            SalaClassica SC1 = new SalaClassica(cineBelas);
            cineBelas.adicionarSala(SC1);

            SalaPremium SP1 = new SalaPremium(cineAP);
            cineAP.adicionarSala(SP1);
            
            // Criando filmes
            Filme filme1 = new Filme(1005, "Matrix 1999", 8160, "Lilly Wachowski");
            Filme filme2 = new Filme(1021, "O Poderoso Chefão", 7200, "Francis Ford Coppola");
            Filme filme3 = new Filme(1142, "Meu Malvado Favorito", 8000, " Chris Renaud");
            Filme filme4 = new Filme("Vingadores: Ultimato", "12 anos"); 						

            boolean rodando = true;

            while (rodando) {
                System.out.println("\n### MENU DE OPERAÇÕES ###");
                System.out.println("1. Listar Cinemas");
                System.out.println("2. Listar Salas dos Cinemas");
                System.out.println("3. Criar Sessões");
                System.out.println("4. Listar Sessões das Salas");
                System.out.println("5. Exibir informações de Filmes");
                System.out.println("6. Testar Classificação Etária de um Filme");
                System.out.println("7. Sair");
                System.out.println("#########################");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine(); 				// Limpar o buffer do scanner

                switch (opcao) {
                    case 1:
                        Cinema.listarCinemas();
                        break;

                    case 2:
                        cineBelas.listarSalas();
                        cineAP.listarSalas();
                        break;

                    case 3:
                        SC1.criarSessao(filme1, "22-12-2024", "19h00", cineBelas);
                        SP1.criarSessao(filme2, "25-11-2024", "20h30", cineAP);
                        SC1.criarSessao(filme3, "01-12-2024", "18h30", cineAP);   
                        System.out.println("Sessões criadas com sucesso."); 
                        break;

                    case 4:
                        SC1.listarSessoes();
                        SP1.listarSessoes();
                        break;
                        
                    case 5:
                        System.out.println("\nInformações dos Filmes:");
                        filme1.infoFilme();
                        filme2.infoFilme();
                        filme3.infoFilme();
                        break;

                    case 6:
                        System.out.println(filme4.getNomeFilme() + " - Classificação: " + filme4.getClassificacao());
                        System.out.println("Idade 10: " + filme4.podeAssistirFilme(10));
                        System.out.println("Idade 14: " + filme4.podeAssistirFilme(14));
                        break;

                    case 7:
                        System.out.println("Encerrando o programa...");
                        rodando = false;
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            }
            	scanner.close(); // Fechar o scanner ao final
            
            	// Desserializando o sistema Cinema
            	SerializacaoCinema.carregarSistemaCinema();          
        }       
        catch (IdExistenteException e) {
            System.out.println("Erro: " + e.getMessage());
        } 
        
        catch (NomeDuplicadoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
