/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makeconnections;
import java.awt.*;
import javax.swing.JComponent;

/**
 *
 * @author Patrick
 */
public class MakeConnections {

    /**
     * @param args the command line arguments
     */
    
    public FindConnections fc = new FindConnections();
    
    public static void main(String[] args) {
        //initiate the frame and draw the game board
        
        drawBoard();
    }
    
    public static void drawBoard(){
        //create the canvas
        Canvas canv1 = new Canvas();
        canv1.setSize(800,800);
        canv1.setBackground(Color.red);
        
        Frame frame1 = new Frame();
        frame1.add(canv1);
        frame1.setLayout(new FlowLayout());
        frame1.setSize(800,800);
        frame1.setVisible(true);
        
        //set the mouse to the game board
        //requestFocus();
    }
    
    public void paint(Graphics g){
        
    }
    
}
