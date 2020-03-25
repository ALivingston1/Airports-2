package display.customer;

import display.components.BoxedScreen;

import java.util.Scanner;

public class BuyTicketScreen extends BoxedScreen {
    private Scanner input;

    public BuyTicketScreen() {
        input = new Scanner(System.in);
    }

    @Override
    public void open() {

    }
}
