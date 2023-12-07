package quizgame.executores;

import quizgame.gerenciador.PerguntaService;
import quizgame.menu.Alternativa;
import quizgame.menu.Pergunta;
import quizgame.repositorios.RepositoryPergunta;

public class CriarPergunta implements Commands {
    @Override
    public void execute() {
        System.out.println();
        System.out.println("Insira o título da pergunta: ");
        String titulo = System.console().readLine();

        PerguntaService perguntaService = new PerguntaService(RepositoryPergunta.getInstance());

        Pergunta pergunta = new Pergunta(titulo);

        String opcao, afirmativa;
        boolean opcaoCorreta;

        for (int i = 1; i <= 4; i++) {
            System.out.println();
            System.out.println("Insira a opção da pergunta " + i + ": ");
            opcao = System.console().readLine();
            System.out.println("Insira a afirmativa para a opção " + i + ": ");
            afirmativa = System.console().readLine();
            System.out.print("Essa é a opção correta? (true/false): "); 

            opcaoCorreta = Boolean.parseBoolean(System.console().readLine());

            Alternativa alternativa = new Alternativa(opcao, afirmativa, opcaoCorreta);

            pergunta.adicionarAlternativa(alternativa);
        }

        perguntaService.adicionarPergunta(pergunta); 
    }
}
