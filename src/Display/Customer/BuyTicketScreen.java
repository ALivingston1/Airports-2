package Display.Customer;

import Display.BoxedScreen;

import java.util.Scanner;

public class BuyTicketScreen extends BoxedScreen {
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
