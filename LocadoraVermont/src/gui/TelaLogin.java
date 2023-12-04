package gui;

import javax.swing.*;
import java.awt.*;

import exception.NomeJaUtilizado;
import exception.DialogoExcessao;
import exception.UsuarioNaoEncontrado;
import login.CadastroUsuarios;
import login.Usuarios;


public class TelaLogin {

    JFrame jframe = new JFrame();

    public TelaLogin(CadastroUsuarios cadastroUsuarios, JFrame jframe){
        this.jframe = jframe;

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel nomeUsuario = new JLabel("Usuário:");
        JTextField nomeUsuarioField = new JTextField();
        JLabel senhaUsuario = new JLabel("Senha:");
        JPasswordField senhaUsuarioField = new JPasswordField();



        panel.add(nomeUsuario);
        panel.add(nomeUsuarioField);
        panel.add(senhaUsuario);
        panel.add(senhaUsuarioField);


        int option = JOptionPane.showOptionDialog(null, panel, "Login", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Login", "Cancelar"}, null);

        if (option == 0) {
            String nome = nomeUsuarioField.getText();
            String senha2 = new String(senhaUsuarioField.getPassword());

            Usuarios usuarios = new Usuarios(nome, senha2, true);

            // 1 = usuario básico
            // 2 = usuario prime
            try {
                int verificador = cadastroUsuarios.FazerLogin(usuarios);
                if(verificador == 1 || verificador == 2){
                    LoginRealizado(verificador);
                }
            } catch(Exception e){
                new DialogoExcessao(e);
                e.printStackTrace();
            }
        }
    }

    public void LoginRealizado(int verificador){
        jframe.dispose();
        SwingUtilities.invokeLater(() -> {
            TelaEntrada escolherCarroGUI = new TelaEntrada(verificador);
            //TelaEntrada.carregarCarros(escolherCarroGUI.armazenaCar);
            escolherCarroGUI.setVisible(true);
        });
    }

}
