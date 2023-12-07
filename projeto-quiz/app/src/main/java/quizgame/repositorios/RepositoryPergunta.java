package quizgame.repositorios;

import java.util.List;

import quizgame.menu.Pergunta;

public class RepositoryPergunta {
    private DataService dataService;
    private static RepositoryPergunta instance;
    private List<Pergunta> perguntas; 

    private RepositoryPergunta(DataService dataService) {
        this.dataService = dataService;
        this.perguntas = dataService.getAll();  
    }

    public static RepositoryPergunta getInstance() {
        if (instance == null) {
            instance = new RepositoryPergunta(new DataServiceInMemory());
        }

        return instance;
    }

    public void setRepository(DataService dataService) {
        this.dataService = dataService;
        this.perguntas = dataService.getAll();  
    }

    public List<Pergunta> getAll() {
        return perguntas;
    }

    public void update(Pergunta p) {
        dataService.update(p);
    }

    public List<Pergunta> search(String termo) {
        return dataService.search(termo);
    }

    public void remove(Pergunta p) {
        dataService.remove(p);
    }

    public void add(Pergunta pergunta) {
        perguntas.add(pergunta);
        dataService.add(pergunta);
    }
}
