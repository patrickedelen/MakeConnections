/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makeconnections;
import java.awt.*;
import javax.swing.JComponent;
import javax.swing.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Patrick
 */
public class MakeConnections extends JPanel{

    /**
     * @param args the command line arguments
     */
    
    public FindConnections fc = new FindConnections();
    public static Scanner scan = new Scanner(System.in);
    
    //create the connect 4 game board with 7 columns and 6 rows
    public static int[][] board = new int[6][7]; 
    
    public static void main(String[] args) {
        //initiate the frame and draw the game board
        

        boolean running = true;
        
        drawBoard();
        System.out.println("Welcome to MakeConnections!");
        System.out.println("Use the numbers 0-6 to play a chip");
        System.out.println("First to four wins!\n");
        
        //print the game board
        printBoard();
        
        while(running){
            //get player1 choice
            int column = scan.nextInt();
            scan.nextLine();
            dropChip(1, column);
            
            //get player2 choice
            column = scan.nextInt();
            scan.nextLine();
            dropChip(2, column);
            
            //loop
        }
        
    }
    
    public static void drawBoard(){
        //create the canvas
        Canvas canv1 = new Canvas();
        canv1.setSize(800,800);
        canv1.setBackground(Color.BLUE);
        
        Frame frame1 = new Frame();
        frame1.add(canv1);
        frame1.setLayout(new FlowLayout());
        frame1.setSize(800,800);
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
        //set the mouse to the game board
        //requestFocus();
        
    }
    
    public static void printBoard(){
        System.out.println("0 1 2 3 4 5 6");
        System.out.println("-------------");
        for(int a = 0; a < 6; a++){
            for(int b = 0; b < 7; b++){
                System.out.print(board[a][b] + " ");
            }
            System.out.println("");
        }
    }
    
    public static void dropChip(int player, int column){
        
        for(int r = 5; r >= 0; r--){
            if(board[r][column] == 0){
                board[r][column] = player;
                r = 0;
            }
        }
        
        printBoard();
    
    }
    
    private boolean updateBoard() {
        repaint();
        return true;
    }
    
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.drawOval(5, 5, 10, 10);
        
    }
    
}
