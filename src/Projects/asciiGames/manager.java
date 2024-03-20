package Projects.asciiGames;

import org.fusesource.jansi.AnsiConsole;

public class manager {
    public static void main(String[] args) throws InterruptedException {
        AnsiConsole.systemInstall();
        animation.main(); 
    }
}
