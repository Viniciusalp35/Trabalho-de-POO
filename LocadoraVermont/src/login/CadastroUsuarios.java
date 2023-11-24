package login;

import java.util.Vector;
import exception.NomeJaUtilizado;
public class CadastroUsuarios {
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
            System.out.println(e.toString());
        }
    }
    public int ProcurarUsuario(String nomeUsuario) {
        for(int i = 0; i < users.size(); i++) {
            if(users.get(i).getNomeUsuario().equals(nomeUsuario)) {
                return i;
            }
        } return -1;
    }

    public void RemoverUsuario(String nomeUsuario) {
        int remover = ProcurarUsuario(nomeUsuario);
        users.remove(remover);
    }

    public boolean VerificarUsuario(String nomeUsuario) {
        int index = ProcurarUsuario(nomeUsuario);
        if(index == -1) {
            return false;
        } else {
            return true;
        }
    }

}