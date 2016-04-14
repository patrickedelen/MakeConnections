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
    
    public static FindConnections fc = new FindConnections();
    public static CheckConnections cc = new CheckConnections();
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
            
            //end the game if a player wins
            if(!running){
                printBoard();
                System.out.println("Player " + (player1 ? 1 : 2) + " wins!");
                
            }
            
            player1 = !player1;
        }
        
    }
    
    //This method should draw the game board
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
        for(int a = 5; a >= 0; a--){
            for(int b = 0; b < 7; b++){
                System.out.print(board[a][b] + " ");
            }
            System.out.println("");
        }
    }
    
    public static void dropChip(boolean player1, int column){
        //Checking the height of the board and setting the first empty spot in the collumn to the player's number
        for(int r = 0; r < 6; r++){
            if(board[r][column] == 0){
                board[r][column] = (player1) ? 1 : 2;
                System.out.println(board[r][column]);
                cc.checkChip(r, column);
                r = 6;
            }
        }
        
        //checkBoard(player1);
        if(running) {printBoard();}
    
    }
    
    //checks each chip as it is placed to improve search time
    public static void checkChip(int a, int b){
        int player = board[a][b];
        //first should check a 3*3 location of the chip, if there are any chips of the same type in that area,
        //search in that direction
        
        //checking vertical chip
        //if(board[a + 1])
        
        System.out.println("Checking vertical");
        if(board[a][b] == player){
            int count = recCheckChip(a, b, 1, player);
            System.out.println("Count: " + count);
            if(count == 4){
                System.out.println("Player " + board[a][b] + " Wins!");
                running = false;
            }
        }
        
    }
    
    public static int recCheckChip(int a, int b, int direction, int player) {
        //recieves the position of the checking chip, then searches in that direction
        //Directions: 0 - 2
        //            3 _ 4
        //            5 6 7
        //actually only need to check below chip for vertical
        System.out.println("A:" + a + " B:" + b);
        if(a >= 0 && a < 6 && b >= 0 && b < 7){
            if(board[a][b] == player){
                switch (direction){
                    case 0: return 1 + recCheckChip(a - 1, b - 1, direction, player);
                    case 1: return 1 + recCheckChip(a + 1, b, direction, player); //checking down
                }
            }
        }
            return 0;
    }
    
    //commented out as code is unused
//
//    //Could be improved by only checking the chip that is dropped instead of the entire board
//    public static void checkBoard(boolean player1){
//        int player = player1 ? 1 : 2;
//        //System.out.println("player: " + player);
//        
//        //check vertical chips starting with a (vertical) 0
//        for(int a = 5; a > 2; a--){
//            for(int b = 0; b < 7; b++){
//                if(board[a][b] == player){
//                    System.out.println("checking vertical board position: " + a + " " + b);
//                    checkVertical(a, b, 0, player);
//                }
//            }
//        }
//        
//        //check horizontal chips starting with a (vertical) 0
//        for(int a = 5; a >= 0; a--){
//            for(int b = 0; b < 4; b++){
//                if(board[a][b] == player){
//                    System.out.println("checking horizontal board position: " + a + " " + b);
//                    checkHorizontal(a, b, 0, player);
//                }
//            }
//        }
//    }
//    
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
