package Projects.asciiGames;

import org.fusesource.jansi.AnsiConsole;
import Projects.asciiGames.games.*;
import java.io.File;
import java.util.ArrayList;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.util.Arrays;
public class manager {
    public static void main(String[] args) throws InterruptedException, Exception{
        AnsiConsole.systemInstall();
        if (AnsiConsole.getTerminalWidth() < 80) {
            ascii.println("Terminal width must be at least 80 characters wide.");
            System.exit(1);
        }
        ascii.wait(300);
        //start();
        File folder = new File(manager.class.getResource("games/").getPath());
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null && listOfFiles.length > 0) {
            ArrayList<String> gameClasses = new ArrayList<String>();
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().endsWith(".class")) {
                    if (file.getName().replace(".class", "").endsWith("$Game")) {
                        gameClasses.add(file.getName().replace(".class", ""));
                    }
                }
            }
            for (String gameClassName : gameClasses) {
                Class<?> gameClass = Class.forName("Projects.asciiGames.games." + gameClassName);
                ArrayList<Object> game = new ArrayList<>();
                Field[] fields = gameClass.getFields();
                for (Field field : fields) {
                    if (field.getType().equals(String.class)) {
                        String fieldName = field.getName();
                        Object fieldValue = field.get(null);
                        game.add(Arrays.asList(fieldName, fieldValue));
                    }
                }
            }
        }
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
    }
}