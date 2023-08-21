package AZ_Visualizer.Sudoku_Solver;

import AZ_Visualizer.NQueens.nQueens2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings {
    static class settingsFrame extends JFrame {
        settingsFrame(){
            JLabel l2= new JLabel("Set Animation delay (ms): ");
            JSlider slider= new JSlider();

            JButton btn= new JButton("Run");

            add(btn);
            add(l2);
            add(slider);

            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int delay= slider.getValue();

                    String[] args= {Integer.toString(delay)};
                    Fetch_Data.main(args);
                }
            });

            setVisible(true);
            setSize(500,500);
            setLayout(new FlowLayout());
            setTitle("Sudoku Solver Visualization");
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
    }

    public static void main(String[] args) {
        settingsFrame obj= new settingsFrame();
    }
}
