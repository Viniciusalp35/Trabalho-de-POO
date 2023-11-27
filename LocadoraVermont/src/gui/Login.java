package gui;

import login.CadastroUsuarios;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    private JButton login;
    private JButton cadastro;

    public Login() throws Exception{
        super("Locadora Vermont");

        CadastroUsuarios cadastroUsuarios = new CadastroUsuarios();

        ImageIcon imagem = new ImageIcon("src/login/VermontMenor.jpg");
        JLabel backgroundLabel = new JLabel(imagem);
        backgroundLabel.setBounds(0, 0, 800, 600);
        add(backgroundLabel);

        //getContentPane().setBackground(Color.cyan);
        cadastro = new JButton("Cadastro");
        cadastro.setBackground(new Color(66, 141, 245));
        cadastro.setBounds(0, 300, 100, 30);
        cadastro.addActionListener(e -> ExibirTelaCadastro(cadastroUsuarios));
        cadastro.setFocusable(false);
        add(cadastro);

        login = new JButton("Login");
        login.setBounds(0, 250, 100, 30);
        login.setBackground(new Color(66, 141, 245));
        login.addActionListener(e -> ExibirTelaLogin(cadastroUsuarios));
        login.setFocusable(false);

        add(login);



        JPanel panel = new JPanel();
        panel.setOpaque(false);
        getContentPane().add(panel);

        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void ExibirTelaLogin(CadastroUsuarios cadastroUsuarios) {
        TelaLogin telalogin = new TelaLogin(cadastroUsuarios);
    }

    private void ExibirTelaCadastro(CadastroUsuarios cadastroUsuarios) {
        TelaCadastro telaCadastro = new TelaCadastro(cadastroUsuarios);
    }
}
