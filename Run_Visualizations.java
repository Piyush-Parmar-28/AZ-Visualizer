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
            JLabel title = new JLabel("Welcome to AZ Visualizer", JLabel.CENTER);
            title.setFont(new Font("Arial", Font.BOLD, 24));

            JPanel btnPanel = new JPanel();
            JButton btn1= new JButton("Sudoku Solver");
            JButton btn2= new JButton("N Queens");
            JButton btn3= new JButton("Knight Tour");

            add(title);
            btnPanel.add(btn1);
            btnPanel.add(btn2);
            btnPanel.add(btn3);
            add(btnPanel);

            beautifyBtn(btn1, btn2, btn3);

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
            setLayout(new GridLayout(2, 1));
            setTitle("AZ Visualizer");
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
    }

    public static void main(String[] args) {
        settingsFrame obj= new settingsFrame();
    }

    public static void beautifyBtn(JButton btn1, JButton btn2, JButton btn3){
        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        btn1.setFont(buttonFont);
        btn2.setFont(buttonFont);
        btn3.setFont(buttonFont);

        // Add padding around buttons
        int padding = 10;
        btn1.setMargin(new Insets(padding, padding, padding, padding));
        btn2.setMargin(new Insets(padding, padding, padding, padding));
        btn3.setMargin(new Insets(padding, padding, padding, padding));

        // Set background and foreground colors
        Color backgroundColor = new Color(240, 240, 240);
        Color foregroundColor = new Color(50, 50, 50);
        btn1.setBackground(backgroundColor);
        btn2.setBackground(backgroundColor);
        btn3.setBackground(backgroundColor);
        btn1.setForeground(foregroundColor);
        btn2.setForeground(foregroundColor);
        btn3.setForeground(foregroundColor);
    }
}
