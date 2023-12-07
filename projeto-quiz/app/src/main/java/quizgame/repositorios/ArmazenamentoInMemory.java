package quizgame.repositorios;

import java.util.ArrayList;
import java.util.List;

import quizgame.menu.Pergunta;
import java.util.ArrayList;
import java.util.List;

public class ArmazenamentoInMemory implements Armazenamento{
    protected List<Pergunta> perguntas = new ArrayList<>();

    @Override
    public void add(Pergunta p) {
        perguntas.add(p);
    }

    @Override
    public List<Pergunta> getPerguntas() {
        return perguntas;
    }
}