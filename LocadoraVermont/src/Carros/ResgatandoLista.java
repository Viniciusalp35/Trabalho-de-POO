package Carros;
import serializador.Serializator;

public class ResgatandoLista {

    private String LocaldeSalvamento;
    public ResgatandoLista(String LocaldeSalvamento){
        this.LocaldeSalvamento = LocaldeSalvamento;
    }

    public Carros[] carregaListagem(){
        Serializator carregador = new Serializator();
        Carros[] carrosarray = carregador.ler(this.LocaldeSalvamento);

        return carrosarray;
    }
}
