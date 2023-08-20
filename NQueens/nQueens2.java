package AZ_Visualizer.NQueens;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;

public class nQueens2 {
    static HashSet<Integer> leftDia;
    static HashSet<Integer> rightDia;
    static HashSet<Integer> hor;
    static HashSet<Integer> ver;
    static int n;
    static JLabel[][] jLabel;
    static int[][] board;
    static int delay;

    static class myFrame extends JFrame{
        myFrame(int boardSize){
            n= boardSize;

            jLabel = new JLabel[n][n];
            board= new int[n][n];

            setVisible(true);
            setSize(500,500);

            setLayout(new GridLayout(n, n, 2, 2));
            setTitle("N Queens Visualization");
            setDefaultCloseOperation(EXIT_ON_CLOSE);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    jLabel[i][j] = new JLabel();
                    jLabel[i][j].setHorizontalAlignment(SwingConstants.CENTER);

                    jLabel[i][j].setOpaque(true);
                    jLabel[i][j].setFont(new Font("Arial", Font.BOLD, 16));
                    jLabel[i][j].setForeground(Color.WHITE);
                    jLabel[i][j].setBackground((i + j) % 2 == 0 ? Color.GRAY : Color.DARK_GRAY);

                    add(jLabel[i][j]);
                }
            }
        }
    }

    public static void main( String args[] ){
        leftDia= new HashSet<>();
        rightDia= new HashSet<>();
        hor= new HashSet<>();
        ver= new HashSet<>();

        int boardSize= Integer.parseInt(args[0]);
        delay= Integer.parseInt(args[1]);

        //  Shifting the board creation & solving in the background thread, so as to free up the main thread
        SwingWorker<String, Void> worker = new SwingWorker<String, Void>() {
            @Override
            protected String doInBackground() throws Exception {
                myFrame obj= new myFrame(boardSize);
                solveNQueen(n, 0);

                return "Finished Background task";
            }

            @Override
            protected void done() {
                System.out.println("Task finished");
            }
        };

        // Start the task in a background thread
        worker.execute();
    }

    public static void solveNQueen(int queens, int row){
        if(queens == 0){
            System.out.println("Printing Queen Positions: ");
            printSolution();
            return;
        }

        for(int col=0; col<n; col++){
            //Increase the sleep value to slow down the animation
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if( check(row, col) ){
                leftDia.add(row-col);
                rightDia.add(row+col);
                hor.add(row);
                ver.add(col);
                board[row][col]= 1;

                jLabel[row][col].setBackground(Color.ORANGE);

                solveNQueen(queens-1, row+1);
                jLabel[row][col].setBackground((row + col) % 2 == 0 ? Color.GRAY : Color.DARK_GRAY);

                board[row][col]= 0;
                leftDia.remove(row-col);
                rightDia.remove(row+col);
                hor.remove(row);
                ver.remove(col);
            }
        }

    }

    public static boolean check(int row, int col){
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if( !leftDia.contains(row-col) && !rightDia.contains(row+col) && !hor.contains(row) && !ver.contains(col) ){
            return true;
        }
        return false;
    }

    static void printSolution(){
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                System.out.print(board[i][j]+"\t");
            }
            System.out.printf("\n");
        }

    }
}