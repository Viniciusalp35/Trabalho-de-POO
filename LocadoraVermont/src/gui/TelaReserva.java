package gui;
import Reserva.ArmazenaReserva;
import Reserva.Reserva;
import Carros.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import Carros.Carros;
import login.Usuarios;



public class TelaReserva extends JFrame {

    private Carros selectedCarro;
    private String parcelas;
    private JTextField dataInicioTextField; // Corrigindo o nome do campo
    private JTextField dataFimTextField;
    private JTextField ParcelasField;
    private String dataInicio;
    private String dataFim;

    public TelaReserva(Carros carros, int verificador) {
        setTitle("Reserva GUI");
        setSize(400, 200);
        selectedCarro = carros;

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));


        // Data de Início
        JLabel startDateLabel = new JLabel("Data de Início:");
        panel.add(startDateLabel);
        dataInicioTextField = new JTextField();
        panel.add(dataInicioTextField);


        // Data de Fim
        JLabel endDateLabel = new JLabel("Data de Fim:");
        panel.add(endDateLabel);
        dataFimTextField = new JTextField();
        panel.add(dataFimTextField);

        JLabel Parcelas = new JLabel("Parcelas:");
        panel.add(Parcelas);
        ParcelasField = new JTextField();
        panel.add(ParcelasField);

        // Reservar Button
        JButton reservarButton = new JButton("Reservar");
        panel.add(reservarButton);

        reservarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarReserva(verificador);
            }
        });

        add(panel);
        setVisible(true);
    }

    private void realizarReserva(int verificador) {
        // Obter os dados inseridos pelo usuário
        dataInicio = dataInicioTextField.getText();  // Corrigindo o nome do campo
        dataFim = dataFimTextField.getText();
        parcelas = ParcelasField.getText();

        int parcelasN = Integer.parseInt(parcelas);

        // Validar os dados (adicione validações conforme necessário)
        if (dataInicio.isEmpty() || dataFim.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verificar a disponibilidade usando a classe Reserva
        Reserva novaReserva = new Reserva(selectedCarro, dataInicio, dataFim);
        boolean disponivel = novaReserva.verificarDisponibilidade();

        int dias = novaReserva.NumeroDias();

        // Exibir mensagem com base na disponibilidade
        if (disponivel) {
            ArmazenaReserva.adicionarReserva(novaReserva); // Adicione a reserva à lista de reservas
            TelaPagamento telaPagamento = new TelaPagamento(verificador, parcelasN, dias);
        } else {
            JOptionPane.showMessageDialog(this, "Carro não disponível para reserva no período especificado.", "Indisponível", JOptionPane.WARNING_MESSAGE);
        }
    }
}

