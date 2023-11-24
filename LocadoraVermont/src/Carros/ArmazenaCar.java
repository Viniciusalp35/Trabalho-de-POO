package Carros;

import java.util.Vector;

public class ArmazenaCar {

    private Vector<Carros> carros;

    public ArmazenaCar(Carros carro){
        this.carros = new Vector<Carros>();
    }

    public Carros checarCarros(String placa){
        for (Carros car : this.carros){
            if(car.getPlaca().equals(placa)){
                return car;
            }
        }
        return null;
    }

    public void adicionarCarros(Carros carro){
        if(!verificaRegistro(carro.getPlaca()) && carro.getPlaca() != null){
            carros.add(carro);
        }
    }

   public boolean verificaRegistro(String placa){
       return checarCarros(placa) != null;
   }


}
