
import Carros.*;

import login.Usuarios;
import login.CadastroUsuarios;
import gui.Login;
import serializador.SalvarUsuarios;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");

        CadastroUsuarios cadastroUsuarios = SalvarUsuarios.deserializar();
        if(cadastroUsuarios == null) {
            cadastroUsuarios = new CadastroUsuarios();
            System.out.println("nenhum usuário salvo!");
        }
        Login login = new Login(cadastroUsuarios);
        SalvarUsuarios.serializar(cadastroUsuarios);
    }
}