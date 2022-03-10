import java.util.Scanner;

public class TicTacToeTester
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        TicTacToe game = new TicTacToe();
        
        while (true) {
            boolean isSpaceValid = false;
            int row = 0;
            int col = 0;
            
            while (!isSpaceValid) {
                System.out.println("Enter a valid square for the next turn (0-8):");
                int space = scanner.nextInt();
                if (space >= 0 && space < 9) { 
                    isSpaceValid = true;
                    row = space / 3;
                    col = space % 3;
                    if (!game.pickLocation(row, col)) {
                        isSpaceValid = false;
                        System.out.println("That space is already taken.");
                    }
                }
            }
            
            game.takeTurn(row, col);
            game.printBoard();
            
            if (game.checkWin()) {
                System.out.println("There is a winner!");
                return;
            } else if (game.isBoardFull()) {
                System.out.println("The game is a draw!");
                return;
            }
            
        }
    }
}