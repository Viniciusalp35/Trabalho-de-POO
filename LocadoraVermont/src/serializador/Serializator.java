package serializador;

import Carros.Carros;

import java.io.*;

public class Serializator {

    public static void salvar(Carros[] carros, String nomeDoArquivo) {

        try {
            // Cria o diretório se ele não existir
            File diretorio = new File(nomeDoArquivo).getParentFile();
            if (diretorio != null && !diretorio.exists()) {
                diretorio.mkdirs();
            }

            // Salva os carros no arquivo especificado
            try (ObjectOutputStream salvador = new ObjectOutputStream(new FileOutputStream(nomeDoArquivo))) {
                salvador.writeObject(carros);
                System.out.println("Carros salvo no arquivo " + nomeDoArquivo);
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Carros[] ler(String nomeDoArquivo) {
        Carros[] carrosLidos = null;

        try (ObjectInputStream leitor = new ObjectInputStream(new FileInputStream(nomeDoArquivo))) {
            carrosLidos = (Carros[]) leitor.readObject();
            System.out.println("Carros lidos do arquivo: " + nomeDoArquivo);
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return carrosLidos;
    }


}
