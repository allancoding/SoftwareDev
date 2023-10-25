package Tests;

import jcurses.*;


public class jcurses {

  public static void main(String[] args) {
    // Create a new curses window
    Window window = new Window(10, 20, 30, 40);

    // Write some text to the window
    window.write("Hello, world!");

    // Refresh the window
    window.refresh();
  }
}

