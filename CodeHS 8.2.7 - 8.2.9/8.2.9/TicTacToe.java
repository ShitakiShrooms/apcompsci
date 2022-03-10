public class TicTacToe
{
   //copy over your constructor from the Tic Tac Toe Board activity in the previous lesson!
   private int turn;
   private String[][] board;
    
    public TicTacToe() {
        board = new String[][] {
            { "-", "-", "-" },
            { "-", "-", "-" },
            { "-", "-", "-" }
        };
    }
   
   //this method returns the current turn
   public int getTurn()
   {
       return turn;
   }
   
   public boolean isBoardFull() {
       for (int row = 0; row < 3; row++) {
           for (int col = 0; col < 3; col++) {
               if (pickLocation(row, col)) return false;
           }
       }
       return true;
   }
   
   /*This method prints out the board array on to the console
   */
   public void printBoard()
   {
       System.out.println(" 0 1 2");
       System.out.println("0 " + board[0][0] + " " + board[0][1] + " " + board[0][2]);
       System.out.println("1 " + board[1][0] + " " + board[1][1] + " " + board[1][2]);
       System.out.println("2 " + board[2][0] + " " + board[2][1] + " " + board[2][2]);
   }
   
   //This method returns true if space row, col is a valid space
   public boolean pickLocation(int row, int col)
   {
       if (row < 0 || row >= 3) return false;
       if (col < 0 || col >= 3) return false;
       
       return board[row][col].equals("-");
   }
   
   //This method places an X or O at location row,col based on the int turn
   public void takeTurn(int row, int col)
   {
       board[row][col] = turn++ % 2 == 0 ? "X" : "O";
   }
   
   //This method returns a boolean that returns true if a row has three X or O's in a row
   public boolean checkRow()
   {
       for (int i = 0; i < 3; i++) {
           if (pickLocation(i, 0)) continue;
           
           if (board[i][0].equals(board[i][1]) && 
                board[i][0].equals(board[i][2])) {
               return true;
           }
       }
       return false;
   }
   
    //This method returns a boolean that returns true if a col has three X or O's
   public boolean checkCol()
   {
       for (int i = 0; i < 3; i++) {
           if (pickLocation(0, i)) continue;
           
           if (board[0][i].equals(board[1][i]) && 
                board[0][i].equals(board[2][i])) {
                return true;
            }
       }
       return false;
   }
   
    //This method returns a boolean that returns true if either diagonal has three X or O's
   public boolean checkDiag()
   {
       if (!pickLocation(0, 0)) {
           if (board[0][0].equals(board[1][1]) &&
               board[0][0].equals(board[2][2])) {
               return true;
           }
       } else if (!pickLocation(2, 0)) {
           if (board[2][0].equals(board[1][1]) &&
               board[2][0].equals(board[0][2])) {
               return true;
           }
       }
       return false;
   }
   
   //This method returns a boolean that checks if someone has won the game
   public boolean checkWin()
   {
       return checkDiag() || checkCol() || checkRow();
   }

}