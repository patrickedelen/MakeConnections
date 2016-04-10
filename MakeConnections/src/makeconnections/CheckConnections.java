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
    
    private static MakeConnections mc = new MakeConnections();
    
     //checks each chip as it is placed to improve search time
    public static void checkChip(int a, int b){
        System.out.println("Passed location "+a+" "+b + " value: " + mc.board[a][b]);
        int player = mc.board[a][b];
        //first should check a 3*3 location of the chip, if there are any chips of the same type in that area,
        //search in that direction
        
        //checking vertical chip
        //if(board[a + 1])
        
        System.out.println("Checking vertical");
        if(mc.board[a][b] == player){
            int count = recCheckChip(a, b, 1, player);
            System.out.println("Count: " + count);
            if(count == 4){
                mc.running = false;
            }
        }
        /*int ncount = recCheckChipDiag(a - 3, b - 3, true, mc.board[a][b], 0, 0);
        System.out.println("Ncount: " + ncount);
        if(ncount == 4){
            mc.running = false;
        }*/
        
        //diagonal right
        int drCount = 0;
        int mA = a - 3;
        int mB = b - 3;
        for(int i = 0; i < 8; i ++){
            //System.out.println("Possible location " + mA + " " + mB);
            if(mA >= 0 && mB >= 0 && mA < 6 && mB < 7){
                //System.out.println("Checking location " + mA + " " + mB);
                if(mc.board[mA][mB] == player){
                    drCount++;
                    if(drCount == 4){
                        playerWin(player);
                        break;
                    }
                    //System.out.println("Found match at " + mA + " " + mB);
                } else if(mc.board[mA][mB] != 0) {
                    drCount = 0;
                }
            }
            mA++;
            mB++;
        }
        System.out.println("Diag Right Count: " + drCount);
        
        //diagonal left
        int dlCount = 0;
        int lA = a - 3;
        int lB = b + 3;
        for(int i = 0; i < 8; i ++){
            //System.out.println("Possible location " + mA + " " + mB);
            if(lA >= 0 && lB >= 0 && lA < 6 && lB < 7){
                //System.out.println("Checking location " + mA + " " + mB);
                if(mc.board[lA][lB] == player){
                    dlCount++;
                    if(dlCount == 4){
                        playerWin(player);
                        break;
                    }
                    //System.out.println("Found match at " + mA + " " + mB);
                } else if(mc.board[lA][lB] != 0) {
                    dlCount = 0;
                }
            }
            lA++;
            lB--;
        }
        System.out.println("Diag Left Count: " + dlCount);
        
        //horizontal count
        int hCount = 0;
        int hB = b - 3;
        for(int i = 0; i < 8; i ++){
            if(hB >= 0 && hB < 7){
                if(mc.board[a][hB] == player){
                    hCount++;
                    if(hCount == 4){
                        playerWin(player);
                        break;
                    }
                } else if(mc.board[a][hB] != player){
                    hCount = 0;
                }
            }
            hB++;
        }
        System.out.println("HorzCount " + hCount);
    }
    
    public static int recCheckChip(int a, int b, int direction, int player) {
        //recieves the position of the checking chip, then searches in that direction
        //Directions: - - -
        //            3 _ 3
        //            0 1 2
        //
        //0 - Diag to upper right
        //1 - Down
        //2 - Diag to upper left
        //3 - check left and right
        //
        //actually only need to check below chip for vertical
        System.out.println("A:" + a + " B:" + b);
        if(a >= 0 && a < 6 && b >= 0 && b < 7){
            if(mc.board[a][b] == player){
                switch (direction){
                    case 0: return 1 + recCheckChip(a - 1, b - 1, direction, player);
                    case 1: return 1 + recCheckChip(a - 1, b, direction, player); //checking down
                }
            }
        }
            return 0;
    }
    
    public static int recCheckChipRight(int a, int b, int player, int count, int checks) {
        
        if(count == 4 || checks > 8){
            return count;
        } else if(a < 0 || b < 0){
            recCheckChipRight(a + 1, b + 1, player, 0, checks + 1);
        } else if(a > 5 || b > 6){
            return count;
        } else {
            if(mc.board[a][b] == player){
                recCheckChipRight(a + 1, b + 1, player, count + 1, checks + 1);
            } else {
                recCheckChipRight(a + 1, b + 1, player, 0, checks + 1);
            }
        }
        
        return checks;
    }
    
    //Checks the diagonal chips to the left and right
    //and is recurslve
    public static int recCheckChipDiag(int a, int b, boolean isRight, int player, int count, int checks) {
       
        if(count == 4 || checks > 8) {
            return count;
        } else if(a < 0){
        //checking to make sure all are in bounds
            if(isRight){
                recCheckChipDiag(a + 1, b + 1, isRight, player, 0, checks + 1);
            } else {
                recCheckChipDiag(a + 1, b - 1, isRight, player, 0, checks + 1);
            }
        } else if(a > 5) {
            return count;
        } else if(b < 0) {
            if(isRight) {
                return recCheckChipDiag(a + 1, b + 1, isRight, player, 0, checks + 1);
            } else {
                return count;
            }
        } else if(b > 6) {
            if(isRight) {
                return 0;
            } else {
                return recCheckChipDiag(a + 1, b - 1, isRight, player, 0, checks + 1);
            }
        } else {
            if(mc.board[a][b] == player){
                if(isRight){
                    System.out.println("Fount Right Diag");
                    return recCheckChipDiag(a + 1, b + 1, isRight, player, count + 1, checks + 1);
                } else {
                    System.out.println("Found Left Diag");
                    return recCheckChipDiag(a + 1, b - 1, isRight, player, count + 1, checks + 1);
                }
            } else {
                if(isRight){
                    return recCheckChipDiag(a + 1, b + 1, isRight, player, 0, checks + 1);
                } else {
                    return recCheckChipDiag(a + 1, b - 1, isRight, player, 0, checks + 1);
                }
            }
        }
        
        return count;
    }
    
    //ensures vertical board position has not reached four chips in a row
    private boolean checkVertical(){
        
        return false;
    }
    
    //ensures horizontal board position has not reached four chips in a row
    private boolean checkHorizontal(){
        return false;
    }
    
    //simple method to print out which player won and the final game board
    private static void playerWin(int player){
        mc.printBoard();
        System.out.println("Player " + player + " Wins!");
        mc.running = false;
    }
    
    
    
}
