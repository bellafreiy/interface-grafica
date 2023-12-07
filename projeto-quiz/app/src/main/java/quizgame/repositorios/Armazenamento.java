package quizgame.repositorios;

import java.util.List;

import quizgame.menu.Pergunta;

public interface Armazenamento {
    void add(Pergunta p);
    List<Pergunta> getPerguntas();
} 
