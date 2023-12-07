package quizgame.repositorios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import quizgame.menu.Pergunta;

public class ArmazenamentoFileData extends ArmazenamentoInMemory{
    public ArmazenamentoFileData() {
        File guardarPergunta = new File("questoes.bin");
        if (guardarPergunta.exists()){
            try(ObjectInputStream erro = new ObjectInputStream(new FileInputStream("questoes.bin"))){
                perguntas = (List<Pergunta>) erro.readObject();
            } catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void add(Pergunta p) {
        super.add(p);
        write();
    }

    private void write() {
        try (ObjectOutputStream ios = new ObjectOutputStream(new FileOutputStream("questoes.bin"))) {
            ios.writeObject(getPerguntas());
        } catch (IOException e) {
            e.printStackTrace();
        }
}
}
