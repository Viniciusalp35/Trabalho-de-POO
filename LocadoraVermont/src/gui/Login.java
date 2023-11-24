package gui;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    private JButton login;
    private JButton cadastro;

    public Login() throws Exception{
        super("Locadora Vermont");

        login = new JButton("Login");
        cadastro = new JButton("Cadastro");

        JPanel panel = new JPanel();
        panel.add(login);
        panel.add(cadastro);

        getContentPane().add(panel);

        getContentPane().setBackground(Color.cyan);
        panel.setOpaque(false);

        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }


}
