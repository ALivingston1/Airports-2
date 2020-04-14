import display.screens.AdminScreen;
import display.screens.BuyTicketScreen;
import display.screens.MainScreen;
import system.Airport;
import system.aircraft.airliner.Airliner;
import system.aircraft.cargotransporter.CargoTransporter;
import util.Reference;
import util.UI;

import java.sql.Ref;

/**
 * This programs allows the user to pretend to buy a
 * plane ticket. It also allows the user to view a limit list
 * of airports, get the airport information, and view each airport's
 * aircraft and its information.
 */
public class Main {

    /**
     * Opens the main screen of the program and initializes the system as a whole.
     * @param args
     */
    public static void main(String[] args) {
        initSystem();
        MainScreen main = new MainScreen();
        main.open();
    }

    /**
     * Creates all airports, aircraft, etc. in the system and assigns their values semi-randomly
     */
    public static void initSystem() {
        createAirports();

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

                            rand = UI.getRandomInt(0000, 9999);
                            for (int k = 0; k < Reference.airlineList.length; k++) {
                                if (airliner.getAirline().equalsIgnoreCase(Reference.airlineList[k])) {
                                    airliner.setFlightNumber(Reference.airlineAbbreviation[k] + rand);
                                }
                            }

                            a.addAircraft(airliner);
                            Reference.aircraftList.add(airliner);
                        } else {
                            CargoTransporter cargoTransporter = new CargoTransporter();
                            cargoTransporter.setOrigin(Reference.airports.get(i).getIdentifier());
                            cargoTransporter.setDestination(Reference.airports.get(j).getIdentifier());
                            rand = UI.getRandomInt(0, 1);
                            cargoTransporter.setMake(Reference.make[rand]);
                            rand = UI.getRandomInt(0, 8);
                            cargoTransporter.setModel(Reference.model[rand]);
                            rand = UI.getRandomInt(200, 2000);
                            cargoTransporter.setCapacity(rand);

                            rand = UI.getRandomInt(0000, 9999);
                            int carrier = UI.getRandomInt(0, 1);
                            if (carrier == 0) {
                                cargoTransporter.setFlightNumber("UPS " + rand);
                            } else {
                                cargoTransporter.setFlightNumber("FED-EX ");
                            }

                            a.addAircraft(cargoTransporter);
                            Reference.aircraftList.add(cargoTransporter);
                        }
                    }
                }
            }
        }
    }

    /**
     * Creates new airport objects from the reference list.
     * Each airport has random values assigned to each variable.
     * Adds each airport to an active list of airports.
     */
    private static void createAirports() {
        for (String s : Reference.airportList) {
            Airport temp = new Airport(s);
            int rand = UI.getRandomInt(0, 1);
            if (rand == 0) {
                temp.isTowered(true);
            }
            rand = UI.getRandomInt(50, 300);
            temp.setCapacity(rand);
            Reference.airports.add(temp);
        }
    }
}
