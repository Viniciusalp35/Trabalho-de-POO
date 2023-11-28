package exception;

public class SenhaErrada extends Exception{
    private String senha;
    public SenhaErrada (String senha){
        this.senha = senha;
    }

    @Override
    public String toString() {
        return String.format("Senha inserida %s está errada", this.senha);
    }
}
