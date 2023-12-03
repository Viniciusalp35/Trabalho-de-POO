package gui;
import Carros.*;
import serializador.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TelaEntrada extends JFrame {

    public ArmazenaCar armazenaCar;
    private JComboBox<String> tipoCarroComboBox;
    private JPanel carrosPanel;

    public TelaEntrada() {
        armazenaCar = new ArmazenaCar();
        armazenaCar.checaEstoque("Listadoscarrosdeluxo");
        armazenaCar.checaEstoque("Listadoscarroseconomicos");


        setTitle("Escolher Carro");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
    }

    public void initComponents() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 240, 240)); // Cor de fundo

        JPanel filtroPanel = new JPanel();
        filtroPanel.setPreferredSize(new Dimension(1200, 50));
        filtroPanel.setBackground(new Color(200, 200, 200)); // Cor de fundo do painel de filtro

        tipoCarroComboBox = new JComboBox<>(new String[]{"Carro Econômico", "Carro de Luxo"});
        tipoCarroComboBox.setBackground(new Color(255, 255, 255)); // Cor de fundo da caixa de seleção
        tipoCarroComboBox.setForeground(new Color(50, 50, 50)); // Cor do texto da caixa de seleção

        filtroPanel.add(tipoCarroComboBox);

        carrosPanel = new JPanel();
        carrosPanel.setLayout(new GridLayout(0, 4));
        carrosPanel.setBackground(new Color(240, 240, 240)); // Cor de fundo do painel de carros

        JScrollPane scrollPane = new JScrollPane(carrosPanel);
        scrollPane.setPreferredSize(new Dimension(1200, 700));

        panel.add(filtroPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);

        tipoCarroComboBox.addActionListener(e -> exibirCarros());
        exibirCarros();
    }

    public void exibirCarros() {
        carrosPanel.removeAll();

        String tipoSelecionado = (String) tipoCarroComboBox.getSelectedItem();

        if (tipoSelecionado != null) {
            Carros[] carros = (tipoSelecionado.equals("Carro Econômico"))
                    ? armazenaCar.listarCarrosEco()
                    : armazenaCar.listarCarrosLuxo();

            if (carros != null && carros.length > 0) {
                for (Carros carro : carros) {
                    String infoCarro = carro.getModelo() + " - " + carro.getPlaca() +
                            " | Cor: " + ((carro instanceof CarrosLux) ? ((CarrosLux) carro).getCor() : "");

                    JButton carroButton = new JButton("<html><center><font size='3' color='#FFFFFF'>" + infoCarro + "</font></center></html>");
                    carroButton.setBackground(new Color(255, 152, 0)); // Cor de fundo laranja
                    carroButton.setBorder(BorderFactory.createCompoundBorder(
                            BorderFactory.createLineBorder(new Color(255, 152, 0), 2), // Borda laranja
                            BorderFactory.createEmptyBorder(5, 10, 5, 10))); // Preenchimento interno
                    carroButton.addActionListener(e -> mostrarMensagem(infoCarro));
                    carrosPanel.add(carroButton);
                }
            } else {
                // Adiciona um rótulo invisível para centralizar o texto na tela
                carrosPanel.add(Box.createGlue());

                JLabel nenhumCarroLabel = new JLabel("Nenhum modelo disponível desse tipo.");
                nenhumCarroLabel.setForeground(new Color(255, 0, 0)); // Cor do texto de nenhum carro disponível
                nenhumCarroLabel.setHorizontalAlignment(JLabel.CENTER);
                nenhumCarroLabel.setBorder(BorderFactory.createLineBorder(new Color(255, 152, 0), 2)); // Borda laranja
                nenhumCarroLabel.setOpaque(true);
                nenhumCarroLabel.setBackground(new Color(255, 224, 178)); // Cor de fundo laranja claro
                carrosPanel.add(nenhumCarroLabel);
            }

            // Configuração do layout para tentar ajustar o tamanho dos botões
            carrosPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Ajuste conforme necessário

            carrosPanel.revalidate();
            carrosPanel.repaint();
        }
    }

    private void mostrarMensagem(String infoCarro) {
        JOptionPane.showMessageDialog(this, "Você escolheu: " + infoCarro,
                "Carro Escolhido", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void carregarCarros(ArmazenaCar armazenaCar) {

        armazenaCar.salvarCarros();
    }

}


