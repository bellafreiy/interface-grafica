package quizgame.gerenciador;

import java.util.List;

import quizgame.menu.Alternativa;
import quizgame.menu.Pergunta;
import quizgame.repositorios.RepositoryPergunta;

public class PerguntaService {
    private final RepositoryPergunta repository;

    public PerguntaService(RepositoryPergunta repository) {
        this.repository = repository;
    }

    public Pergunta get(int index) {
        return repository.getAll().get(index);
    }

    public List<Pergunta> buscar(String termo) {
        return repository.search(termo);
    }

    public List<Pergunta> getPerguntas() {
        return repository.getAll();
    }

    public void editar(String titulo) {
        repository.update(new Pergunta(titulo));
    }

    public void remover(Pergunta p) {
        repository.remove(p);
    }

    public void adicionarAlternativa(Pergunta pergunta, Alternativa alternativa) {
        pergunta.adicionarAlternativa(alternativa);
        repository.update(pergunta); 
    }

    public void adicionarPergunta(Pergunta pergunta) {
        repository.add(pergunta);
    }
}
