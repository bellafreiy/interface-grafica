package quizgame.executores;

import java.util.List;

import quizgame.exception.ListaVaziaException;
import quizgame.gerenciador.PerguntaService;
import quizgame.menu.Alternativa;
import quizgame.menu.Pergunta;
import quizgame.repositorios.RepositoryPergunta;

public class ListarPerguntas implements Commands {
     @Override
    public void execute() {
        try {
            listarPerguntasSemRespostas();
        } catch (ListaVaziaException e) {
            System.out.println(e.getMessage());
        }
    }

    private void listarPerguntasSemRespostas() throws ListaVaziaException {
        PerguntaService perguntaService = new PerguntaService(RepositoryPergunta.getInstance());
        List<Pergunta> perguntas = perguntaService.getPerguntas();

        if (perguntas.isEmpty()) {
            throw new ListaVaziaException("Não há perguntas para listar sem respostas.");
        }

        System.out.println("Lista de Perguntas (sem respostas):");

        for (Pergunta pergunta : perguntas) {
            System.out.println("Título: " + pergunta.getTitulo());
            System.out.println("Alternativas:");

            for (Alternativa alternativa : pergunta.getAlternativas()) {
                System.out.println("Opção: " + alternativa.getOpcao());
                System.out.println("Afirmativa: " + alternativa.getAfirmativa());
            }

            System.out.println();
        }
    }
}
