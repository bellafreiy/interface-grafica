package quizgame.menu;

import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class Pergunta {
    public String titulo;
    public String areaDoConhecimento;
    private List<Alternativa> alternativas;

    public Pergunta(String titulo) {
        this.titulo = titulo;
        this.alternativas = new ArrayList<>();
    }

    // Construtor da classe Pergunta
    public Pergunta(String titulo, String areaDoConhecimento) {
        this.titulo = titulo;
        this.areaDoConhecimento = areaDoConhecimento;
        this.alternativas = new ArrayList<>();
    }
    // Métodos getter e setter para a lista de alternativas
    public List<Alternativa> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }

    // Métodos getter e setter para o título da pergunta
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAreaDoConhecimento() {
        return areaDoConhecimento;
    }

    public void adicionarAlternativa(Alternativa alternativa) {
        alternativas.add(alternativa);
    }

    // Método para verificar se a resposta do usuário está correta
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
