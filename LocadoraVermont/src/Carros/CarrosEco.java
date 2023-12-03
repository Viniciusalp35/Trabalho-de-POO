package Carros;

public class CarrosEco extends Carros {

    private double taxaEco;

    public CarrosEco(String modelo, String cor, double preco, boolean status, String tipo, double taxaEco, String placa) {
        super(status , placa);
        this.taxaEco = taxaEco;
        this.cor = cor;
        this.modelo = modelo;
        this.preco = preco;
        this.Tipo = tipo;
    }

    public void setTaxaEco(double novaTaxaEco) {
        this.taxaEco = novaTaxaEco;
    }

    public double getTaxaEco() {
        return taxaEco;
    }

    public void setPreço(double preco) {
        this.preco = preco + taxaEco;
    }


}