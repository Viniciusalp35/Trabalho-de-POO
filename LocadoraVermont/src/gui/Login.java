package gui;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    private JButton login;
    private JButton cadastro;

    public Login() throws Exception{
        super("Locadora Vermont");

        ImageIcon imagem = new ImageIcon("src/login/VermontMenor.jpg");
        JLabel backgroundLabel = new JLabel(imagem);
        backgroundLabel.setBounds(0, 0, 800, 600);
        add(backgroundLabel);

        //getContentPane().setBackground(Color.cyan);
        cadastro = new JButton("Cadastro");
        cadastro.setBackground(new Color(66, 141, 245));
        cadastro.setBounds(50, 300, 100, 30);
        cadastro.addActionListener(e -> ExibirTelaCadastro());
        add(cadastro);

        login = new JButton("Login");
        login.setBounds(50, 250, 100, 30);
        login.setBackground(new Color(66, 141, 245));
        login.addActionListener(e -> ExibirTelaLogin());
        add(login);



        JPanel panel = new JPanel();
        panel.setOpaque(false);
        getContentPane().add(panel);

        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void ExibirTelaLogin() {
        TelaLogin telalogin = new TelaLogin();
    }

    private void ExibirTelaCadastro() {
        TelaCadastro telaCadastro = new TelaCadastro();
    }
}
