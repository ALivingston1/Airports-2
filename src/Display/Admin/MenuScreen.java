package Display.Admin;

import Display.IDisplay;

import java.util.Scanner;

public class MenuScreen implements IDisplay {
    private Scanner input;

    public MenuScreen() {
        input = new Scanner(System.in);
    }

    @Override
    public void open() {
        /*
        Clear console
         */
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("Welcome to the god screen.\n");

        System.out.println("What would you like to do?");
        draw("Add", "Remove", "View", "Exit");
    }

    @Override
    public int getInt() {
        return input.nextInt();
    }

    @Override
    public String getString() {
        return input.next();
    }

    @Override
    public void draw(String ...strings) {
        for (String s: strings) {
            System.out.print(s + " ".repeat(6));
        }
    }
}
