package org.example;

public class Routes {
    private Airport Departure;
    private Airport Destination;

    public Routes(Airport departure, Airport destination) {
        Departure = departure;
        Destination = destination;
    }

    public Airport getDeparture() {
        return Departure;
    }

    public Airport getDestination() {
        return Destination;
    }

    @Override
    public String toString() {
        return getDeparture() + "->" + getDestination();
    }
}
