package exception;

public class NomeJaUtilizado  extends Exception{
    private String nomeUsuario;
    public NomeJaUtilizado(String nomeUsuario){
        this.nomeUsuario = nomeUsuario;
    }

    @Override
    public String toString() {
        return String.format("O nome de usuário %s já foi cadastrado", this.nomeUsuario);
    }
}
