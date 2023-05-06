package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class RoutesFrom {
    private RoutesRepository routesRepository;

    public RoutesFrom(RoutesRepository routesRepository) {
        this.routesRepository = routesRepository;
    }

    public List<Airport> routeFrom(Airport airportd, int mode) throws NoAirportException{
        List<Airport> destinationAirports = routesRepository.availableRoutes()
                .stream()
                .filter(routes -> routes.getDeparture().getName().equals(airportd.getName()))
                .map(Routes::getDestination)
                .collect(Collectors.toList());

        if(mode==1){
            if(destinationAirports.size() == 0){
                throw new NoAirportException("\nBrak lotnisk docelowych!\n");
            }
            System.out.print("Lotniska docelowe z lotniska " + airportd.getName() + " to: ");
            for (Airport destinationAirport :destinationAirports ) {
                System.out.print(destinationAirport.getName() + " ");
            }
            System.out.println("\n");
        }
        return destinationAirports;
    }
}
