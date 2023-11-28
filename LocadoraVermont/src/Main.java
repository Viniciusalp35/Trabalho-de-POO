import Carros.*;

public class Main {
    public static void main(String[] args) {
        ArmazenaCar armazem = new ArmazenaCar();
        armazem.checaEstoque("Listadoscarrosdeluxo");
        armazem.listarCarrosLuxo();
    }
}