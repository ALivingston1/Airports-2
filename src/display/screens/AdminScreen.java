package display.screens;

import display.components.AbstractScreen;

public class AdminScreen extends AbstractScreen {

    public AdminScreen() {}

    @Override
    public void open() {
        System.out.println("Welcome to the god screen.\n");

        System.out.println("What would you like to do?");
        draw("Add", "Remove", "View", "Exit");
    }

    private void draw(String ...strings) {
        for (String s: strings) {
            System.out.print(s + " ".repeat(6));
        }
    }
}
