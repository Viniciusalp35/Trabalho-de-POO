package gui;

import login.CadastroUsuarios;
import login.Usuarios;

import javax.swing.*;
import java.awt.*;
public class TelaCadastro {

    public TelaCadastro(CadastroUsuarios cadastroUsuarios){
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

        int option = JOptionPane.showOptionDialog(null, panel, "Cadastro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Registrar", "Cancelar"}, null);

        if (option == 0) {
            String nome = nomeUsuarioField.getText();
            String senha = new String(senhaUsuarioField.getPassword());


        }

    }

}
