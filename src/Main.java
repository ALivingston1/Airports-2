import display.screens.AdminScreen;
import display.screens.BuyTicketScreen;
import system.Airport;
import system.aircraft.airliner.Airliner;
import system.aircraft.cargotransporter.CargoTransporter;
import util.Reference;
import util.UI;

public class Main {
    public static void main(String[] args) {
        initSystem();

        System.out.println("Which screen would you like to enter?");
        System.out.println("(1) Customer" + " ".repeat(6) + "(2) Admin" + " ".repeat(6) + "(3) Exit");

        getResponse();
    }

    public static void getResponse() {
        String response = UI.getString();

        if (response.equalsIgnoreCase("Customer") || response.equalsIgnoreCase("1")) {
            BuyTicketScreen screen = new BuyTicketScreen();
            screen.open();
        } else if (response.equalsIgnoreCase("Admin") || response.equalsIgnoreCase("2")) {
            AdminScreen screen = new AdminScreen();
            screen.open();
        } else if (response.equalsIgnoreCase("Exit") || response.equalsIgnoreCase("3")) {
            System.out.println("Closing...");
        } else {
            System.out.println("Please type a valid response.");
            getResponse();
        }
    }

    public static void initSystem() {
        for (String s : Reference.airportList) {
            Reference.airports.add(new Airport(s));
        }

        for (Airport a : Reference.airports) {
            for (int i = 0; i < Reference.airports.size(); i++) {
                for (int j = 0; j < Reference.airports.size(); j++) {
                    if (i != j) {

                        /*
                        Creates at random an airliner or cargo going to and from an airport
                         */
                        int rand = UI.getRandomInt(0, 1);
                        if (rand == 0) {
                            Airliner airliner = new Airliner();
                            airliner.setOrigin(Reference.airports.get(i).getIdentifier());
                            airliner.setDestination(Reference.airports.get(j).getIdentifier());
                            rand = UI.getRandomInt(0, Reference.airlineList.length - 1);
                            airliner.setAirline(Reference.airlineList[rand]);
                            rand = UI.getRandomInt(0, 1);
                            airliner.setMake(Reference.make[rand]);
                            rand = UI.getRandomInt(0, 8);
                            airliner.setModel(Reference.model[rand]);
                            rand = UI.getRandomInt(110, 200);
                            airliner.setPassengerCapacity(rand);

                        } else {
                            CargoTransporter cargoTransporter = new CargoTransporter();
                            cargoTransporter.setOrigin(Reference.airports.get(i).getIdentifier());
                            cargoTransporter.setDestination(Reference.airports.get(j).getIdentifier());
                            rand = UI.getRandomInt(0, 1);
                            cargoTransporter.setMake(Reference.make[rand]);
                            rand = UI.getRandomInt(0, 8);
                            cargoTransporter.setModel(Reference.model[rand]);
//                            rand = UI.getRandomInt(110, 200);
//                            cargoTransporter.setCapacity(rand);
                        }
                    }
                }
            }
        }
    }
}
