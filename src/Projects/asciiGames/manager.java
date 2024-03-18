package Projects.asciiGames;

import org.fusesource.jansi.AnsiConsole;

public class manager {
    public static void main(String[] args) {
        AnsiConsole.systemInstall();
        ascii.clear();
        ascii.println("Hello, World!");
    }
}
