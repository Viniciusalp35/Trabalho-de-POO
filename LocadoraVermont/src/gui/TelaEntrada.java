package gui;
import Carros.*;
import serializador.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TelaEntrada extends JFrame {

    public ArmazenaCar armazenaCar;
    private String placaSelecionada;
    private JComboBox<String> tipoCarroComboBox;
    private JPanel carrosPanel;

    private String getCorCarro(Carros carro) {
        if (carro instanceof CarrosLux) {
            return ((CarrosLux) carro).getCor();
        } else if (carro instanceof CarrosEco) {
            return ((CarrosEco) carro).getCor();
        } else {
            return ""; // Se não for nenhum dos tipos conhecidos
        }
    }

    private Color getCorFundoCarro(Carros carro) {
        if (carro instanceof CarrosLux) {
            return new Color(255, 152, 0); // Laranja para CarrosLux
        } else if (carro instanceof CarrosEco) {
            return new Color(0, 102, 204); // Azul para CarrosEco
        } else {
            return new Color(255, 255, 255); // Branco se não for nenhum dos tipos conhecidos
        }
    }

    public TelaEntrada(int verificador) {
        armazenaCar = new ArmazenaCar();
        armazenaCar.checaEstoque("Listadoscarrosdeluxo");
        armazenaCar.checaEstoque("Listadoscarroseconomicos");


        setTitle("Escolher Carro");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents(verificador);
    }

    public void initComponents(int verificador) {
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

        tipoCarroComboBox.addActionListener(e -> exibirCarros(verificador));
        exibirCarros(verificador);
    }

    public void mostrarMensagem(Carros carros, int verificador) {
        TelaReserva telaReserva = new TelaReserva(carros, verificador);
    }

    public static void carregarCarros (ArmazenaCar armazenaCar){
        CarrosEco renaultKwid = new CarrosEco("Renault Kwid", "Branco", 300, true, "Econômico", 1000, "XYZ123");
        CarrosEco fiatMobi = new CarrosEco("Fiat Mobi", "Prata", 280, true, "Econômico", 950, "ABC456");
        CarrosEco citroenC3 = new CarrosEco("Citroën C3", "Azul", 320, true, "Econômico", 1100, "DEF789");
        CarrosEco peugeot208 = new CarrosEco("Peugeot 208", "Preto", 310, true, "Econômico", 1050, "GHI012");
        CarrosEco fiatArgo = new CarrosEco("Fiat Argo", "Vermelho", 290, true, "Econômico", 980, "JKL345");
        CarrosEco hyundaiHB20 = new CarrosEco("Hyundai HB20", "Verde", 330, true, "Econômico", 1150, "MNO678");

        armazenaCar.adicionarCarros(renaultKwid);
        armazenaCar.adicionarCarros(fiatMobi);
        armazenaCar.adicionarCarros(citroenC3);
        armazenaCar.adicionarCarros(peugeot208);
        armazenaCar.adicionarCarros(fiatArgo);
        armazenaCar.adicionarCarros(hyundaiHB20);

        CarrosLux mercedes = new CarrosLux("Mercedes", "Prata", 1000, true, "Luxo", 2000, "ABC123");
        CarrosLux corvete = new CarrosLux("Corvete", "Vermelho", 800, true, "Luxo", 1500, "DEF456");
        CarrosLux audiA8 = new CarrosLux("Audi A8", "Preto", 1200, true, "Luxo", 2500, "GHI789");
        CarrosLux maybach62 = new CarrosLux("Maybach 62", "Branco", 1500, true, "Luxo", 3000, "JKL012");
        CarrosLux lexusLFA = new CarrosLux("Lexus LFA", "Azul", 2000, true, "Luxo", 4000, "MNO345");
        CarrosLux mclarenF1 = new CarrosLux("McLaren F1", "Amarelo", 2500, true, "Luxo", 5000, "PQR678");
        CarrosLux lexusLS600h = new CarrosLux("Lexus LS600h", "Verde", 1800, true, "Luxo", 3000, "STU901");

        armazenaCar.adicionarCarros(mercedes);
        armazenaCar.adicionarCarros(corvete);
        armazenaCar.adicionarCarros(audiA8);
        armazenaCar.adicionarCarros(maybach62);
        armazenaCar.adicionarCarros(lexusLFA);
        armazenaCar.adicionarCarros(mclarenF1);
        armazenaCar.adicionarCarros(lexusLS600h);

        armazenaCar.salvarCarros();
    }
    private void exibirCarros(int verificador) {
        carrosPanel.removeAll();

        String tipoSelecionado = (String) tipoCarroComboBox.getSelectedItem();

        if (tipoSelecionado != null) {
            carrosPanel.setLayout(new BoxLayout(carrosPanel, BoxLayout.Y_AXIS));

            Carros[] carros = (tipoSelecionado.equals("Carro Econômico"))
                    ? armazenaCar.listarCarrosEco()
                    : armazenaCar.listarCarrosLuxo();

            for (Carros carro : carros) {
                String infoCarro = carro.getModelo() + " - " + carro.getPlaca() +
                        " | Cor: " + getCorCarro(carro) +
                        " | Preço: " + carro.getPreço();

                JButton carroButton = new JButton("<html><center><font size='2' color='#FFFFFF'>" + infoCarro + "</font></center></html>");
                carroButton.setBackground(getCorFundoCarro(carro)); // Cor de fundo
                carroButton.setPreferredSize(new Dimension(150, 50)); // Ajuste de tamanho
                carroButton.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(getCorFundoCarro(carro), 2), // Borda
                        BorderFactory.createEmptyBorder(5, 10, 5, 10))); // Preenchimento interno
                carroSelecionado(carro.getPlaca());
                Carros carros2 = armazenaCar.checarCarros(getPlacaSelecionada());
                carroButton.addActionListener(e -> mostrarMensagem(carros2, verificador));
                carrosPanel.add(carroButton);

                // Adiciona espaço vertical entre os botões
                carrosPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            }

        } else {
            JLabel nenhumCarroLabel = new JLabel("Nenhum modelo disponível desse tipo.");
            nenhumCarroLabel.setForeground(new Color(255, 0, 0)); // Cor do texto de nenhum carro disponível
            nenhumCarroLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT); // Centraliza horizontalmente
            nenhumCarroLabel.setAlignmentY(JLabel.CENTER_ALIGNMENT); // Centraliza verticalmente
            nenhumCarroLabel.setBorder(BorderFactory.createLineBorder(new Color(255, 152, 0), 2)); // Borda laranja
            nenhumCarroLabel.setOpaque(true);
            nenhumCarroLabel.setBackground(new Color(255, 224, 178)); // Cor de fundo laranja claro

            // Adiciona a mensagem centralizada
            carrosPanel.add(Box.createVerticalGlue());
            carrosPanel.add(nenhumCarroLabel);
            carrosPanel.add(Box.createVerticalGlue());
        }

        carrosPanel.revalidate();
        carrosPanel.repaint();
    }
    private void carroSelecionado(String placa) {
        this.placaSelecionada = placa;
    }

    public String getPlacaSelecionada() {
        return placaSelecionada;
    }
}