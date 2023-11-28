package exception;

import javax.swing.*;
import java.awt.*;

public class DialogoExcessao {

    JFrame frame = new JFrame();
    JLabel label;

    public DialogoExcessao(Exception exception){

        label = new JLabel(exception.toString());
        label.setBounds(0,0,300,100);

        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(null);
        frame.setVisible(true);

    }
}
