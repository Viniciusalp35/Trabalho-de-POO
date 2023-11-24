package Carros;

public abstract class Carros {
    private String modelo;
    private String cor;
    private double preço;
    private boolean Status;
    private String Tipo;


    public Carros(boolean Status){
        this.Status = Status;
    }


    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public double getPreço() {
        return preço;
    }
    public abstract void setPreço(double preço);

    public boolean isStatus() {
        return Status;
    }
    public void setStatus(boolean status) {
        this.Status = status;
    }
    public String getTipo() {
        return Tipo;
    }
    public void setTipo(String tipo) {
        Tipo = tipo;
    }
}