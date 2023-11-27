package exception;

import javax.swing.*;
import java.awt.*;

public class DialogoExcessao {

    public DialogoExcessao(Exception exception){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        String erro = exception.toString();
        JLabel erroLabel = new JLabel(erro);

        int option = JOptionPane.showOptionDialog(null, panel, "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
        panel.add(erroLabel);
    }
}
