package login;

import java.io.Serializable;
import java.util.Vector;

import exception.DialogoExcessao;
import exception.NomeJaUtilizado;
import exception.UsuarioNaoEncontrado;
import exception.DialogoExcessao;
import exception.SenhaErrada;

public class CadastroUsuarios implements Serializable {
    private Vector<Usuarios> users;

    public CadastroUsuarios() {
        users = new Vector<Usuarios>();
    }

    public void CadastrarUsuario(Usuarios usuario) throws NomeJaUtilizado{
        try {
            for (Usuarios user : users) {
                if (user.getNomeUsuario().equals(usuario.getNomeUsuario())) {
                    throw new NomeJaUtilizado(usuario.getNomeUsuario());
                }
            }
            users.add(usuario);
        } catch(NomeJaUtilizado e){
            new DialogoExcessao(e);
        }
    }
    public Usuarios ProcurarUsuario(String nomeUsuario) throws UsuarioNaoEncontrado{
        try {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getNomeUsuario().equals(nomeUsuario)) {
                    return users.get(i);
                }
            }
            throw new UsuarioNaoEncontrado(nomeUsuario);
        } catch(UsuarioNaoEncontrado e){
            new DialogoExcessao(e);
            return null;
        }
    }

    public int FazerLogin(Usuarios usuarios) throws UsuarioNaoEncontrado{
        Usuarios cadastrado = ProcurarUsuario(usuarios.getNomeUsuario());
        if(cadastrado != null) {
            try {
                if (!cadastrado.getSenha().equals(usuarios.getSenha())) {
                    throw new SenhaErrada(usuarios.getSenha());
                } else{
                    if (usuarios.isPrime()) {
                        return 2;
                    }
                    return 1;
                }
            } catch (SenhaErrada e) {
                new DialogoExcessao(e);
            }
        }
        return 0;
    }

}