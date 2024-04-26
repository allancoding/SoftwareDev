package Projects.asciiGames;

import org.fusesource.jansi.AnsiConsole;
import java.io.File;
import java.util.ArrayList;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
public class manager {
    private static final String packagePath = "Projects.asciiGames";
    private static boolean gameRunning = false;
    private static ArrayList<Object[]> gameS = new ArrayList<>();
    private static Thread shutdownHook;
    private static boolean managerRunning = true;
    public static void main(String[] args) throws Exception{
        AnsiConsole.systemInstall();
        if (AnsiConsole.getTerminalWidth() < 80) {
            ascii.println("Terminal width must be at least 80 characters wide.");
            System.exit(1);
        }
        ascii.wait(300);
        ctrC();
        setup();
        start();
    }

    public static void setup() throws Exception {
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
                Class<?> gameClass = Class.forName(packagePath + ".games." + gameClassName);
                Field[] fields = gameClass.getFields();
                String[] fieldValue = new String[fields.length];
                int i = 0;
                for (Field field : fields) {
                    if (field.getType().equals(String.class)) {
                        fieldValue[i] = (String) field.get(null);
                        i++;
                    }
                }
                gameS.add(new Object[]{gameClassName, fieldValue[0], fieldValue[1]});
            }
        }
    }

    public static void start() throws Exception{
        animation.slidein();
        animation.show();
        ascii.printRepeated(ascii.color.ANSI_PURPLE + "-" + ascii.color.ANSI_RESET, 80, true);
        ascii.println(ascii.color.ANSI_RED + "Welcome to ASCII Games!" + ascii.color.ANSI_RESET);
        ascii.printRepeated(ascii.color.ANSI_YELLOW + "=" + ascii.color.ANSI_RESET, 24, true);
        ascii.println(ascii.color.ANSI_GREEN + "List of Games:" + ascii.color.ANSI_RESET);
        ascii.printRepeated(ascii.color.ANSI_CYAN + "~" + ascii.color.ANSI_RESET, 15, true);
        Object[][] array = new Object[gameS.size()][3];
        array = gameS.toArray(array);
        int i = 1;
        for (Object[] obj : array) {
            System.out.println(ascii.color.ANSI_BLUE + i + ". " + obj[1] + " - " + obj[2] + ascii.color.ANSI_RESET);
            i++;
        }
        ascii.printRepeated(ascii.color.ANSI_PURPLE +"-" + ascii.color.ANSI_RESET, 20, true);
        int start = -1;
        while (start < 1 || start > gameS.size()) {
            try {
                System.out.print("Enter a number between 1 and " + gameS.size() + ": ");
                start = Integer.parseInt(System.console().readLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        System.out.println(array[start - 1][0]+"");
        Class<?> clazz = Class.forName(array[start - 1][0]+"");
        Method method = clazz.getMethod("start", boolean.class);
        method.invoke(null, true);
        ascii.waitForEnter("ok?");
    }
    public static void ctrC() {
        shutdownHook = new Thread(() -> {
            while (managerRunning) {
                if (gameRunning) {
                    gameRunning = false;
                    ascii.clear();
                    try {
                        start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    managerRunning = false;
                    ascii.clear();
                    ascii.println(ascii.color.ANSI_RED + "Goodbye!");
                    ascii.println(ascii.color.ANSI_GREEN + "Thank you for playing ASCII Games!" + ascii.color.ANSI_RESET);
                    Thread.currentThread().interrupt();
                }
            }
        });
        Runtime.getRuntime().addShutdownHook(shutdownHook);
    }
}