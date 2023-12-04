package Reserva;

import Carros.Carros;
import login.Usuarios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reserva {

    //atributos
    private Carros carro;
    private Usuarios usuario;
    private Date dataInicio;
    private Date dataFim;

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
            this.dataFim = new SimpleDateFormat("dd/MM/yyyy").parse(dataFim);
        } catch (ParseException ex) {
            Logger.getLogger(Reserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Reserva(Carros carro, String dataInicio, String dataFim) {
        this.carro = carro;
        try {
            this.dataInicio = new SimpleDateFormat("dd/MM/yyyy").parse(dataInicio);
        } catch (ParseException ex) {
            Logger.getLogger(Reserva.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.dataFim = new SimpleDateFormat("dd/MM/yyyy").parse(dataFim);
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

    public void realizarReserva() {
        if (verificarDisponibilidade()) {
            carro.setStatus(false); // Define o status do carro como indisponível
            // Adicione a lógica para adicionar a reserva à sua lista de reservas, salvar no banco de dados, etc.
            System.out.println("Reserva realizada com sucesso!");
        } else {
            // Lógica para lidar com a indisponibilidade do carro
            System.out.println("Carro não disponível para reserva no período especificado.");
        }
    }

    // Método para verificar a disponibilidade do carro
    public boolean verificarDisponibilidade() {
        List<Reserva> reservasDoCarro = ArmazenaReserva.obterReservasDoCarro(carro);

        for (Reserva reservaExistente : reservasDoCarro) {
            if (sobreposicaoDatas(dataInicio, dataFim, reservaExistente.getDataInicio(), reservaExistente.getDataFim())) {
                //System.out.println("Carro não disponível para reserva no período especificado.");
                return false;
            }
        }
        return true;
    }

    private boolean sobreposicaoDatas(Date inicio1, Date fim1, Date inicio2, Date fim2) {
        return inicio1.before(fim2) && fim1.after(inicio2);
    }

    public int NumeroDias() {
        long diferencaMillis = dataFim.getTime() - dataInicio.getTime();
        // Converta a diferença de milissegundos para dias usando TimeUnit
        int numeroDias = (int) TimeUnit.MILLISECONDS.toDays(diferencaMillis);
        return numeroDias+1;
    }

}
