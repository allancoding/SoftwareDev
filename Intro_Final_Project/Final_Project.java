package Intro_Final_Project;

public class Final_Project {
    private static final int BOARD_SIZE = 11;
    private static final String EMPTY_CELL = " ";
    private int[] A = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] B = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] C = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] D = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] E = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] F = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] G = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] H = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] I = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] J = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    private char emDash = 0x2500;
    private char topCornerLeft = 0x250C;
    private char topCornerRight = 0x2510;
    private char bottomCornerLeft = 0x2514;
    private char bottomCornerRight = 0x2518;
    private char side = 0x2502;
    private char topT = 0x252C;
    private char bottomT = 0x2534;
    private char leftT = 0x251C;
    private char rightT = 0x2524;
    private char cross = 0x253C;

    public Final_Project() {
       printBoard();
    }

    public void printBoardLine(int n, int type) {
       for (int i = 0; i < n; i++) {
            if(type == 0){
                if(i == 0) {
                    System.out.print(topCornerLeft+""+emDash+""+emDash);
                }
                if(i == (n - 1)) {
                    System.out.println(emDash+""+emDash+""+topCornerRight);
                }else{
                    System.out.print(emDash+""+emDash+""+topT+""+emDash);
                }
            }else if(type == 1){
                if(i == 0) {
                    System.out.print(leftT+""+emDash+""+emDash);
                }
                if(i == (n - 1)) {
                    System.out.println(emDash+""+emDash+""+rightT);
                }else{
                    System.out.print(emDash+""+emDash+""+cross+""+emDash);
                }
            }else if(type == 2){
                if(i == 0) {
                    System.out.print(bottomCornerLeft+""+emDash+""+emDash);
                }
                if(i == (n - 1)) {
                    System.out.println(emDash+""+emDash+""+bottomCornerRight);
                }else{
                    System.out.print(emDash+""+emDash+""+bottomT+""+emDash);
                }
            }
       }
    }
    
    private void printData(int row, int col){
        if(row == 0){
            if(col == 0) {
                System.out.print("  ");
            }else{
                System.out.print(letters[col - 1]);
            }
        }else if (col == 0) {
            if(row == 0) {
                System.out.print(" ");
            }else if (row == 10){
                System.out.print(row);
            }else{
                System.out.print(" "+row);
            }
        }else{
            printChar(row, col);
        }
    }

    private void printChar(int row, int col){
        if(row == 1){
            if(A[col - 1] == 0){
                System.out.print(" ");
            }
        }else{
            System.out.print(" ");
        }
    }

    private void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if(i == 0) {
                printBoardLine(11, 0);
            }
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (j == 0) {
                    System.out.print(side+" ");
                }else{
                    System.out.print(" "+side+" ");
                }
                printData(i, j);
                if (j == (BOARD_SIZE - 1)) {
                    System.out.print(" "+side);
                }
            }
            System.out.println();
            if(i == (BOARD_SIZE - 1)) {
                printBoardLine(11, 2);
            }else if (i < BOARD_SIZE) {
                printBoardLine(11, 1);
            }
        }
    }
    public static void main(String[] args) {
        Final_Project game = new Final_Project();
    }
}
