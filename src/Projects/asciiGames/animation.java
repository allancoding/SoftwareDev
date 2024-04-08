package Projects.asciiGames;

public class animation {
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
                ascii.clear();
                System.out.flush();
            }
            for (String line : frames) {
                ascii.print("\033[" + i + "D");
                if (frameWidth - i > 0) {
                    ascii.print(line.substring(frameWidth - i));
                }
                ascii.println("");
            }
            ascii.wait(10);
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
                ascii.clear();
                System.out.flush();
                ascii.print("\033[" + (lineIndex + 1) + ";1H");
                if (frameWidth - i > 0 && frameHeight - lineIndex > 0) {
                    ascii.print(frames[lineIndex].substring(frameWidth - i));
                }
                ascii.println("");
                for (int j = lineIndex + 1; j < frameHeight; j++) {
                    ascii.print(frames[j]);
                    ascii.println("");
                }
                ascii.wait(10);
            }
        }
    }
    public static void show() throws InterruptedException {
        String[] frames = {
            "     ___                              ______                                 __",
            "    /   |  _____ _____  (_)  (_)     / ____/ ____ _  ____ ___  ___   _____  / /",
            "   / /| | /  __// ___/ / /  / /     / / __  / __ `/ / __ `__ \\/ _ \\ / ___/ / / ",
            "  / ___ |(__  )/ /__  / /  / /     / /_/ / / /_/ / / / / / / /  __/(__  ) /_/  ",
            " /_/  |_/____/ \\___/ /_/  /_/      \\____/  \\__,_/ /_/ /_/ /_/\\___//____/ (_)   "
        };
        ascii.clear();
        System.out.flush();
        for (String line : frames) {
            System.out.println(line);
        }
    }
}
