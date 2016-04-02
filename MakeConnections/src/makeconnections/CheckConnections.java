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
public class CheckConnections {
    
    private int[][] board = new int[6][7];
    
    public boolean CheckConnections(int[][] oBoard){
        
        //set local board to passed board
        board = oBoard;
        
        return false;
    }
    
    //ensures vertical board position has not reached four chips in a row
    private boolean checkVertical(){
        
        return false;
    }
    
    //ensures horizontal board position has not reached four chips in a row
    private boolean checkHorizontal(){
        return false;
    }
    
    
    
}
