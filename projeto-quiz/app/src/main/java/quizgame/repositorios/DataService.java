package quizgame.repositorios;

import java.util.List;

import quizgame.menu.Pergunta;

public interface DataService {
    void add(Pergunta p);
    List<Pergunta> getAll();
    void update(Pergunta p);
    List<Pergunta> search(String termo);
    void remove(Pergunta p);
}
