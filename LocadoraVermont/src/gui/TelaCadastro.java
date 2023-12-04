package gui;

import exception.DialogoExcessao;
import exception.NomeJaUtilizado;
import login.CadastroUsuarios;
import login.Usuarios;
import serializador.SalvarUsuarios;

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
        JCheckBox isprime = new JCheckBox();
        isprime.setText("Assinar usuário prime?");

        panel.add(nomeUsuario);
        panel.add(nomeUsuarioField);
        panel.add(senhaUsuario);
        panel.add(senhaUsuarioField);
        panel.add(isprime);

        int option = JOptionPane.showOptionDialog(null, panel, "Cadastro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Registrar", "Cancelar"}, null);

        int verificador;

        if (option == 0) {
            String nome = nomeUsuarioField.getText();
            String senha = new String(senhaUsuarioField.getPassword());

            if(isprime.isSelected()){
                verificador = 2;
            }else{
                verificador = 1;
            }
            System.out.println(verificador);

            Usuarios usuarios = new Usuarios(nome, senha, true);
            if(verificador == 1) {
                usuarios.setPrime(false);
            } else {
                usuarios.setPrime(true);
            }

            try {
                cadastroUsuarios.CadastrarUsuario(usuarios);
                SalvarUsuarios.serializar(cadastroUsuarios);
            } catch(Exception e){
                new DialogoExcessao(e);
            }
        }

    }

}
