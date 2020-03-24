package Display;

import java.util.Scanner;

public class BuyTicketScreen implements IDisplay {
    private Scanner input;

    public BuyTicketScreen() {
        input = new Scanner(System.in);
    }

    @Override
    public void open() {

    }

    @Override
    public int getInt() {
        return input.nextInt();
    }

    @Override
    public String getString() {
        return input.next();
    }
}
