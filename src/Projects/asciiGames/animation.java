package Projects.asciiGames;

import java.util.Random;

public class animation {
    public static void main() throws InterruptedException {
        Thread.sleep(300);
        // slidein();
        // Thread.sleep(1000);
        // slideout();
        comein();
    }
    public static void slidein() throws InterruptedException {
        String[] frames = {
            "_______             __________    _________                             ______",
            "___    |_______________(_)__(_)   __  ____/_____ _______ __________________  /",
            "__  /| |_  ___/  ___/_  /__  /    _  / __ _  __ `/_  __ `__ \\  _ \\_  ___/_  / ",
            "_  ___ |(__  )/ /__ _  / _  /     / /_/ / / /_/ /_  / / / / /  __/(__  ) /_/  ",
            "/_/  |_/____/ \\___/ /_/  /_/      \\____/  \\__,_/ /_/ /_/ /_/\\___//____/ (_)   "
        };
        int frameWidth = frames[0].length();
        ascii.clear();
        System.out.flush();
        for (int i = 0; i <= frameWidth; i++) {
            if (i != frameWidth) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
            for (String line : frames) {
                System.out.print("\033[" + i + "D");
                if (frameWidth - i > 0) {
                    System.out.print(line.substring(frameWidth - i));
                }
                System.out.println();
            }
            Thread.sleep(10);
        }
    }
    public static void slideout() throws InterruptedException {
        String[] frames = {
            "_______             __________    _________                             ______",
            "___    |_______________(_)__(_)   __  ____/_____ _______ __________________  /",
            "__  /| |_  ___/  ___/_  /__  /    _  / __ _  __ `/_  __ `__ \\  _ \\_  ___/_  / ",
            "_  ___ |(__  )/ /__ _  / _  /     / /_/ / / /_/ /_  / / / / /  __/(__  ) /_/  ",
            "/_/  |_/____/ \\___/ /_/  /_/      \\____/  \\__,_/ /_/ /_/ /_/\\___//____/ (_)   "
        };
        int frameWidth = frames[0].length();
        int frameHeight = frames.length;
        System.out.flush();
        for (int lineIndex = 0; lineIndex < frameHeight; lineIndex++) {
            for (int i = frameWidth; i >= 0; i--) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.print("\033[" + (lineIndex + 1) + ";1H");
                if (frameWidth - i > 0 && frameHeight - lineIndex > 0) {
                    System.out.print(frames[lineIndex].substring(frameWidth - i));
                }
                System.out.println();
                for (int j = lineIndex + 1; j < frameHeight; j++) {
                    System.out.print(frames[j]);
                    System.out.println();
                }
                Thread.sleep(10);
            }
        }
    }
    public static void comein() throws InterruptedException {
        String text = " █████╗ ███████╗ ██████╗██╗██╗     ██████╗  █████╗ ███╗   ███╗███████╗███████╗██╗\n" +
                      "██╔══██╗██╔════╝██╔════╝██║██║    ██╔════╝ ██╔══██╗████╗ ████║██╔════╝██╔════╝██║\n" +
                      "███████║███████╗██║     ██║██║    ██║  ███╗███████║██╔████╔██║█████╗  ███████╗██║\n" +
                      "██╔══██║╚════██║██║     ██║██║    ██║   ██║██╔══██║██║╚██╔╝██║██╔══╝  ╚════██║╚═╝\n" +
                      "██║  ██║███████║╚██████╗██║██║    ╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗███████║██╗\n" +
                      "╚═╝  ╚═╝╚══════╝ ╚═════╝╚═╝╚═╝     ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝╚══════╝╚═╝";
        
        int textLength = text.length();
        boolean[] textvis = new boolean[textLength];

        for (int i = 0; i < textLength; i++) {
            StringBuilder animatedText = new StringBuilder();
            // Randomly select characters to be visible
            textvis[i] = new Random().nextBoolean();
            if (textvis[i]) {
                animatedText.append(text.charAt(i));
            } else {
                animatedText.append(" ");
            }
            System.out.print("\033[H\033[2J"); // Clear screen
            System.out.flush();
            System.out.println(animatedText.toString());
            Thread.sleep(50); // Adjust the delay to change animation speed
        }
    }
}
