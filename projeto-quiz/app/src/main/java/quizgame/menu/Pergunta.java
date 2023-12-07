package quizgame.menu;

import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class Pergunta {
    public String titulo;
    private List<Alternativa> alternativas;
    
    public Pergunta(String titulo) {
        this.titulo = titulo;
        this.alternativas = new ArrayList<>();
    }

    public List<Alternativa> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void adicionarAlternativa(Alternativa alternativa) {
        alternativas.add(alternativa);
    }

    public boolean verificarResposta(String respostaUsuario) {
        for (Alternativa alternativa : alternativas) {
            if (alternativa.getOpcao().equalsIgnoreCase(respostaUsuario) && alternativa.isOpcaoCorreta()) {
                return true;
            }
        }
        return false;
    }
    public String obterRespostaCorreta() {
        for (Alternativa alternativa : alternativas) {
            if (alternativa.isOpcaoCorreta()) {
                return alternativa.getOpcao() + ". " + alternativa.getAfirmativa();
            }
        }
        return "Resposta não encontrada";
    }
}
