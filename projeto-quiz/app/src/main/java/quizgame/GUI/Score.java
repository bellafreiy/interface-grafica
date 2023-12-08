package quizgame.GUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {

    // Construtor que recebe o nome do usuário e a pontuação
    Score(String name, int score) {
        // Configurações básicas da janela
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // Adiciona uma imagem de agradecimento
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 200, 300, 250);
        add(image);
        
        // Exibe uma mensagem de agradecimento personalizada com o nome do usuário
        JLabel heading = new JLabel("Thank you " + name + " for playing Simple Minds");
        heading.setBounds(45, 30, 700, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(heading);
        
        // Exibe a pontuação do usuário
        JLabel lblscore = new JLabel("Your score is " + score);
        lblscore.setBounds(350, 200, 300, 30);
        lblscore.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(lblscore);
        
        // Botão para jogar novamente
        JButton submit = new JButton("Play Again");
        submit.setBounds(380, 270, 120, 30);
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        // Torna a janela visível
        setVisible(true);
    }
    
    // Método que lida com eventos de botão
    public void actionPerformed(ActionEvent ae) {
        // Fecha a janela atual e inicia uma nova sessão de login
        setVisible(false);
        new Login();
    }

    // Método principal para iniciar o programa
    public static void main(String[] args) {
        // Inicia a janela de pontuação com um exemplo de nome de usuário e pontuação zero
        new Score("User", 0);
    }
}