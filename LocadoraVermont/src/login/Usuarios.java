package login;

import java.io.Serializable;

public class Usuarios implements Serializable {
    private String nomeUsuario;
    private String senha;
    private boolean prime;

    public Usuarios(String nomeUsuario, String senha) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }


    public String getNomeUsuario() {
        return nomeUsuario;
    }
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isPrime() {
        return prime;
    }
    public void setPrime(boolean prime) {
        this.prime = prime;
    }

}
