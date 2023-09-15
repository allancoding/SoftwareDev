package Course_2.Exercise_08;
import java.util.Scanner;

public class Exercise_08_9 {
    private static final int BOARD_SIZE = 3;
    private static final String EMPTY_CELL = " ";
    private static final String PLAYER_X = "X";
    private static final String PLAYER_O = "O";

    private String[][] board;
    private String currentPlayer;

    public Exercise_08_9() {
        board = new String[BOARD_SIZE][BOARD_SIZE];
        currentPlayer = PLAYER_X;

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = EMPTY_CELL;
            }
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printBoard();
            System.out.println("Enter a row (0, 1, or 2) for player " + currentPlayer + ": ");
            int row = scanner.nextInt();
            System.out.println("Enter a column (0, 1, or 2) for player " + currentPlayer + ": ");
            int col = scanner.nextInt();

            if (isValidMove(row, col)) {
                makeMove(row, col);
                if (isBoardFull()) {
                    System.out.println("Game Over. Someone probably won or it is a cat!");
                    break;
                }
                switchPlayer();
            } else {
                System.out.println("Invalid move. Please try again.");
            }
            System.out.println();
        }
        scanner.close();
    }

    private boolean isValidMove(int row, int col) {
        // Check if the cell is within the board and not occupied
        return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE && board[row][col].equals(EMPTY_CELL);
    }

    private void makeMove(int row, int col) {
        board[row][col] = currentPlayer;
    }

    private void switchPlayer() {
        currentPlayer = currentPlayer.equals(PLAYER_X) ? PLAYER_O : PLAYER_X;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j].equals(EMPTY_CELL)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if(i == 0) {
                System.out.println("-------------");
            }
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (j == 0) {
                    System.out.print("| ");
                }else{
                    System.out.print(" | ");
                }
                System.out.print(board[i][j]);
                if (j == (BOARD_SIZE - 1)) {
                    System.out.print(" |");
                }
            }
            System.out.println();
            if (i < BOARD_SIZE) {
                System.out.println("-------------");
            }
        }
    }

    public static void main(String[] args) {
        Exercise_08_9 game = new Exercise_08_9();
        game.play();
    }
}
