package gui;

import login.CadastroUsuarios;

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


        login = new JButton("Login");
        cadastro = new JButton("Cadastro");
        login.setBounds(50, 250, 100, 30);
        login.setBackground(new Color(66, 141, 245));

        cadastro.setBackground(new Color(66, 141, 245));
        cadastro.setBounds(50, 300, 100, 30);
        this.add(login);
        this.add(cadastro);

        JPanel panel = new JPanel();
        panel.setOpaque(false);
        getContentPane().add(panel);

        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void exibirTelaLogin() {
        //LoginDialog.showLoginDialog(this,cadastroUsuarios);
    }

    private void exibirTelaCadastro(CadastroUsuarios cadastroUsuarios) {
        //RegisterDialog.showRegisterDialog(cadastroUsuarios);
    }
}
