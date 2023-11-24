package exception;

public class NomeJaUtilizado  extends Exception{

    public NomeJaUtilizado(String nomeUsuario){
        super(String.format("O nome de usuário %s já foi cadastrado", nomeUsuario));
    }

}
