package exception;

public class UsuarioNaoEncontrado extends Exception{
    private String nomeUsuario;
    public UsuarioNaoEncontrado(String nomeUsuario){
        this.nomeUsuario = nomeUsuario;
    }

    @Override
    public String toString() {
        return String.format("O nome de usuário %s não foi encontrado", this.nomeUsuario);
    }
}
