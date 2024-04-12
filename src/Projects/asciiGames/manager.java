package Projects.asciiGames;

import org.fusesource.jansi.AnsiConsole;

import Projects.asciiGames.games.Battleship.Game;
public class manager {
    public static void main(String[] args) throws InterruptedException, Exception{
        AnsiConsole.systemInstall();
        if (AnsiConsole.getTerminalWidth() < 80) {
            ascii.println("Terminal width must be at least 80 characters wide.");
            System.exit(1);
        }
        ascii.wait(300);
        //start();
       
        //ascii.wait(10000);
    }
    public static void start() throws InterruptedException{
        animation.slidein();
        ascii.wait(500);
        animation.show();
        ascii.printRepeated("-", 80, true);
        ascii.println("Welcome to ASCII Games!");
        ascii.printRepeated("=", 24, true);
        ascii.println("List of Games:");
        ascii.printRepeated("_", 15, true);
        GameList games = new GameList();

        for (int i = 0; i < games.list.length; i++) {
            ascii.println(games.list[i]);
        }
    }
}
public class GameList {
    for 
}
