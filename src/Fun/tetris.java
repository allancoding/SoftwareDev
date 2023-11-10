package Fun;
import Fun.JavaW;
import java.io.IOException;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
public class tetris {
    public static int[][] gameboard = new int[10][15];
    public static void main(String[] args) throws IOException {
        JavaW.run();
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
