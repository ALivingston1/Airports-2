package system.aircraft;

/**
 * An aircraft must have a make,
 * model, weight capacity,
 * dep Airport and arrival airport,
 * and a flight number number
 */
public interface IAircraft {
    String getMake();

    String getModel();

    double getWeightCapacity();

    String getOrigin();

    String getDestination();

    String getFlightNumber();
}
