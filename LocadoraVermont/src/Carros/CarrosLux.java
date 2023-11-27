package Carros;

public class CarrosLux extends Carros {

    private double taxaLux;

    public CarrosLux(String modelo, String cor, double preco, boolean status, String tipo, double taxaLux, String placa) {
        super(status , placa);
        this.taxaLux = taxaLux;
        this.cor = cor;
        this.modelo = modelo;
        this.preço = preco;
        this.Tipo = tipo;
    }
    public void setTaxaLux(double novaTaxaLux) {
        this.taxaLux = novaTaxaLux;
    }
    public double getTaxaLux() {
        return taxaLux;
    }

    public void setPreço(double preco) {
        this.preço = taxaLux + preco;
    }
}
