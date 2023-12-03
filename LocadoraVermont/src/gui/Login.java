package gui;

import exception.DialogoExcessao;
import login.CadastroUsuarios;

import javax.swing.*;
import java.awt.*;

public class Login{

    public JFrame jframe;
    private JButton login;
    private JButton cadastro;

    public Login(CadastroUsuarios cadastroUsuarios) throws Exception{
        jframe = new JFrame("Locadora Vermont");

        ImageIcon imagem = new ImageIcon("src/login/VermontMenor.jpg");
        JLabel backgroundLabel = new JLabel(imagem);
        backgroundLabel.setBounds(0, 0, 800, 600);
        jframe.add(backgroundLabel);


        //getContentPane().setBackground(Color.cyan);
        cadastro = new JButton("Cadastro");
        cadastro.setBackground(new Color(66, 141, 245));
        cadastro.setBounds(0, 300, 100, 30);
        cadastro.addActionListener(e -> ExibirTelaCadastro(cadastroUsuarios));
        cadastro.setFocusable(false);
        jframe.add(cadastro);

        login = new JButton("Login");
        login.setBounds(0, 250, 100, 30);
        login.setBackground(new Color(66, 141, 245));
        login.addActionListener(e -> ExibirTelaLogin(cadastroUsuarios, jframe));
        login.setFocusable(false);

        jframe.add(login);



        JPanel panel = new JPanel();
        panel.setOpaque(false);
        jframe.getContentPane().add(panel);

        jframe.setSize(800, 600);
        jframe.setLocationRelativeTo(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
    }

    private void ExibirTelaLogin(CadastroUsuarios cadastroUsuarios, JFrame jframe) {
        TelaLogin telalogin = new TelaLogin(cadastroUsuarios, jframe);
    }

    private void ExibirTelaCadastro(CadastroUsuarios cadastroUsuarios) {
        TelaCadastro telaCadastro = new TelaCadastro(cadastroUsuarios);
    }
}
