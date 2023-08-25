package Intro_Final_Project;

public class Final_Project {
    private static final int BOARD_SIZE = 11;
    private int[] pA = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] pB = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] pC = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] pD = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] pE = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] pF = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] pG = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] pH = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] pI = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] pJ = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[][] human = {pA, pB, pC, pD, pE, pF, pG, pH, pI, pJ};
    private boolean allhumanshipsplaced = false;
    private int[] cA = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] cB = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] cC = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] cD = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] cE = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] cF = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] cG = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] cH = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] cI = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] cJ = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[][] cpu = {cA, cB, cC, cD, cE, cF, cG, cH, cI, cJ};
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
    private char ship = 0x2588;
    private char shipbox = 0x25A0;
    private char hit = 0x2593;
    private char sunk = 0x2591;
    private char miss = 0x2248;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    private boolean continuePlacement = true;
    private int gamelevel = 0;

    public Final_Project() {
        printInstructions();
        level();
        cpurandomships();
        humansetships(5, "");
        printBoard("cpu"); 
        //testprintarray();
    }

    public void testprintarray(){
        for (int i = 0; i < cpu.length; i++) {
            for (int j = 0; j < cpu[i].length; j++) {
                System.out.print(cpu[i][j]);
            }
            System.out.println();
        }
    }

    public void clear(){
        System.out.print("\033[H\033[2J");
    }

    public void printInstructions(){
        clear();
        System.out.println(ANSI_BLACK+ANSI_CYAN_BACKGROUND+"Welcome to Battleship!"+ANSI_RESET+" ");
        printBoardLine(22, 3);
        System.out.println(ANSI_PURPLE_BACKGROUND+ANSI_BLACK+"Instructions:"+ANSI_RESET+" ");
        printBoardLine(11, 3);
        System.out.print(ANSI_WHITE);
        System.out.println("- The game is played on a 10x10 board.");
        System.out.println("- The goal of the game is to sink all of the enemy ships before they sink yours.");
        System.out.println("- You will choose where it put your ships with the starting coordinate and the direction you want it to go.");
        System.out.println("- You will have 5 ships to place on the board. They are 1x5, 1x4, 1x3, 1x3, and 1x2.");
        System.out.println("- You will play against a 10x10 board with 5 randomly placed ships on it.");
        System.out.println("  ^ You will play against the computer & it is not AI :( - I didn't have enough time, lol");
        System.out.println("- You will take turns guessing where the enemy ships are by entering the coordinate you want to hit.");
        System.out.println("- If you hit a ship, it will be marked with a "+hit+".");
        System.out.println("- If you sink a ship, it will be marked with a "+sunk+".");
        System.out.println("- If you miss a ship, it will be marked with a "+miss+".");
        System.out.println("- Same goes for the computer. If they hit your ship, it will be marked with a "+hit+", etc...");
        System.out.println("- A ships will be colors depending on what ship it is.");
        System.out.println("- The Aircraft Carrier will be "+ANSI_PURPLE+"purple"+ANSI_WHITE+". "+ANSI_PURPLE+shipbox+" "+shipbox+" "+shipbox+" "+shipbox+" "+shipbox+" "+ANSI_WHITE+" ");
        System.out.println("- The Battleship will be "+ANSI_CYAN+"cyan"+ANSI_WHITE+". "+ANSI_CYAN+shipbox+" "+shipbox+" "+shipbox+" "+shipbox+" "+ANSI_WHITE+" ");
        System.out.println("- The Cruiser will be "+ANSI_YELLOW+"yellow"+ANSI_WHITE+". "+ANSI_YELLOW+shipbox+" "+shipbox+" "+shipbox+" "+ANSI_WHITE+" ");
        System.out.println("- The Submarine will be "+ANSI_GREEN+"green"+ANSI_WHITE+". "+ANSI_GREEN+shipbox+" "+shipbox+" "+shipbox+" "+ANSI_WHITE+" ");
        System.out.println("- The Destroyer will be "+ANSI_RED+"red"+ANSI_WHITE+". "+ANSI_RED+shipbox+" "+shipbox+" "+ANSI_WHITE+" ");
        System.out.println("- If you hit all of the ships before the computer hits yours, you win!");
        printBoardLine(11, 3);
        System.out.println(ANSI_GREEN_BACKGROUND+ANSI_BLACK+"Good luck!"+ANSI_RESET+" ");
        System.out.println(ANSI_YELLOW_BACKGROUND+ANSI_BLACK+"Press enter to continue..."+ANSI_RESET+" ");
        try{System.in.read();}
        catch(Exception e){}
    }

    public void level(){
        clear();
        System.out.println(ANSI_BLACK+ANSI_CYAN_BACKGROUND+"Choose a level:"+ANSI_RESET+" ");
        printBoardLine(22, 3);
        System.out.println(ANSI_PURPLE_BACKGROUND+ANSI_BLACK+"1. Easy"+ANSI_RESET+" ");
        System.out.println(ANSI_CYAN_BACKGROUND+ANSI_BLACK+"2. Medium"+ANSI_RESET+" ");
        System.out.println(ANSI_YELLOW_BACKGROUND+ANSI_BLACK+"3. Hard"+ANSI_RESET+" ");
        System.out.println(ANSI_RED_BACKGROUND+ANSI_BLACK+"4. Impossible"+ANSI_RESET+" ");
        printBoardLine(11, 3);
        int start = Integer.parseInt(System.console().readLine());
        System.out.println(ANSI_YELLOW_BACKGROUND+ANSI_BLACK+"Press enter to continue..."+ANSI_RESET+" ");
        try{System.in.read();}
        catch(Exception e){}
    }

    public void printerror(String error){
        if(error != ""){
            System.out.println(ANSI_RED_BACKGROUND+ANSI_BLACK+error+ANSI_RESET+" ");
        }
    }

    public void humansetships(int type, String error){
        if(!allhumanshipsplaced){
            String start = "";
            String dir = "";
            printBoard("human");
            printerror(error);
            if (type == 9) {
                continuePlacement = false;
            }
            if (continuePlacement) {
                if(type == 5){
                    System.out.println(ANSI_PURPLE_BACKGROUND+ANSI_BLACK+"Aircraft Carrier"+ANSI_RESET+" ");
                    System.out.println("Enter the starting coordinate of the ship (ex. A1):");
                    start = System.console().readLine();
                    System.out.println("Enter the direction of the ship (ex. up, down, left, right):");
                    dir = System.console().readLine();
                    setships(start, dir, 5, type);
                    printBoard("human");
                    humansetships(6, "");
                }else if(type == 6){
                    System.out.println(ANSI_CYAN_BACKGROUND+ANSI_BLACK+"Battleship"+ANSI_RESET+" ");
                    System.out.println("Enter the starting coordinate of the ship (ex. A1):");
                    start = System.console().readLine();
                    System.out.println("Enter the direction of the ship (ex. up, down, left, right):");
                    dir = System.console().readLine();
                    setships(start, dir, 4, type);
                    printBoard("human");
                    humansetships(7, "");
                }else if(type == 7){
                    System.out.println(ANSI_YELLOW_BACKGROUND+ANSI_BLACK+"Cruiser"+ANSI_RESET+" ");
                    System.out.println("Enter the starting coordinate of the ship (ex. A1):");
                    start = System.console().readLine();
                    System.out.println("Enter the direction of the ship (ex. up, down, left, right):");
                    dir = System.console().readLine();
                    setships(start, dir, 3, type);
                    printBoard("human");
                    humansetships(8, "");
                }else if(type == 8){
                    System.out.println(ANSI_GREEN_BACKGROUND+ANSI_BLACK+"Submarine"+ANSI_RESET+" ");
                    System.out.println("Enter the starting coordinate of the ship (ex. A1):");
                    start = System.console().readLine();
                    System.out.println("Enter the direction of the ship (ex. up, down, left, right):");
                    dir = System.console().readLine();
                    setships(start, dir, 3, type);
                    printBoard("human");
                    humansetships(9, "");
                }
            }

            if(type == 9){
                System.out.println(ANSI_RED_BACKGROUND+ANSI_BLACK+"Destroyer"+ANSI_RESET+" ");
                System.out.println("Enter the starting coordinate of the ship (ex. A1):");
                start = System.console().readLine();
                System.out.println("Enter the direction of the ship (ex. up, down, left, right):");
                dir = System.console().readLine();
                setships(start, dir, 2, type);
                printBoard("human");
                allhumanshipsplaced = true;
            }
        }
    }

    public void setships(String start, String dirr, int length, int type){
        if(!allhumanshipsplaced){
            if (!(start.length() == 2 || (start.length() == 3 && start.substring(1, 3).equals("10")))){
                humansetships(type,"Coordinate does not exist. Try again.");
                return;
            }
            if (!dirr.equalsIgnoreCase("up") && !dirr.equalsIgnoreCase("down") &&
            !dirr.equalsIgnoreCase("left") && !dirr.equalsIgnoreCase("right")) {
                humansetships(type,"Invalid Direction. Try again.");
                return;
            }
            dirr = dirr.toLowerCase();
            String colPart = start.substring(0, 1).toUpperCase();
            int row = 0;
            int col = 0;
            try {
                row = Integer.parseInt(start.substring(1));
            } catch (NumberFormatException e) {
                humansetships(type, "Invalid Number Coordinate. Try again.");
                return;
            }
            boolean validColChar = false;
            for (int i = 0; i < letters.length; i++) {
                if (letters[i].equals(colPart)) {
                    col = i;
                    validColChar = true;
                    break;
                }
            }
            if (!validColChar) {
                humansetships(type, "Invalid Letter Coordinate. Try again.");
                return;
            }
            if (row < 1 || row > 10) {
                humansetships(type, "Invalid Coordinate. Try again.");
                return;
            }
            row -= 1;
            int dir = 0;
            if (dirr.equals("up")){
                dir = 0;
            }else if (dirr.equals("down")){
                dir = 2;
            }else if (dirr.equals("left")){
                dir = 3;
            }else if (dirr.equals("right")){
                dir = 1;
            }
            boolean placed = false;
            while (!placed) {
                boolean canPlace = true;
                for (int j = 0; j < length; j++) {
                    int newRow = row, newCol = col;
                    if (dir == 0) newRow -= j;
                    else if (dir == 1) newCol += j;
                    else if (dir == 2) newRow += j;
                    else if (dir == 3) newCol -= j;
                    if (newRow < 0 || newRow >= 10 || newCol < 0 || newCol >= 10 || human[newRow][newCol] != 0) {
                        canPlace = false;
                        break;
                    }
                }
                if (canPlace) {
                    for (int j = 0; j < length; j++) {
                        int newRow = row, newCol = col;
                        if (dir == 0) newRow -= j;
                        else if (dir == 1) newCol += j;
                        else if (dir == 2) newRow += j;
                        else if (dir == 3) newCol -= j;
                        human[newRow][newCol] =  type;
                    }
                    placed = true;
                }else{
                    humansetships(type, "Invalid Placement. Try again.");
                    return;
                }
            }
        }
    }

    public void cpurandomships() {
        int[] ships = {5, 4, 3, 3, 2};
        for (int i = 0; i < ships.length; i++) {
            boolean placed = false;
            while (!placed) {
                int row = (int)(Math.random() * 10);
                int col = (int)(Math.random() * 10);
                int dir = (int)(Math.random() * 4);
                boolean canPlace = true;
                for (int j = 0; j < ships[i]; j++) {
                    int newRow = row, newCol = col;
                    if (dir == 0) newRow -= j;
                    else if (dir == 1) newCol += j;
                    else if (dir == 2) newRow += j;
                    else if (dir == 3) newCol -= j;
                    if (newRow < 0 || newRow >= 10 || newCol < 0 || newCol >= 10 || cpu[newRow][newCol] != 0) {
                        canPlace = false;
                        break;
                    }
                }
                if (canPlace) {
                    for (int j = 0; j < ships[i]; j++) {
                        int newRow = row, newCol = col;
                        if (dir == 0) newRow -= j;
                        else if (dir == 1) newCol += j;
                        else if (dir == 2) newRow += j;
                        else if (dir == 3) newCol -= j;
                        cpu[newRow][newCol] = i + 5;
                    }
                    placed = true;
                }
            }
        }
    }    

    public void printBoardLine(int n, int type) {
        System.out.print(ANSI_BLACK);
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
            }else if(type == 3){
                System.out.print(ANSI_WHITE);
                if(i == (n - 1)) {
                    System.out.println(emDash+""+emDash);
                }else{
                    System.out.print(emDash+""+emDash);
                }
            }
        }
    }
    
    private void printData(int row, int col, String player){
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
            printChar(row, col, player);
        }
    }

    private void printChar(int row, int col, String player){
        int[][] arrays;
        if(player == "human") {
            arrays = human;
        }else{
            arrays = cpu;
        }
        if(arrays[row - 1][col - 1] == 0){
            System.out.print(" "); //empty
        }else if(arrays[row - 1][col - 1] == 1){
            System.out.print(ANSI_BLACK+ship); //ship
        }else if(arrays[row - 1][col - 1] == 2){
            System.out.print(hit); //hit
        }else if(arrays[row - 1][col - 1] == 3){
            System.out.print(sunk); //sunk
        }else if(arrays[row - 1][col - 1] == 4){
            System.out.print(miss); //miss
        }else if(arrays[row - 1][col - 1] == 5){
            System.out.print(ANSI_PURPLE+ship); //aircraft carrier
        }else if(arrays[row - 1][col - 1] == 6){
            System.out.print(ANSI_CYAN+ship); //battleship
        }else if(arrays[row - 1][col - 1] == 7){
            System.out.print(ANSI_YELLOW+ship); //cruiser
        }else if(arrays[row - 1][col - 1] == 8){
            System.out.print(ANSI_GREEN+ship); //submarine
        }else if(arrays[row - 1][col - 1] == 9){
            System.out.print(ANSI_RED+ship); //destroyer
        }else if(arrays[row - 1][col - 1] == 10){
            System.out.print(ANSI_PURPLE+hit); //aircraft carrier hit
        }else if(arrays[row - 1][col - 1] == 11){
            System.out.print(ANSI_CYAN+hit); //battleship hit
        }else if(arrays[row - 1][col - 1] == 12){
            System.out.print(ANSI_YELLOW+hit); //cruiser hit
        }else if(arrays[row - 1][col - 1] == 13){
            System.out.print(ANSI_GREEN+hit); //submarine hit
        }else if(arrays[row - 1][col - 1] == 14){
            System.out.print(ANSI_RED+hit); //destroyer hit
        }else if(arrays[row - 1][col - 1] == 15){
            System.out.print(ANSI_PURPLE+sunk); //aircraft carrier sunk
        }else if(arrays[row - 1][col - 1] == 16){
            System.out.print(ANSI_CYAN+sunk); //battleship sunk
        }else if(arrays[row - 1][col - 1] == 17){
            System.out.print(ANSI_YELLOW+sunk); //cruiser sunk
        }else if(arrays[row - 1][col - 1] == 18){
            System.out.print(ANSI_GREEN+sunk); //submarine sunk
        }else if(arrays[row - 1][col - 1] == 19){
            System.out.print(ANSI_RED+sunk); //destroyer sunk
        }
        System.out.print(ANSI_BLACK);
    }

    private void printBoard(String player) {
        clear();
        if(player == "human") {
            System.out.println(ANSI_GREEN+"Your Board:"+ANSI_RESET);
        }else if (player == "cpu"){
            System.out.println(ANSI_RED+"Computer's Board:"+ANSI_RESET);
        }
        System.out.print(ANSI_BLUE_BACKGROUND);
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
                printData(i, j, player);
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
         System.out.print(ANSI_RESET);
    }
    public static void main(String[] args) {
        new Final_Project();
    }
}
