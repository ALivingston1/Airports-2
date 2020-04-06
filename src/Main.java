import display.screens.AdminScreen;
import display.screens.BuyTicketScreen;
import display.screens.MainScreen;
import system.Airport;
import system.aircraft.airliner.Airliner;
import system.aircraft.cargotransporter.CargoTransporter;
import util.Reference;
import util.UI;

public class Main {
    public static void main(String[] args) {
        initSystem();
        MainScreen main = new MainScreen();
        main.open();
    }

    public static void initSystem() {
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

                            a.addAircraft(cargoTransporter);
                            Reference.aircraftList.add(cargoTransporter);
                        }
                    }
                }
            }
        }
    }
}
