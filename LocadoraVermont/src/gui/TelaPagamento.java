package gui;

import pagamento.*;
import login.Usuarios;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPagamento {
    private JFrame frame;
    private JButton confirmarButton;
    private JButton cancelarButton;
    private PagamentoAbstrato pagamento;
    private Usuarios usuario;


    public TelaPagamento() {
        frame = new JFrame("Pagamento - Locadora de Carros");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(5, 2));

        int verificador = 2;
        if (verificador == 1) {
            pagamento = new PagamentoBasico(60,12);
        } else if (verificador == 2) {
            pagamento = new PagamentoPrime(60,12);
        }
        pagamento.calcularValorTotal();
        JLabel valorTotalLabel = new JLabel("Valor Total Com Desconto:");
        frame.add(valorTotalLabel);
        JLabel valorNumerico = new JLabel("R$ " + String.valueOf(pagamento.getTotalAPagar()));
        frame.add(valorNumerico);

        JLabel descontoLabel = new JLabel("Desconto (%):");
        frame.add(descontoLabel);
        JLabel descontoNumerico = new JLabel(String.valueOf(pagamento.getTaxaDesconto() * 100));
        frame.add(descontoNumerico);

        JLabel parcelasLabel = new JLabel("Parcelas:");
        frame.add(parcelasLabel);
        JLabel parcelasNumerico = new JLabel(String.valueOf(pagamento.getParcelas()));
        frame.add(parcelasNumerico);

        JLabel valorParcelasLabel = new JLabel("Valor Por Parcelas:");
        frame.add(valorParcelasLabel);
        JLabel valorParcelasNumerico = new JLabel(String.valueOf(pagamento.calcularValorParcelado()));
        frame.add(valorParcelasNumerico);

        confirmarButton = new JButton("Confirmar");
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultadoPagamento();
            }
        });
        frame.add(confirmarButton);

        cancelarButton = new JButton("Cancelar");
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        frame.add(cancelarButton);


        frame.setVisible(true);
    }

    private void resultadoPagamento() {
        JOptionPane.showMessageDialog(frame,
                "Pagamento realizado com sucesso!",
                "Resultado do Pagamento",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void cancelarPagamento() {

    }
}

