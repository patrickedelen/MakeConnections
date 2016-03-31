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
    public static boolean running = true;
    
    public static void main(String[] args) {
        //initiate the frame and draw the game board
        
        drawBoard();
        System.out.println("Welcome to MakeConnections!");
        System.out.println("Use the numbers 0-6 to play a chip");
        System.out.println("First to four wins!\n");
        
        //print the game board
        printBoard();
        
        boolean player1 = true;
        
        while(running){
            //get player1 choice
            int column = scan.nextInt();
            scan.nextLine();
            dropChip(player1, column);
            
            player1 = !player1;
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
        //frame1.setVisible(true);
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
    
    public static void dropChip(boolean player1, int column){
        //Checking the height of the board and setting the first empty spot in the collumn to the player's number
        for(int r = 5; r >= 0; r--){
            if(board[r][column] == 0){
                board[r][column] = (player1) ? 1 : 2;
                r = 0;
                checkBoard(player1);
            }
        }
        
        if(running) {printBoard();}
    
    }
    
    public static void checkBoard(boolean player1){
        int player = player1 ? 1 : 2;
        //System.out.println("player: " + player);
        
        //check vertical chips starting with a (vertical) 0
        for(int a = 5; a > 2; a--){
            for(int b = 0; b < 7; b++){
                if(board[a][b] == player){
                    System.out.println("checking vertical board position: " + a + " " + b);
                    checkVertical(a, b, 0, player);
                }
            }
        }
        
        //check horizontal chips starting with a (vertical) 0
        for(int a = 5; a >= 0; a--){
            for(int b = 0; b < 4; b++){
                if(board[a][b] == player){
                    System.out.println("checking horizontal board position: " + a + " " + b);
                    checkHorizontal(a, b, 0, player);
                }
            }
        }
    }
    
    public static void checkVertical(int a, int b, int count, int player){
        if(a >= 0){
            if(board[a][b] == player){
                count++;
                
                if(count == 4){
                    printBoard();
                    System.out.println("Connection made! Player " + board[a][b] + " wins!");
                    running = false;
                } else {
                    a--;
                    checkVertical(a, b, count, player); 
                }
            }
        } else if(a < 0){
            System.out.println("No connection made " + b);
        }
    }
    
    public static void checkHorizontal(int a, int b, int count, int player){
        if(b < 7){
            if(board[a][b] == player){
                count++;
                
                if(count == 4){
                    printBoard();
                    System.out.println("Connection made! Player " + board[a][b] + " wins!");
                    running = false;
                } else {
                    b++;
                    checkHorizontal(a, b, count, player);
                }
            }
        } else if(b > 7){
            System.out.println("No horizontal connection made " + a);
        }
    }
    
    private boolean updateBoard() {
        repaint();
        return true;
    }
    
    @Override
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.drawOval(5, 5, 10, 10);
        
    }
    
}
