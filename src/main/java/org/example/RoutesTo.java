package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class RoutesTo {
    private RoutesRepository routesRepository;

    public RoutesTo(RoutesRepository routesRepository) {
        this.routesRepository = routesRepository;
    }
    public List<Airport> routeTo(Airport airportd, int mode) throws NoAirportException{
        List<Airport> departureAirports = routesRepository.availableRoutes()
                .stream()
                .filter(routes -> routes.getDestination().getName().equals(airportd.getName()))
                .map(Routes::getDeparture)
                .collect(Collectors.toList());
        if(mode == 1){
            if(departureAirports.size()==0){
                throw new NoAirportException("\nBrak lotnisk!\n");
            }
            System.out.print("lotniska, z których możesz dolecieć do " + airportd.getName() + " to: ");
            for (Airport airport: departureAirports) {
                System.out.print(airport.getName() + " ");
            }
            System.out.println("\n");
        }
        return departureAirports;
    }

}
