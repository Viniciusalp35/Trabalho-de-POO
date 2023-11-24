import login.Usuarios;
import login.CadastroUsuarios;
import gui.Login;

public class Main {
    public static void main(String[] args) throws Exception{
        System.out.println("Hello world!");
        CadastroUsuarios cadastroUsuarios = new CadastroUsuarios();
        Usuarios usuarios = new Usuarios("Joao", "123", false);
        cadastroUsuarios.CadastrarUsuario(usuarios);
        cadastroUsuarios.CadastrarUsuario(usuarios);

        Login login = new Login();
    }
}