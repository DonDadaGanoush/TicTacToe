import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
            System.out.println("\nLet's play tic tac toe\n");

            // Creates a 2D array to initalize the board 
            char[][] board = {
              {'_','_','_'},
              {'_','_','_'},
              {'_','_','_'}
            };

            // Calls print board function (prints empty board initially)
            printBoard(board); 

            // Creates a for loop to initiate a maximum of 8 alternating turns
              for(int i = 0; i < 9; i++) { 
                // distinguish turns using odd/even concept
                if (i % 2 == 0) { 
                  char turn = 'X';
                  System.out.println("Turn: " + turn);
                  // calls askUser function 
                  int[] spot = askUser(board); 
                  // overwrites board spot with user input 
                  board[spot[0]][spot[1]] = turn; 
                  System.out.print("\n");
                } else { 
                  char turn = 'O'; 
                  System.out.println("Turn: " + turn); 
                  int[] spot = askUser(board); 
                  board[spot[0]][spot[1]] = turn; 
                  System.out.print("\n");
                }
                // reprints board after input has been collected
                printBoard(board);

                // checks for win 
                int count = checkWin(board); 

                if (count ==  3) { 
                  System.out.println("X wins!");
                  break;
                } else if (count == -3) { 
                  System.out.println("O wins!");
                  break; 
                } else if (i == 8) { 
                  System.out.println("It's a tie!");
                }
              }
              
              scan.close();
    }
    /** 
     * Function name - printBoard()
     * @param board (char[][])
     * 
     * Prints each element in each row with formatting
     */        
    public static void printBoard(char[][] board) {
      for (int i = 0; i < board.length; i++) { 
        System.out.print("\t");
        for (int j = 0; j < board[i].length; j++) { 
          System.out.print(board[i][j] + " ");
        }
        System.out.print("\n\n");
      }
    } 


   /** 
     * Function name – askUser
     * @param board (char[][] board)
     * @return spot (int[])
     * 
     * Prompts user to pick a row and column number to place mark 
     * Initiates a while loop to check if spot is take,
     * and prompts user to input another 
     */
    public static int[] askUser(char[][] board) { 
      System.out.print("\t- pick a row and column number: ");
      int row = scan.nextInt(); 
      int element = scan.nextInt(); 
      while (board[row][element] != '_') { 
        System.out.print("Spot taken, pick another spot: ");
        row = scan.nextInt(); 
        element = scan.nextInt(); 
      }
      return new int[] {row, element}; 
    }

    /**
     * Function name - checkWin 
     * @param board (char[][])
     * @return count (int)
     * 
     * Function checks which user wins the game
     * First for loop checks for win in every row 
     * Second for loop checks for win in every column 
     * Third for loop checks for win in left diagonal 
     * Fourth for loop checks for win in right diagonal
     */
    public static int checkWin(char[][] board) { 
      // count variable is initialized, if count equals 3 or -3, each respective user will win 
      int count = 0; 

      // First for loop, traverse each row
      for (int i = 0; i < board.length; i++) { 
        for (int j = 0; j < board[i].length; j++) {
          if (board[i][j] == 'X') { 
            count++;
          } else if (board[i][j] == 'O') {
            count--; 
          }
        }
        if (count == 3 || count == -3) { 
          return count;
        } else { 
          count = 0; // resets count if conditions aren't met
        }
      }

      // Second for loop, traverses each column
      for (int i = 0; i < 3; i++) { 
        for (int j = 0; j < board.length; j++) {
          if (board[j][i] == 'X') { 
            count++;
          } else if (board[j][i] == 'O') {
            count--; 
          }
        }
        if (count == 3 || count == -3) { 
          return count;
        } else { 
          count = 0; 
        }
      }
      
      // Third for loop, traverses each element in diagonal
      for (int i = 0; i < 3; i++) { 
        if (board[i][i] == 'X') { 
          count++;
        } else if (board[i][i] == 'O') { 
          count--; 
        }
      }
      if (count == 3 || count == -3) {
        return count;
      } else {
        count = 0; 
      }


      // Fourth for loop, traverses each element in diagonal
      for (int i = 0; i < 3; i++) { 
        int rowIndex = 2 - i; // indexes i from the index 2 instead of 0
        if (board[rowIndex][i] == 'X') { 
          count++;
        } else if (board[rowIndex][i] == 'O') { 
          count--; 
        }
      }
      if (count == 3 || count == -3) {
        return count;
      } else {
        count = 0; 
      }
      return count; 
    }
    
}
