package Carros;
import serializador.Serializator;

public class ResgatandoLista {

    private String LocaldeSalvamento;
    public ResgatandoLista(String LocaldeSalvamento){
        this.LocaldeSalvamento = LocaldeSalvamento;
    }

    public ArmazenaCar carregaListagem(){
        Serializator carregador = new Serializator();
        Carros[] carrosarray = carregador.ler(this.LocaldeSalvamento);
        ArmazenaCar Carros = new ArmazenaCar();
        for(Carros temp : carrosarray){
            Carros.adicionarCarros(temp);
        }
        return Carros;
    }
}
