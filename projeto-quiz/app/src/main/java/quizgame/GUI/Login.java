package quizgame.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
 
    // Botões e campo de texto para o login
    JButton rules, back;
    JTextField tfname;
    
    Login() {
        // Configurações básicas da janela
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // Adiciona a imagem de fundo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 600, 500);
        add(image);
        
        // Configurações do cabeçalho
        JLabel heading = new JLabel("Quiz POO");
        heading.setBounds(750, 60, 300, 45);
        heading.setFont(new Font("Mongolian Baiti", Font.BOLD, 40));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);
        
        // Campo para inserir o nome
        JLabel name = new JLabel("Nome do Usuário:");
        name.setBounds(810, 150, 300, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        name.setForeground(new Color(30, 144, 254));
        add(name);
        
        // Campo de texto para inserir o nome
        tfname = new JTextField();
        tfname.setBounds(735, 200, 300, 25);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfname);
        
        // Botão para exibir as regras
        rules = new JButton("Regras");
        rules.setBounds(735, 270, 120, 25);
        rules.setBackground(new Color(30, 144, 254));
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);
        
        // Botão para voltar
        back = new JButton("Voltar");
        back.setBounds(915, 270, 120, 25);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        // Configurações da janela principal
        setSize(1200, 500);
        setLocation(200, 150);
        setVisible(true);
    }
    
    // Trata eventos dos botões
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == rules) {
            // Obtém o nome digitado e abre a próxima janela
            String name = tfname.getText();
            setVisible(false);
            new Rules(name);
        } else if (ae.getSource() == back) {
            // Fecha a janela de login
            setVisible(false);
        }
    }
    
    // Método principal para iniciar o programa
    public static void main(String[] args) {
        new Login();
    }
}