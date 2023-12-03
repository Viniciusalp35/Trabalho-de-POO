package serializador;

import login.CadastroUsuarios;

import java.io.*;

public class SalvarUsuarios {

    public static void serializar(CadastroUsuarios cadastroUsuarios) {
        try (ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream("Usuarios.bin"))) {
            objectOutput.writeObject(cadastroUsuarios);
            objectOutput.close();
            System.out.println("Dados serializados com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static CadastroUsuarios deserializar() {
        File arquivo = new File("Usuarios.bin");
        if (arquivo.exists()) {
            try (FileInputStream fileInputStream = new FileInputStream(arquivo);
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

                CadastroUsuarios cadastroUsuarios = (CadastroUsuarios) objectInputStream.readObject();
                System.out.println("Dados deserializados com sucesso!");
                return cadastroUsuarios;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
}

