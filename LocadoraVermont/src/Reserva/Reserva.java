package Reserva;

import Carros.Carros;
import login.Usuarios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reserva {

    //atributos
    private Carros carro;
    private Usuarios usuario;
    private Date dataInicio;
    private Date dataFim;
    private double valorTotal;

    //métodos

    public Reserva(Carros carro, Usuarios usuario, String dataInicio, String dataFim) {
        this.carro = carro;
        this.usuario = usuario;
        try {
            this.dataInicio = new SimpleDateFormat("dd/MM/yyyy").parse(dataInicio);
        } catch (ParseException ex) {
            Logger.getLogger(Reserva.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.dataFim = new SimpleDateFormat("dd/MM/yyyy").parse(dataInicio);
        } catch (ParseException ex) {
            Logger.getLogger(Reserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Carros getCarro() {
        return carro;
    }

    public void setCarro(Carros carro) {
        this.carro = carro;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public void checarDisponibilidade(String dataInicio, String dataFim){
    }
    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
