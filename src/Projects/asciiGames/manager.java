package Projects.asciiGames;

import org.fusesource.jansi.AnsiConsole;
import org.jline.reader.LineReader;
import org.jline.reader.impl.DefaultParser;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.reader.LineReaderBuilder;
import java.util.Arrays;

public class manager {
    public static void main(String[] args) throws InterruptedException, Exception{
        //start();
        Terminal terminal = TerminalBuilder.builder().build();
        LineReader reader = LineReaderBuilder.builder()
                .terminal(terminal)
                .parser(new DefaultParser())
                .completer(new StringsCompleter(Arrays.asList("item1", "item2", "item3")))
                .build();

        String line;
        while ((line = reader.readLine("Select an item: ")) != null) {
            System.out.println("You selected: " + line);
        }
        //ascii.wait(10000);
    }
    public static void start() throws InterruptedException{
        AnsiConsole.systemInstall();
        if (AnsiConsole.getTerminalWidth() < 80) {
            ascii.println("Terminal width must be at least 80 characters wide.");
            System.exit(1);
        }
        ascii.wait(300);
        animation.slidein();
        ascii.wait(500);
        animation.show();
        ascii.printRepeated("-", 80, true);
        ascii.println("Welcome to ASCII Games!");
        ascii.printRepeated("=", 24, true);
        ascii.println("List of Games:");
    }
}
