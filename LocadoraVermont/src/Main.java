import Carros.*;

public class Main {
    public static void main(String[] args) {


        CarrosLux mercedes1 = new CarrosLux("as","bd",192,true,"luxo",19,"adassdad");
        CarrosLux mercedes = new CarrosLux("a","b",192,true,"luxo",19,"adasdad");
        ArmazenaCar armazem = new ArmazenaCar();
        armazem.adicionarCarros(mercedes);
        armazem.adicionarCarros(mercedes1);
        armazem.listarCarrosLuxo();
    }
}