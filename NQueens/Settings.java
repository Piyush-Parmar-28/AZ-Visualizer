package NQueens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings {
    static class settingsFrame extends JFrame {
        settingsFrame(){
            JLabel l1= new JLabel("Set Board Size: ");
            JTextField text= new JTextField(10);
            JButton btn= new JButton("Run");

            JLabel l2= new JLabel("Set Animation delay (ms): ");
            JSlider slider= new JSlider();

            add(l1);
            add(text);
            add(btn);
            add(l2);
            add(slider);

            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String n= text.getText();
                    int speed= slider.getValue();

                    String[] args= {n, Integer.toString(speed)};
                    nQueens2.main(args);
                }
            });

            setVisible(true);
            setSize(500,500);
            setLayout(new FlowLayout());
            setTitle("N Queens Visualization");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    }

    public static void main(String[] args) {
        settingsFrame obj= new settingsFrame();
    }
}
