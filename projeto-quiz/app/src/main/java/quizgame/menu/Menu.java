package quizgame.menu;

import java.util.Scanner;

import quizgame.gerenciador.GerenciadorPergunta;
import quizgame.repositorios.RepositoryPergunta;

public class Menu {

    public static void main(String[] args) {
        
        RepositoryPergunta perguntaRepository = RepositoryPergunta.getInstance();
        GerenciadorPergunta perguntaManager = new GerenciadorPergunta(perguntaRepository);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("MENU");
            System.out.println();
            System.out.println("1- Criar Pergunta");
            System.out.println("2- Excluir Pergunta");
            System.out.println("3- Editar Pergunta");
            System.out.println("4- Exibir Perguntas");
            System.out.println("5- Jogar");
            System.out.println("6- Sair");
            System.out.println();

            try {
                int escolha = scanner.nextInt();
                scanner.nextLine();
                switch (escolha) {
                    case 1:
                        perguntaManager.adicionarPergunta();
                        break;
                    case 2:
                        perguntaManager.removerPergunta();
                        break;
                    case 3:
                        perguntaManager.editarPergunta();
                        break;
                    case 4:
                        perguntaManager.listarPerguntas();
                        break;
                    case 5:
                        System.out.println("Opção ainda não implementada.");
                        break;
                    case 6:
                        System.out.println("Encerrando o programa.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Opção inválida. Tente novamente.");
                scanner.nextLine(); 
            }
        }
    }
}
