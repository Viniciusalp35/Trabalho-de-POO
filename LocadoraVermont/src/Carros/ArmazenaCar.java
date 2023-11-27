package Carros;

import serializador.Serializator;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Vector;

public class ArmazenaCar implements Serializable {

    private Vector<Carros> CarrosdeLuxo;
    private Vector<Carros> CarrosEconomicos;

    public ArmazenaCar(){
        this.CarrosdeLuxo = new Vector<Carros>();
        this.CarrosEconomicos = new Vector<Carros>();
    }

    public Carros checarCarros(String placa){
        for (Carros car : this.CarrosdeLuxo){
            if(car.getPlaca().equals(placa)){
                return car;
            }
        }
        for (Carros car: this.CarrosEconomicos){
            if(car.getPlaca().equals(placa)){
                return car;
            }
        }
        return null;
    }

    public void adicionarCarros(Carros carro){
        if(!verificaRegistro(carro.getPlaca()) && carro.getPlaca() != null){
            if(carro instanceof CarrosLux){
                CarrosdeLuxo.add(carro);
            } else if (carro instanceof CarrosEco) {
                CarrosEconomicos.add(carro);
            }
        }
    }

    public void salvarCarros(){
        Serializator salvador = new Serializator();
        salvador.salvar(listarCarrosLuxo(),"Listadoscarrosdeluxo");
        salvador.salvar(listarCarrosEco(),"Listadoscarroseconomicos");
    }

    public ArmazenaCar checaEstoque(String localdesalvamento){
        ResgatandoLista resgatador = new ResgatandoLista(localdesalvamento);
        return resgatador.carregaListagem();
    }


   public boolean verificaRegistro(String placa){
       return checarCarros(placa) != null;
   }

   public CarrosEco[] listarCarrosEco(){
       CarrosEco[] arrayEco = null;
        if(!CarrosEconomicos.isEmpty()){
            arrayEco = new CarrosEco[CarrosEconomicos.size()];
            arrayEco = CarrosEconomicos.toArray(arrayEco);
        }
        return arrayEco;
   }

   public CarrosLux[] listarCarrosLuxo(){
       CarrosLux[] arrayLuxo = null;
        if(!CarrosdeLuxo.isEmpty()){
            arrayLuxo = new CarrosLux[CarrosdeLuxo.size()];
            arrayLuxo = CarrosdeLuxo.toArray(arrayLuxo);
        }
        return arrayLuxo;
   }

}