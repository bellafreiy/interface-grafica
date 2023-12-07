package quizgame.repositorios;

import java.util.ArrayList;
import java.util.List;

import quizgame.menu.Pergunta;


public class DataServiceInMemory implements DataService {
    
    protected List<Pergunta> perguntas = new ArrayList<>();
    @Override
    public void add(Pergunta p) {
        perguntas.add(p);
    }

    @Override
    public List<Pergunta> getAll() {
        return perguntas;
    }

    @Override
    public void update(Pergunta p) {
        int index = perguntas.indexOf(p);
        perguntas.set(index, p);
    }

    @Override
    public void remove(Pergunta p) {
        perguntas.remove(p);
    }

    @Override
    public List<Pergunta> search(String termo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

}
