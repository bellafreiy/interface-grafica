package quizgame.executores;

import java.util.List;
import java.util.Scanner;

import quizgame.exception.ListaVaziaException;
import quizgame.gerenciador.PerguntaService;
import quizgame.menu.Alternativa;
import quizgame.menu.Pergunta;
import quizgame.repositorios.RepositoryPergunta;

public class EditarPergunta implements Commands {

    @Override
    public void execute() {
        try {
            editarPergunta();
        } catch (ListaVaziaException e) {
            System.out.println(e.getMessage());
        }
    }

    private void editarPergunta() throws ListaVaziaException {
        PerguntaService perguntaService = new PerguntaService(RepositoryPergunta.getInstance());
        List<Pergunta> perguntas = perguntaService.getPerguntas();

        if (perguntas.isEmpty()) {
            throw new ListaVaziaException("Não há perguntas para editar.");
        }

        Scanner sc = new Scanner(System.in);

        System.out.println(); 

        for (int i = 0; i < perguntas.size(); i++) {
            System.out.println(i + ". Título: " + perguntas.get(i).getTitulo());
        }

        System.out.println();
        System.out.print("Digite o número da pergunta que deseja editar: ");
        int escolhaEdit = sc.nextInt();

        if (escolhaEdit >= 0 && escolhaEdit < perguntas.size()) {
            sc.nextLine();
            System.out.println();
            System.out.print("Digite o novo título (ou Enter para pular): ");
            String novoTitulo = sc.nextLine();

            if (!novoTitulo.trim().isEmpty()) {
                perguntas.get(escolhaEdit).setTitulo(novoTitulo);
            };

            List<Alternativa> alternativas = perguntas.get(escolhaEdit).getAlternativas();

            for (int i = 0; i < alternativas.size(); i++) {
                System.out.println();
                Alternativa alternativa = alternativas.get(i);
                System.out.println("Editar Alternativa " + (i + 1));

                System.out.print("Nova opção (ou Enter para pular): ");
                String novaOpcao = sc.nextLine();
                if (!novaOpcao.trim().isEmpty()) {
                    alternativa.setOpcao(novaOpcao);
                }
                
                System.out.print("Nova afirmativa (ou Enter para pular): ");
                String novaAfirmativa = sc.nextLine();
                if (!novaAfirmativa.trim().isEmpty()) {
                    alternativa.setAfirmativa(novaAfirmativa);
                }

                System.out.print("É a opção correta? (true/false) (ou Enter para pular): ");
                String respostaCorreta = sc.nextLine();
                if (!respostaCorreta.trim().isEmpty()) {
                    boolean novaOpcaoCorreta = Boolean.parseBoolean(respostaCorreta);
                    alternativa.setOpcaoCorreta(novaOpcaoCorreta);
                }
            }

            System.out.println("Pergunta editada com sucesso.");
        } else {
            System.out.println("Escolha inválida. A pergunta não foi editada.");
        }
    }
}
