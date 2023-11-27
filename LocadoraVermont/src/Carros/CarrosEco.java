package Carros;

public class CarrosEco extends Carros {

    private double taxaEco;

    public CarrosEco(String modelo, String cor, double preco, boolean status, String tipo, double taxaEco, String placa) {
        super(status, placa);
        this.taxaEco = taxaEco;
    }

    public void setTaxaEco(double novaTaxaEco) {
        this.taxaEco = novaTaxaEco;
    }

    public double getTaxaEco() {
        return taxaEco;
    }

    public void setPreço(double preco) {
        this.preço = preco + taxaEco;
    }


}