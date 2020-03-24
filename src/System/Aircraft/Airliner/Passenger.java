package System.Aircraft.Airliner;

import java.util.ArrayList;

public class Passenger implements IPerson {
    private String name;
    private boolean ginger;
    private String seat;

    private ArrayList<Luggage> luggage;


    Passenger(String name,boolean ginger,String seat,int luggage){
        this.name=name;
        this.ginger=ginger;
        this.seat=seat;
        
    }



    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isGing() {
        return ginger;
    }

    public String getSeat(){
        return seat;
    }

}
