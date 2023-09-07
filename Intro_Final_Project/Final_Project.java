package Intro_Final_Project;

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

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
    private char sunk = 0x2592;
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
    private int gamelevel = 1;
    private boolean gamestart = false;
    private boolean allhumanshipshavebeensunk = false;
    private boolean allcpushipshavebeensunk = false;

    public Final_Project(boolean instructions) {
        if(instructions == true){
            printInstructions();
        }
        level("");
        cpurandomships();
        humansetships(5, "");
        //testprintarray();
        while (!allhumanshipshavebeensunk && !allcpushipshavebeensunk) {
            if(!allhumanshipshavebeensunk && !allcpushipshavebeensunk){
                humanhit("");
            }
            if(!allhumanshipshavebeensunk && !allcpushipshavebeensunk){
                cpuhit();
            }
        }
        endgame();
    }

    public void testprintarray(){
        File file = new File(System.getProperty("user.dir"),"Intro_Final_Project/cheat.txt");
        if (file.exists()) {
            try {
                PrintWriter writer = new PrintWriter(file);
                for (int i = 0; i < cpu.length; i++) {
                    for (int j = 0; j < cpu[i].length; j++) {
                        writer.print(cpu[i][j]+" ");
                    }
                    writer.println();
                }
                writer.close();
            } catch (FileNotFoundException fnfe){
                println(fnfe+"");
            }
        }
    }

    public void clear(){
        print("\033[H\033[2J");
    }

    public void printInstructions(){
        clear();
        println(ANSI_BLACK+ANSI_CYAN_BACKGROUND+"Welcome to Battleship!"+ANSI_RESET+" ");
        printBoardLine(22, 3);
        println(ANSI_PURPLE_BACKGROUND+ANSI_BLACK+"Instructions:"+ANSI_RESET+" ");
        printBoardLine(11, 3);
        print(ANSI_WHITE);
        println("- The game is played on a 10x10 board.");
        println("- The goal of the game is to sink all of the enemy ships before they sink yours.");
        println("- You will choose where it put your ships with the starting coordinate and the direction you want it to go.");
        println("- You will have 5 ships to place on the board. They are 1x5, 1x4, 1x3, 1x3, and 1x2.");
        println("- You will play against a 10x10 board with 5 randomly placed ships on it.");
        println("  ^ You will play against the computer & it is not AI :( - I didn't have enough time, lol");
        println("- You will take turns guessing where the enemy ships are by entering the coordinate you want to hit.");
        println("- If you hit a ship, it will be marked with a "+hit+".");
        println("- If you sink a ship, it will be marked with a "+sunk+".");
        println("- If you miss a ship, it will be marked with a "+miss+".");
        println("- Same goes for the computer. If they hit your ship, it will be marked with a "+hit+", etc...");
        println("- A ships will be colors depending on what ship it is.");
        println("- The Aircraft Carrier will be "+ANSI_PURPLE+"purple"+ANSI_WHITE+". "+ANSI_PURPLE+shipbox+" "+shipbox+" "+shipbox+" "+shipbox+" "+shipbox+" "+ANSI_WHITE+" ");
        println("- The Battleship will be "+ANSI_CYAN+"cyan"+ANSI_WHITE+". "+ANSI_CYAN+shipbox+" "+shipbox+" "+shipbox+" "+shipbox+" "+ANSI_WHITE+" ");
        println("- The Cruiser will be "+ANSI_YELLOW+"yellow"+ANSI_WHITE+". "+ANSI_YELLOW+shipbox+" "+shipbox+" "+shipbox+" "+ANSI_WHITE+" ");
        println("- The Submarine will be "+ANSI_GREEN+"green"+ANSI_WHITE+". "+ANSI_GREEN+shipbox+" "+shipbox+" "+shipbox+" "+ANSI_WHITE+" ");
        println("- The Destroyer will be "+ANSI_RED+"red"+ANSI_WHITE+". "+ANSI_RED+shipbox+" "+shipbox+" "+ANSI_WHITE+" ");
        println("- If you hit all of the ships before the computer hits yours, you win!");
        printBoardLine(11, 3);
        println(ANSI_GREEN_BACKGROUND+ANSI_BLACK+"Good luck!"+ANSI_RESET+" ");
        waitForEnter(ANSI_YELLOW_BACKGROUND+ANSI_BLACK+"Press enter to continue..."+ANSI_RESET+" ");
    }

    public void endgame(){
        if(allcpushipshavebeensunk){
            clear();
            println(ANSI_BLACK+ANSI_GREEN_BACKGROUND+"You win!"+ANSI_RESET+" ");
            printBoardLine(22, 3);
            int nmisses = 0;
            int nhits = 0;
            int nhitsleft = 0;
            for (int i = 0; i < human.length; i++) {
                for (int j = 0; j < human[i].length; j++) {
                    if(cpu[i][j] == 4){
                        nmisses++;
                    }else if(cpu[i][j] >= 10){
                        nhits++;
                    }
                    if(human[i][j] >= 5 && human[i][j] <= 9){
                        nhitsleft++;
                    }
                }
            }
            int score = (int)(((double)nhits/(double)(nhits+nmisses))*100);
            println(ANSI_BLACK+"Your score was: "+score+"%"+ANSI_RESET+" ");
            println(ANSI_BLACK+"You missed "+nmisses+" times, which is a "+((double)nmisses/(double)(nhits+nmisses))*100+"% of missing"+ANSI_RESET+" ");
            println(ANSI_BLACK+"You hit "+nhits+" times, which is a "+((double)nhits/(double)(nhits+nmisses))*100+"% of hitting"+ANSI_RESET+" ");
            println(ANSI_BLACK+"The computer had "+nhitsleft+" hits left to win"+ANSI_RESET+" ");
            printBoardLine(22, 3);
            waitForEnter(ANSI_YELLOW_BACKGROUND+ANSI_BLACK+"Press enter to continue..."+ANSI_RESET+" ");
            clear();
            println(ANSI_BLACK+ANSI_PURPLE_BACKGROUND+"Do you want to play again?"+ANSI_RESET+" ");
            printBoardLine(22, 3);
            println(ANSI_GREEN_BACKGROUND+ANSI_BLACK+"1. Yes "+ANSI_RESET+" ");
            println(ANSI_RED_BACKGROUND+ANSI_BLACK+"2. No "+ANSI_RESET+" ");
            printBoardLine(11, 3);
            int start = 0;
            try{
                start = Integer.parseInt(System.console().readLine());
            }catch(Exception e){
                start = 0;
            }
            if(start == 1){
                clear();
                reset();
                new Final_Project(false);
            }else if(start == 2){
                clear();
                println(ANSI_RED_BACKGROUND+ANSI_BLACK+"Bye Bye..."+ANSI_RESET+" ");
                System.exit(0);
            }else{
                endgame();
            }
        }else if(allhumanshipshavebeensunk){
            clear();
            println(ANSI_BLACK+ANSI_RED_BACKGROUND+"You lose!"+ANSI_RESET+" ");
            printBoardLine(22, 3);
            int nmisses = 0;
            int nhits = 0;
            int nhitsleft = 0;
            for (int i = 0; i < human.length; i++) {
                for (int j = 0; j < human[i].length; j++) {
                    if(cpu[i][j] == 4){
                        nmisses++;
                    }else if(cpu[i][j] >= 10){
                        nhits++;
                    }
                    if(cpu[i][j] >= 5 && cpu[i][j] <= 9){
                        nhitsleft++;
                    }
                }
            }
            int score = (int)(((double)nhits/(double)(nhits+nmisses))*100);
            println(ANSI_BLACK+"Your score was: "+score+"%"+ANSI_RESET+" ");
            println(ANSI_BLACK+"You missed "+nmisses+" times, which is a "+((double)nmisses/(double)(nhits+nmisses))*100+"% of missing"+ANSI_RESET+" ");
            println(ANSI_BLACK+"You hit "+nhits+" times, which is a "+((double)nhits/(double)(nhits+nmisses))*100+"% of hitting"+ANSI_RESET+" ");
            println(ANSI_BLACK+"You had "+nhitsleft+" hits left to win"+ANSI_RESET+" ");
            printBoardLine(22, 3);
            waitForEnter(ANSI_YELLOW_BACKGROUND+ANSI_BLACK+"Press enter to continue..."+ANSI_RESET+" ");
            clear();
            println(ANSI_BLACK+ANSI_PURPLE_BACKGROUND+"Do you want to play again?"+ANSI_RESET+" ");
            printBoardLine(22, 3);
            println(ANSI_GREEN_BACKGROUND+ANSI_BLACK+"1. Yes "+ANSI_RESET+" ");
            println(ANSI_RED_BACKGROUND+ANSI_BLACK+"2. No "+ANSI_RESET+" ");
            printBoardLine(11, 3);
            printBoardLine(22, 3);
            println(ANSI_BLACK+ANSI_PURPLE_BACKGROUND+"Do you want to play again?"+ANSI_RESET+" ");
            printBoardLine(22, 3);
            println(ANSI_GREEN_BACKGROUND+ANSI_BLACK+"1. Yes "+ANSI_RESET+" ");
            println(ANSI_RED_BACKGROUND+ANSI_BLACK+"2. No "+ANSI_RESET+" ");
            printBoardLine(11, 3);
            int start = 0;
            try{
                start = Integer.parseInt(System.console().readLine());
            }catch(Exception e){
                start = 0;
            }
            if(start == 1){
                clear();
                reset();
                new Final_Project(false);
            }else if(start == 2){
                clear();
                println(ANSI_RED_BACKGROUND+ANSI_BLACK+"Bye Bye..."+ANSI_RESET+" ");
                System.exit(0);
            }else{
                endgame();
            }
        }
    }

    public void reset(){
        gamestart = false;
        allhumanshipsplaced = false;
        allhumanshipshavebeensunk = false;
        allcpushipshavebeensunk = false;
        human = new int[][]{pA, pB, pC, pD, pE, pF, pG, pH, pI, pJ};
        cpu = new int[][]{cA, cB, cC, cD, cE, cF, cG, cH, cI, cJ};
        for (int i = 0; i < human.length; i++) {
            for (int j = 0; j < human[i].length; j++) {
                human[i][j] = 0;
                cpu[i][j] = 0;
            }
        }
    }

    public void cpuhit(){
        printBoard("human");
        println(ANSI_BLACK+ANSI_PURPLE_BACKGROUND+"The computer is thinking..."+ANSI_RESET+" ");
        try {
            Thread.sleep((int)(Math.random() * 1500) + 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printBoardLine(22, 3);
        int hitrate = -1;
        if (gamelevel == 1) {
            hitrate = (Math.random() < 0.05) ? 1 : 0;
        } else if (gamelevel == 2) {
            hitrate = (Math.random() < 0.17) ? 1 : 0;
        } else if (gamelevel == 3) {
            hitrate = (Math.random() < 0.30) ? 1 : 0;
        } else if (gamelevel == 4) {
            hitrate = (Math.random() < 0.98) ? 1 : 0;
        }
        int shipcore = 0;
        int typerow = 0;
        int typecol = 0;
        if(hitrate == 0){
            int row = (int)(Math.random() * 10);
            int col = (int)(Math.random() * 10);
            while(human[row][col] != 0){
                row = (int)(Math.random() * 10);
                col = (int)(Math.random() * 10);
            }
            shipcore = human[row][col];
            typerow = row;
            typecol = col;
        }else if(hitrate == 1){
            int row = (int)(Math.random() * 10);
            int col = (int)(Math.random() * 10);
            while (!(human[row][col] >= 5 && human[row][col] <= 9)) {
                row = (int) (Math.random() * 10);
                col = (int) (Math.random() * 10);
            }
            shipcore = human[row][col];
            typerow = row;
            typecol = col;
        }
        int type = 0;
        if(shipcore == 0){
            type = 1;
            human[typerow][typecol] = 4;
        }else if(shipcore == 4){
            type = 10;
            human[typerow][typecol] = 11;
        }else if(shipcore == 5){
            type = 9;
            human[typerow][typecol] = 10;
            if(checksunk(5, "human") == true){
                type = 3;
                sinkship(15, "human");
            }
        }else if(shipcore == 6){
            type = 10;
            human[typerow][typecol] = 11;
            if(checksunk(6, "human") == true){
                type = 4;
                sinkship(16, "human");
            }
        }else if(shipcore == 7){
            type = 11;
            human[typerow][typecol] = 12;
            if(checksunk(7, "human") == true){
                type = 5;
                sinkship(17, "human");
            }
        }else if(shipcore == 8){
            type = 12;
            human[typerow][typecol] = 13;
            if(checksunk(8, "human") == true){
                type = 6;
                sinkship(18, "human");
            }
        }else if(shipcore == 9){
            type = 13;
            human[typerow][typecol] = 14;
            if(checksunk(9, "human") == true){
                type = 7;
                sinkship(19, "human");
            }
        }
        if(checksunk(5, "human") == true && checksunk(6, "human") == true && checksunk(7, "human") == true && checksunk(8, "human") == true && checksunk(9, "human") == true){
            allhumanshipshavebeensunk = true;
            type = 8;
        }
        printBoard("human");
        if(type == 1){
            println(ANSI_BLACK+ANSI_GREEN_BACKGROUND+"The computer missed!"+ANSI_RESET+" ");
        }else if(type == 3){
            println(ANSI_BLACK+ANSI_RED_BACKGROUND+"The computer sunk the Aircraft Carrier!"+ANSI_RESET+" ");
        }else if(type == 4){
            println(ANSI_BLACK+ANSI_RED_BACKGROUND+"The computer sunk the Battleship!"+ANSI_RESET+" ");
        }else if(type == 5){
            println(ANSI_BLACK+ANSI_RED_BACKGROUND+"The computer sunk the Cruiser!"+ANSI_RESET+" ");
        }else if(type == 6){
            println(ANSI_BLACK+ANSI_RED_BACKGROUND+"The computer sunk the Submarine!"+ANSI_RESET+" ");
        }else if(type == 7){
            println(ANSI_BLACK+ANSI_RED_BACKGROUND+"The computer sunk the Destroyer!"+ANSI_RESET+" ");
        }else if(type == 8){
            println(ANSI_BLACK+ANSI_RED_BACKGROUND+"The computer sunk all of the ships!"+ANSI_RESET+" ");
        }else if(type == 9){
            println(ANSI_BLACK+ANSI_RED_BACKGROUND+"The computer hit your Aircraft Carrier!"+ANSI_RESET+" ");
        }else if(type == 10){
            println(ANSI_BLACK+ANSI_RED_BACKGROUND+"The computer hit your Battleship!"+ANSI_RESET+" ");
        }else if(type == 11){
            println(ANSI_BLACK+ANSI_RED_BACKGROUND+"The computer hit your Cruiser!"+ANSI_RESET+" ");
        }else if(type == 12){
            println(ANSI_BLACK+ANSI_RED_BACKGROUND+"The computer hit your Submarine!"+ANSI_RESET+" ");
        }else if(type == 13){
            println(ANSI_BLACK+ANSI_RED_BACKGROUND+"The computer hit your Destroyer!"+ANSI_RESET+" ");
        }
        waitForEnter(ANSI_YELLOW_BACKGROUND+ANSI_BLACK+"Press enter to continue..."+ANSI_RESET+" ");
    }

    public void humanhit(String error){
        printBoard("cpu", true);
        println(ANSI_BLACK+ANSI_PURPLE_BACKGROUND+"Where do you want to hit?"+ANSI_RESET+" ");
        printBoardLine(22, 3);
        println(ANSI_BLACK+ANSI_GREEN_BACKGROUND+"Enter the coordinate you want to hit (ex. A1):"+ANSI_RESET+" ");
        printBoardLine(11, 3);
        if(error != ""){
            println(ANSI_RED_BACKGROUND+ANSI_BLACK+error+ANSI_RESET+" ");
        }
        String coordinate = System.console().readLine();
        if (!(coordinate.length() == 2 || (coordinate.length() == 3 && coordinate.substring(1, 3).equals("10")))){
            humanhit("Coordinate does not exist. Try again.");
            return;
        }
        String colPart = coordinate.substring(0, 1).toUpperCase();
        int row = 0;
        int col = 0;
        try {
            row = Integer.parseInt(coordinate.substring(1));
        } catch (NumberFormatException e) {
            humanhit("Invalid Number Coordinate. Try again.");
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
            humanhit("Invalid Letter Coordinate. Try again.");
            return;
        }
        if (row < 1 || row > 10) {
            humanhit("Invalid Coordinate. Try again.");
            return;
        }
        row -= 1;
        int shipcore = cpu[row][col];
        int type = 0;
        if(shipcore == 0){
            cpu[row][col] = 4;
            type = 1;
        }else if(shipcore == 2){
            type = 9;
        }else if(shipcore == 4){
            type = 10;
        }else if(shipcore == 5){
            cpu[row][col] = 10;
            type = 2;
            if(checksunk(5, "cpu") == true){
                type = 3;
                sinkship(15, "cpu");
            }
        }else if(shipcore == 6){
            cpu[row][col] = 11;
            type = 2;
            if(checksunk(6, "cpu") == true){
                type = 4;
                sinkship(16, "cpu");
            }
        }else if(shipcore == 7){
            cpu[row][col] = 12;
            type = 2;
            if(checksunk(7, "cpu") == true){
                type = 5;
                sinkship(17, "cpu");
            }
        }else if(shipcore == 8){
            cpu[row][col] = 13;
            type = 2;
            if(checksunk(8, "cpu") == true){
                type = 6;
                sinkship(18, "cpu");
            }
        }else if(shipcore == 9){
            cpu[row][col] = 14;
            type = 2;
            if(checksunk(9, "cpu") == true){
                type = 7;
                sinkship(19, "cpu");
            }
        }else{
            type = 9;
        }
        if(checksunk(5, "cpu") == true && checksunk(6, "cpu") == true && checksunk(7, "cpu") == true && checksunk(8, "cpu") == true && checksunk(9, "cpu") == true){
            allcpushipshavebeensunk = true;
            type = 8;
        }
        printBoard("cpu", true);
        if(type == 1){
            println(ANSI_BLACK+ANSI_RED_BACKGROUND+"You missed!"+ANSI_RESET+" ");
        }else if(type == 2){
            println(ANSI_BLACK+ANSI_GREEN_BACKGROUND+"You hit a ship!"+ANSI_RESET+" ");
        }else if(type == 3){
            println(ANSI_BLACK+ANSI_GREEN_BACKGROUND+"You sunk the Aircraft Carrier!"+ANSI_RESET+" ");
        }else if(type == 4){
            println(ANSI_BLACK+ANSI_GREEN_BACKGROUND+"You sunk the Battleship!"+ANSI_RESET+" ");
        }else if(type == 5){
            println(ANSI_BLACK+ANSI_GREEN_BACKGROUND+"You sunk the Cruiser!"+ANSI_RESET+" ");
        }else if(type == 6){
            println(ANSI_BLACK+ANSI_GREEN_BACKGROUND+"You sunk the Submarine!"+ANSI_RESET+" ");
        }else if(type == 7){
            println(ANSI_BLACK+ANSI_GREEN_BACKGROUND+"You sunk the Destroyer!"+ANSI_RESET+" ");
        }else if(type == 8){
            println(ANSI_BLACK+ANSI_GREEN_BACKGROUND+"You sunk all of the computers ships!"+ANSI_RESET+" ");
        }else if(type == 9){
            humanhit(ANSI_BLACK+ANSI_RED_BACKGROUND+"You already hit that ship!"+ANSI_RESET+" ");
        }else if(type == 10){
            humanhit(ANSI_BLACK+ANSI_RED_BACKGROUND+"You already missed there!"+ANSI_RESET+" ");
        }
        waitForEnter(ANSI_YELLOW_BACKGROUND+ANSI_BLACK+"Press enter to continue..."+ANSI_RESET+" ");
    }

    public void sinkship(int type, String player) {
        int[][] arrays;
        if (player.equals("human")) {
            arrays = human;
        } else if (player.equals("cpu")) {
            arrays = cpu;
        } else {
            return;
        }
        int shiptype = type - 5;
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                if (arrays[i][j] == shiptype) {
                    arrays[i][j] = type;
                }
            }
        }
    }

    public boolean checksunk(int type, String player) {
        int[][] arrays;
        if (player.equals("human")) {
            arrays = human;
        } else if (player.equals("cpu")) {
            arrays = cpu;
        } else {
            return false;
        }
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                if(arrays[i][j] == type){
                    return false;
                }
            }
        }
        return true;
    }

    public void startgame(String error, int start){
        clear();
        println(ANSI_BLACK+ANSI_PURPLE_BACKGROUND+"Are you ready to start?"+ANSI_RESET+" ");
        printBoardLine(22, 3);
        if(gamelevel == 1){
            println(ANSI_CYAN_BACKGROUND+ANSI_BLACK+"Difficulty:"+ANSI_RESET+" "+ANSI_BLACK+ANSI_GREEN_BACKGROUND+"Easy"+ANSI_RESET);
        }else if(gamelevel == 2){
            println(ANSI_CYAN_BACKGROUND+ANSI_BLACK+"Difficulty:"+ANSI_RESET+" "+ANSI_BLACK+ANSI_BLUE_BACKGROUND+"Medium"+ANSI_RESET);
        }else if(gamelevel == 3){
            println(ANSI_CYAN_BACKGROUND+ANSI_BLACK+"Difficulty:"+ANSI_RESET+" "+ANSI_BLACK+ANSI_YELLOW_BACKGROUND+"Hard"+ANSI_RESET);
        }else if(gamelevel == 4){
            println(ANSI_CYAN_BACKGROUND+ANSI_BLACK+"Difficulty:"+ANSI_RESET+" "+ANSI_BLACK+ANSI_RED_BACKGROUND+"Impossible"+ANSI_RESET);
        }
        printBoardLine(11, 3);
        println(ANSI_GREEN_BACKGROUND+ANSI_BLACK+"1. Yes "+ANSI_RESET+" ");
        println(ANSI_RED_BACKGROUND+ANSI_BLACK+"2. No "+ANSI_RESET+" ");
        printBoardLine(11, 3);
        if(error != ""){
            println(error);
        }
        if(start != 2){
            try{
                start = Integer.parseInt(System.console().readLine());
            }catch(Exception e){
                start = 0;
            }
        }
        if(start == 1){
            println(ANSI_GREEN_BACKGROUND+ANSI_BLACK+"Let's go!"+ANSI_RESET+" ");
        }else if(start == 2){
            clear();
            println(ANSI_PURPLE_BACKGROUND+ANSI_BLACK+"Do you want to change the level?"+ANSI_RESET+" ");
            printBoardLine(22, 3);
            println(ANSI_GREEN_BACKGROUND+ANSI_BLACK+"1. Yes "+ANSI_RESET+" ");
            println(ANSI_RED_BACKGROUND+ANSI_BLACK+"2. No "+ANSI_RESET+" ");
            printBoardLine(11, 3);
            if(error != ""){
                println(error);
            }
            int start2;
            try{
                start2 = Integer.parseInt(System.console().readLine());
            }catch(Exception e){
                start2 = 0;
            }
            if(start2 == 1){
                level("");
            }else if(start2 == 2){
                clear();
                println(ANSI_RED_BACKGROUND+ANSI_BLACK+"Bye Bye..."+ANSI_RESET+" ");
                System.exit(0);
            }else{
                startgame(ANSI_RED_BACKGROUND+ANSI_BLACK+"Invalid input. Try again."+ANSI_RESET+" ",2);
            }
        }else{
            startgame(ANSI_RED_BACKGROUND+ANSI_BLACK+"Invalid input. Try again."+ANSI_RESET+" ",0);
        }
        if(gamestart == false){
            gamestart = true;
            waitForEnter(ANSI_YELLOW_BACKGROUND+ANSI_BLACK+"Press enter to continue..."+ANSI_RESET+" ");
        }
    }

    public void level(String error){
        clear();
        println(ANSI_BLACK+ANSI_CYAN_BACKGROUND+"Please choose a level:"+ANSI_RESET+" ");
        printBoardLine(22, 3);
        println(ANSI_BLACK+ANSI_GREEN_BACKGROUND+"1. Easy "+ANSI_RESET+" ");
        println(ANSI_BLACK+ANSI_BLUE_BACKGROUND+"2. Medium "+ANSI_RESET+" ");
        println(ANSI_BLACK+ANSI_YELLOW_BACKGROUND+"3. Hard "+ANSI_RESET+" ");
        println(ANSI_BLACK+ANSI_RED_BACKGROUND+"4. Impossible "+ANSI_RESET+" ");
        printBoardLine(11, 3);
        if(error != ""){
            println(error);
        }
        int start = 0;
        try{
            start = Integer.parseInt(System.console().readLine());
        }catch(Exception e){
            level(ANSI_RED_BACKGROUND+ANSI_BLACK+"Invalid input. Try again."+ANSI_RESET+" ");
        }
        if(start != 0){
            gamelevel = start;
            startgame("", 0);
        }
    }

    public void printerror(String error){
        if(error != ""){
            println(ANSI_RED_BACKGROUND+ANSI_BLACK+error+ANSI_RESET+" ");
        }
    }

    public void waitForEnter(String message, Object... args) {
    Console c = System.console();
    if (c != null) {
        if (message != null)
            c.format(message, args);
        c.format("\n");
        c.readLine();
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
                    println(ANSI_PURPLE_BACKGROUND+ANSI_BLACK+"Aircraft Carrier"+ANSI_RESET+" ");
                    println("Enter the starting coordinate of the ship (ex. A1):");
                    start = System.console().readLine();
                    println("Enter the direction of the ship (ex. up, down, left, right):");
                    dir = System.console().readLine();
                    setships(start, dir, 5, type);
                    printBoard("human");
                    humansetships(6, "");
                }else if(type == 6){
                    println(ANSI_CYAN_BACKGROUND+ANSI_BLACK+"Battleship"+ANSI_RESET+" ");
                    println("Enter the starting coordinate of the ship (ex. A1):");
                    start = System.console().readLine();
                    println("Enter the direction of the ship (ex. up, down, left, right):");
                    dir = System.console().readLine();
                    setships(start, dir, 4, type);
                    printBoard("human");
                    humansetships(7, "");
                }else if(type == 7){
                    println(ANSI_YELLOW_BACKGROUND+ANSI_BLACK+"Cruiser"+ANSI_RESET+" ");
                    println("Enter the starting coordinate of the ship (ex. A1):");
                    start = System.console().readLine();
                    println("Enter the direction of the ship (ex. up, down, left, right):");
                    dir = System.console().readLine();
                    setships(start, dir, 3, type);
                    printBoard("human");
                    humansetships(8, "");
                }else if(type == 8){
                    println(ANSI_GREEN_BACKGROUND+ANSI_BLACK+"Submarine"+ANSI_RESET+" ");
                    println("Enter the starting coordinate of the ship (ex. A1):");
                    start = System.console().readLine();
                    println("Enter the direction of the ship (ex. up, down, left, right):");
                    dir = System.console().readLine();
                    setships(start, dir, 3, type);
                    printBoard("human");
                    humansetships(9, "");
                }
            }

            if(type == 9){
                println(ANSI_RED_BACKGROUND+ANSI_BLACK+"Destroyer"+ANSI_RESET+" ");
                println("Enter the starting coordinate of the ship (ex. A1):");
                start = System.console().readLine();
                println("Enter the direction of the ship (ex. up, down, left, right):");
                dir = System.console().readLine();
                setships(start, dir, 2, type);
                printBoard("human");
                allhumanshipsplaced = true;
            }
        }else if(allhumanshipsplaced){
            println(ANSI_BLACK+ANSI_GREEN_BACKGROUND+"You have placed all of your ships!"+ANSI_RESET+" ");
            waitForEnter(ANSI_YELLOW_BACKGROUND+ANSI_BLACK+"Press enter to continue..."+ANSI_RESET+" ");
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

    public void print(String message){
        System.out.print(message);
    }

    public void println(String message){
        System.out.println(message);
    }

    public void printBoardLine(int n, int type) {
        print(ANSI_BLACK);
        for (int i = 0; i < n; i++) {
            if(type == 0){
                if(i == 0) {
                    print(topCornerLeft+""+emDash+""+emDash);
                }
                if(i == (n - 1)) {
                    println(emDash+""+emDash+""+topCornerRight);
                }else{
                    print(emDash+""+emDash+""+topT+""+emDash);
                }
            }else if(type == 1){
                if(i == 0) {
                    print(leftT+""+emDash+""+emDash);
                }
                if(i == (n - 1)) {
                    println(emDash+""+emDash+""+rightT);
                }else{
                    print(emDash+""+emDash+""+cross+""+emDash);
                }
            }else if(type == 2){
                if(i == 0) {
                    print(bottomCornerLeft+""+emDash+""+emDash);
                }
                if(i == (n - 1)) {
                    println(emDash+""+emDash+""+bottomCornerRight);
                }else{
                    print(emDash+""+emDash+""+bottomT+""+emDash);
                }
            }else if(type == 3){
                print(ANSI_WHITE);
                if(i == (n - 1)) {
                    println(emDash+""+emDash);
                }else{
                    print(emDash+""+emDash);
                }
            }
        }
    }
    
    private void printData(int row, int col, String player, boolean hidden){
        if(row == 0){
            if(col == 0) {
                print("  ");
            }else{
                print(letters[col - 1]);
            }
        }else if (col == 0) {
            if(row == 0) {
                print(" ");
            }else if (row == 10){
                print(row+"");
            }else{
                print(" "+row);
            }
        }else{
            printChar(row, col, player, hidden);
        }
    }

    private void printChar(int row, int col, String player, boolean hidden){
        int[][] arrays;
        if(player == "human") {
            arrays = human;
        }else{
            arrays = cpu;
        }
        String shipout = "";
        if(arrays[row - 1][col - 1] == 0){
            shipout = " "; //empty
        }else if(arrays[row - 1][col - 1] == 1){
            if(hidden == true){
                shipout = " "; //empty
            }else{
                shipout = ANSI_BLACK+ship; //ship
            }
        }else if(arrays[row - 1][col - 1] == 2){
            shipout = hit+""; //hit
        }else if(arrays[row - 1][col - 1] == 3){
            shipout = sunk+""; //sunk
        }else if(arrays[row - 1][col - 1] == 4){
            shipout = miss+""; //miss
        }else if(arrays[row - 1][col - 1] == 5){
            if(hidden == true){
                shipout = " "; //empty
            }else{
                shipout = ANSI_PURPLE+ship; //aircraft carrier
            }
        }else if(arrays[row - 1][col - 1] == 6){
            if(hidden == true){
                shipout = " "; //empty
            }else{
                shipout = ANSI_CYAN+ship; //battleship
            }
        }else if(arrays[row - 1][col - 1] == 7){
            if(hidden == true){
                shipout = " "; //empty
            }else{
                shipout = ANSI_YELLOW+ship; //cruiser
            }
        }else if(arrays[row - 1][col - 1] == 8){
            if(hidden == true){
                shipout = " "; //empty
            }else{
                shipout = ANSI_GREEN+ship; //submarine
            }
        }else if(arrays[row - 1][col - 1] == 9){
            if(hidden == true){
                shipout = " "; //empty
            }else{
                shipout = ANSI_RED+ship; //destroyer
            }
        }else if(arrays[row - 1][col - 1] == 10){
            if(hidden == true){
                shipout = hit+""; //hit
            }else{
                shipout = ANSI_RESET+ANSI_PURPLE+hit+ANSI_BLUE_BACKGROUND; //aircraft carrier hit
            }
        }else if(arrays[row - 1][col - 1] == 11){
            if(hidden == true){
                shipout = hit+""; //hit
            }else{
                shipout = ANSI_RESET+ANSI_CYAN+hit+ANSI_BLUE_BACKGROUND; //battleship hit
            }
        }else if(arrays[row - 1][col - 1] == 12){
            if(hidden == true){
                shipout = hit+""; //hit
            }else{
                shipout = ANSI_RESET+ANSI_YELLOW+hit+ANSI_BLUE_BACKGROUND; //cruiser hit
            }
        }else if(arrays[row - 1][col - 1] == 13){
            if(hidden == true){
                shipout = hit+""; //hit
            }else{
                shipout = ANSI_RESET+ANSI_GREEN+hit+ANSI_BLUE_BACKGROUND; //submarine hit
            }
        }else if(arrays[row - 1][col - 1] == 14){
            if(hidden == true){
                shipout = hit+""; //hit
            }else{
                shipout = ANSI_RESET+ANSI_RED+hit+ANSI_BLUE_BACKGROUND; //destroyer hit
            }
        }else if(arrays[row - 1][col - 1] == 15){
            shipout = ANSI_RESET+ANSI_PURPLE+sunk+ANSI_BLUE_BACKGROUND; //aircraft carrier sunk
        }else if(arrays[row - 1][col - 1] == 16){
            shipout = ANSI_RESET+ANSI_CYAN+sunk+ANSI_BLUE_BACKGROUND; //battleship sunk
        }else if(arrays[row - 1][col - 1] == 17){
            shipout = ANSI_RESET+ANSI_YELLOW+sunk+ANSI_BLUE_BACKGROUND; //cruiser sunk
        }else if(arrays[row - 1][col - 1] == 18){
            shipout = ANSI_RESET+ANSI_GREEN+sunk+ANSI_BLUE_BACKGROUND; //submarine sunk
        }else if(arrays[row - 1][col - 1] == 19){
            shipout = ANSI_RESET+ANSI_RED+sunk+ANSI_BLUE_BACKGROUND; //destroyer sunk
        }
        print(shipout+ANSI_BLACK);
    }

    private void printBoard(String player, boolean... hidden) {
        clear();
        boolean hide = false;
        for (boolean h : hidden) {
            if (h) {
                hide = true;
                break;
            }
        }
        if(player == "human") {
            println(ANSI_GREEN+"Your Board:"+ANSI_RESET);
        }else if (player == "cpu"){
            println(ANSI_RED+"Computer's Board:"+ANSI_RESET);
        }
        print(ANSI_BLUE_BACKGROUND);
        for (int i = 0; i < BOARD_SIZE; i++) {
            if(i == 0) {
                printBoardLine(11, 0);
            }
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (j == 0) {
                    print(side+" ");
                }else{
                    print(" "+side+" ");
                }
                printData(i, j, player, hide);
                if (j == (BOARD_SIZE - 1)) {
                    print(" "+side);
                }
            }
            println("");
            if(i == (BOARD_SIZE - 1)) {
                printBoardLine(11, 2);
            }else if (i < BOARD_SIZE) {
                printBoardLine(11, 1);
            }
        }
         print(ANSI_RESET);
    }
    public static void main(String[] args) {
        new Final_Project(true);
    }
}
