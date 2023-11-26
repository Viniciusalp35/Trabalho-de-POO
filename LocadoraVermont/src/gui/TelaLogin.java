package gui;

import javax.swing.*;
import java.awt.*;
import login.CadastroUsuarios;
import login.Usuarios;
public class TelaLogin {

    public TelaLogin(){
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
            String senha = new String(senhaUsuarioField.getPassword());


        }


    }
}
