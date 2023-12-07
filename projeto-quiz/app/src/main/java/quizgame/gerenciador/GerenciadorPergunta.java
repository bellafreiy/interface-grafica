package quizgame.gerenciador;

import java.util.List;
import java.util.Scanner;

import quizgame.menu.Pergunta;
import quizgame.repositorios.RepositoryPergunta;

public class GerenciadorPergunta {
     private final RepositoryPergunta repository;

    public GerenciadorPergunta(RepositoryPergunta repository) {
        this.repository = repository;
    }

    public void adicionarPergunta() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira o título da pergunta: ");
        String titulo = scanner.nextLine();

        Pergunta pergunta = new Pergunta(titulo);

        repository.add(pergunta);

        System.out.println("Pergunta adicionada com sucesso!");
    }

    public void listarPerguntas() {
        List<Pergunta> perguntas = repository.getAll();

        if (perguntas.isEmpty()) {
            System.out.println("Não há perguntas disponíveis.");
        } else {
            System.out.println("Lista de Perguntas:");
            for (int i = 0; i < perguntas.size(); i++) {
                Pergunta pergunta = perguntas.get(i);
                System.out.println(i + ". Título: " + pergunta.getTitulo());
            }
        }
    }

    public void removerPergunta() {
        listarPerguntas();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o número da pergunta que deseja remover: ");
        int escolha = scanner.nextInt();

        List<Pergunta> perguntas = repository.getAll();

        if (escolha >= 0 && escolha < perguntas.size()) {
            Pergunta perguntaRemovida = perguntas.get(escolha);
            repository.remove(perguntaRemovida);
            System.out.println("Pergunta removida com sucesso!");
        } else {
            System.out.println("Escolha inválida. A pergunta não foi removida.");
        }
    }

    public void editarPergunta() {
        List<Pergunta> perguntas = repository.getAll();
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Lista de Perguntas disponíveis para editar:");
        for (int i = 0; i < perguntas.size(); i++) {
            System.out.println(i + ". Título: " + perguntas.get(i).getTitulo());
        }

        System.out.println("Digite o número da pergunta que deseja editar: ");
        int escolha = scanner.nextInt();

        if (escolha >= 0 && escolha < perguntas.size()) {
            Pergunta perguntaEditada = perguntas.get(escolha);

            System.out.println("Digite o novo título (ou Enter para pular): ");
            String novoTitulo = scanner.nextLine().trim();
            if (!novoTitulo.isEmpty()) {
                perguntaEditada.setTitulo(novoTitulo);
            }
            
            repository.update(perguntaEditada);
            System.out.println("Pergunta editada com sucesso!");
        } else {
            System.out.println("Escolha inválida. A pergunta não foi editada.");
        }
    }
}
