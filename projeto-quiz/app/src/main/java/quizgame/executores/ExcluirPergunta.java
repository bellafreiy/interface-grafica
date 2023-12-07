package quizgame.executores;

import java.util.List;
import java.util.Scanner;

import quizgame.exception.ListaVaziaException;
import quizgame.gerenciador.PerguntaService;
import quizgame.menu.Pergunta;
import quizgame.repositorios.RepositoryPergunta;

public class ExcluirPergunta implements Commands{
    @Override
    public void execute() {
        try {
            removerPergunta();
        } catch (ListaVaziaException e) {
            System.out.println(e.getMessage());
        }
    }

    private void removerPergunta() throws ListaVaziaException {
        PerguntaService perguntaService = new PerguntaService(RepositoryPergunta.getInstance());
        List<Pergunta> perguntas = perguntaService.getPerguntas();

        if (perguntas.isEmpty()) {
            throw new ListaVaziaException("Não há perguntas para apagar.");
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("Perguntas disponíveis para apagar:");
        System.out.println();
        for (int i = 0; i < perguntas.size(); i++) {
            System.out.println(i + ". Título: " + perguntas.get(i).getTitulo());
        }

        System.out.println();
        System.out.println("Digite o número da pergunta que deseja apagar: ");
        int escolha = scanner.nextInt();

        if (escolha >= 0 && escolha < perguntas.size()) {
            Pergunta perguntaRemover = perguntas.get(escolha);

            perguntaService.remover(perguntaRemover);

            System.out.println();
            System.out.println("Pergunta apagada com sucesso.");
            scanner.nextLine();
        } else {
            System.out.println();
            System.out.println("Escolha inválida. A pergunta não foi apagada.");
            scanner.nextLine();
        }
    }
}
