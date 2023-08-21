package AZ_Visualizer.Knight_Tour;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings {
    static class settingsFrame extends JFrame {
        settingsFrame(){
            JLabel l1= new JLabel("Set Board Size: ");
            JTextField text1= new JTextField(10);

            JLabel l2= new JLabel("Set Animation delay (ms): ");
            JSlider slider= new JSlider();

            JLabel l3= new JLabel("Enter Source (x, y): ");
            JTextField sx= new JTextField(5);
            JTextField sy= new JTextField(5);

            JLabel l4= new JLabel("Enter Destination (x, y): ");
            JTextField dx= new JTextField(5);
            JTextField dy= new JTextField(5);

            JButton btn= new JButton("Run");

            add(l1);
            add(text1);

            add(l2);
            add(slider);

            add(l3);
            add(sx);
            add(sy);

            add(l4);
            add(dx);
            add(dy);

            add(btn);

            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String n= text1.getText();
                    int delay= slider.getValue();

                    String x1= sx.getText();
                    String y1= sy.getText();

                    String x2= dx.getText();
                    String y2= dy.getText();

                    String[] args= {n, Integer.toString(delay), x1, y1, x2, y2};
                    Tour.main(args);
                }
            });

            setVisible(true);
            setSize(500,500);
            setLayout(new FlowLayout());
            setTitle("Knight Tour Visualization");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    }

    public static void main(String[] args) {
        settingsFrame obj= new settingsFrame();
    }
}
