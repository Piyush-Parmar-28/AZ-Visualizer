package AZ_Visualizer;

import AZ_Visualizer.Sudoku_Solver.Fetch_Data;
import AZ_Visualizer.Sudoku_Solver.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Run_Visualizations {
    static class settingsFrame extends JFrame {
        settingsFrame(){
            JButton btn1= new JButton("Sudoku Solver");
            JButton btn2= new JButton("N Queens");
            JButton btn3= new JButton("Knight Tour");

            add(btn1);
            add(btn2);
            add(btn3);

            String[] arr= {""};
            btn1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    AZ_Visualizer.Sudoku_Solver.Settings.main(arr);
                }
            });

            btn2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    AZ_Visualizer.NQueens.Settings.main(arr);
                }
            });

            btn3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    AZ_Visualizer.Knight_Tour.Settings.main(arr);
                }
            });

            setVisible(true);
            setSize(500,500);
            setLayout(new FlowLayout());
            setTitle("AZ Visualizer");
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
    }

    public static void main(String[] args) {
        settingsFrame obj= new settingsFrame();
    }
}
