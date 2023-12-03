package Carros;

import java.io.Serializable;

public abstract class Carros implements IStatus, Serializable {
    protected String modelo;
    protected String cor;
    protected double preco;
    protected boolean Status;
    protected String Tipo;
    protected String Placa;


    public Carros(boolean Status, String placa) {
        this.Status = Status;
        this.Placa = placa;
    }

    public String getPlaca() {
        return this.Placa;
    }

    public void setPlaca(String NovaPlaca) {
        this.Placa = NovaPlaca;
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
        return preco;
    }

    public abstract void setPreço(double preço);

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public boolean getStatus() {
        return this.Status;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }
}
