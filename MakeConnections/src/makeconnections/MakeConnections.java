/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makeconnections;
import java.awt.*;
import javax.swing.JComponent;
import javax.swing.*;

/**
 *
 * @author Patrick
 */
public class MakeConnections extends JPanel{

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
    private boolean updateBoard() {
        repaint();
        return true;
    }
    
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.drawOval(5, 5, 10, 10);
        
    }
    
}
