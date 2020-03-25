package util;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {

    private UI() {

    }

    public static int getInt() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public static String getString() {
        Scanner input = new Scanner(System.in);
        return input.next();
    }

    public static int getMaxStringLen(ArrayList<String> strings) {
        int counter = 0;
        for (String s: strings) {
            if (s.length() > counter) {
                counter = s.length();
            }
        }
        return counter;
    }
}
