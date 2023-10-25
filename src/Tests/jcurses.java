package Tests;

import jcurses.widgets.Window;

public class jcurses {

    public static void main(String[] args) {
        // Create a new curses window
        Window window = new Window(80, 24, true, "Hello World");

        // Update the screen
        window.show();
    }
}

