package util;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Static class for helpful things
 * like getting user input for strings,
 * integers,
 * and can draw multiple strings with spacing in between.
 * Also can get the mas length of an arraylist of strings.
 */
public class UI {

    /**
     * Private for safety to never make an object of this class.
     */
    private UI() {

    }

    /**
     * Clears the console to prep for a new Screen.
     * ONLY WORKS IN CMD LINE
     */
    public static void clearScreen() {
        /*
        Clear console
         */
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Requests integer from the user.
     * @return int typed.
     */
    public static int getInt() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    /**
     * Finds the longest string in an ArrayList.
     * @param strings
     * @return length of longest string
     */
    public static int getMaxStringLen(ArrayList<String> strings) {
        int counter = 0;
        for (String s: strings) {
            if (s.length() > counter) {
                counter = s.length();
            }
        }
        return counter;
    }

    /**
     * Gets a random integer within bounds of two numbers.
     * Generates new random ints until one is >= minimum bound
     * and <= maximum bound.
     * @param min
     * @param max
     * @return int
     */
    public static int getRandomInt(int min, int max) {
        Random r = new Random();
        int temp = r.nextInt(max);

        boolean outOfBounds = true;
        while (outOfBounds) {
            if (temp < min) {
                temp = r.nextInt(max);
            } else {
                outOfBounds = false;
            }
        }
        return temp;
    }

    /**
     * Requests String from the user.
     * @return String typed.
     */
    public static String getString() {
        Scanner input = new Scanner(System.in);
        return input.next();
    }

    /**
     * Displays each string put into the method.
     * @param strings
     */
    public static void draw(String ...strings) {
        for (String s: strings) {
            System.out.print(s + " ".repeat(6));
        }
        System.out.println();
    }
}
