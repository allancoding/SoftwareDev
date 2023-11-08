package Fun;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;



public class tetris {
    public static int[][] gameboard = new int[10][15];
    public static void main(String[] args) throws IOException {
        String classpath = System.getProperty("java.class.path");
        String[] classpathEntries = classpath.split(System.getProperty("path.separator"));
        String path = "";
        for (String entry : classpathEntries) {
            if (entry.endsWith(".jar")) {
                path = entry;
            }
        }
        if (System.console() != null) {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec("javaw -cp " + path + " Fun.tetris");
            BufferedReader stdInput = new BufferedReader(new 
                InputStreamReader(proc.getInputStream()));
            BufferedReader stdError = new BufferedReader(new 
                InputStreamReader(proc.getErrorStream()));
            while (proc.isAlive()) {
                String s = stdInput.readLine();
                String ss = stdError.readLine();
                if(s != null){
                    System.out.println(s);
                }
                if(ss != null){
                    System.out.println(ss);
                }
            }
            System.exit(0);
        }
        System.out.println("Hello World!");
        System.err.println("Hello World! error");
        //Create a new Terminal object
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Terminal terminal = terminalFactory.createTerminal();
        

        // Create a new Screen object from the Terminal
        Screen screen = new TerminalScreen(terminal);

        // Start the screen
        screen.startScreen();

        // Create a new Window object
        BasicWindow window = new BasicWindow();

        // Create a new WindowBasedTextGUI object
        MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLACK));

        // Add the window to the GUI
        gui.addWindowAndWait(window);
        System.out.println("Debuggggg!!!!!!!");
        
    } 

    //Print the Board
    /*
    public static String printNormal(int[][] board) {
        String result = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                result += board[i][j];
            }
            result += "\n";
        }
        return result;
    }

    //Syntax Simplification
    static void print(String text) {
        System.out.print(text);
    }

    //clear the screen
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
*/
}