package gui;

import pagamento.*;
import login.Usuarios;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPagamento {
    private JFrame frame;
    private JTextField valorTotalField;
    private JTextField descontoField;
    private JTextField parcelasField;
    private JButton confirmarButton;
    private PagamentoAbstrato pagamento;
    private Usuarios usuario;


    public TelaPagamento() {
        frame = new JFrame("Pagamento - Locadora de Carros");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(4, 2));

        //if (verificador == 1) {
        JLabel valorTotalLabel = new JLabel("Valor Total:");
        frame.add(valorTotalLabel);


        JLabel descontoLabel = new JLabel("Desconto (%):");
        descontoField = new JTextField();
        frame.add(descontoLabel);
        frame.add(descontoField);

        JLabel parcelasLabel = new JLabel("Parcelas:");
        parcelasField = new JTextField();
        frame.add(parcelasLabel);
        frame.add(parcelasField);

        confirmarButton = new JButton("Confirmar");
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculaPagamento();
            }
        });
        frame.add(confirmarButton);

        frame.setVisible(true);
    }

    private void calculaPagamento() {
        try {
            double valorTotal = Double.parseDouble(valorTotalField.getText());
            double desconto = Double.parseDouble(descontoField.getText());
            int parcelas = Integer.parseInt(parcelasField.getText());

            double valorComDesconto = valorTotal * (1 - desconto / 100);
            double valorParcela = valorComDesconto / parcelas;

            JOptionPane.showMessageDialog(frame,
                    "Valor com desconto: R$" + String.format("%.2f", valorComDesconto) +
                            "\nValor da parcela (" + parcelas + "x): R$" + String.format("%.2f", valorParcela),
                    "Resultado do Pagamento",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame,
                    "Por favor, insira valores válidos.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}

