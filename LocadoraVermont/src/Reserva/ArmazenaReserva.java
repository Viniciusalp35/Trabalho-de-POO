package Reserva;
import Carros.Carros;
import java.util.ArrayList;
import java.util.List;

public class ArmazenaReserva {
    private static List<Reserva> reservas = new ArrayList<>();

    public static void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public static List<Reserva> obterTodasAsReservas() {
        return new ArrayList<>(reservas);
    }

    public static List<Reserva> obterReservasDoCarro(Carros carro) {
        List<Reserva> reservasDoCarro = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getCarro().equals(carro)) {
                reservasDoCarro.add(reserva);
            }
        }
        return reservasDoCarro;
    }
}

