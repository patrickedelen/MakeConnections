/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makeconnections;

/**
 *
 * @author Patrick
 */

//This class will find the value of each move on the game board
public class FindConnections {
    
    public static int[][] values = new int[6][7];
    public static void evaluate(int[][] board){
        //will search through each chip and find all values
        for(int i = 0; i < 7; i ++){
            for(int x = 0; x < 6; x ++) {
                if(board[x][i] != 0){
                    values[x][i] = 2;
                }
            }
        }
    }
}
