package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoutesProcessor {
    private RoutesRepository routesRepository;

    public RoutesProcessor(RoutesRepository routesRepository) {
        this.routesRepository = routesRepository;
    }

    public List<Airport> routeFrom(Airport airportd, boolean printOrNot) throws NoAirportException{
        List<Airport> destinationAirports = routesRepository.availableRoutes()
                .stream()
                .filter(routes -> routes.getDeparture().getName().equals(airportd.getName()))
                .map(Routes::getDestination)
                .collect(Collectors.toList());

        if(printOrNot){
            if(destinationAirports.size() == 0){
                throw new NoAirportException("\nBrak lotnisk docelowych z lotniska: " + airportd.getName() +"\n");
            }
            System.out.print("Lotniska docelowe z lotniska " + airportd.getName() + " to: ");
            for (Airport destinationAirport :destinationAirports ) {
                System.out.print(destinationAirport.getName() + " ");
            }
            System.out.println("\n");
        }
        return destinationAirports;
    }

    public void routesThrough(Airport airport) throws NoAirportException{
        List<Airport> firstAirports = new ArrayList<>();
        firstAirports = routeTo(airport,false);
        List<Airport> LastAirports = new ArrayList<>();
        LastAirports = routeFrom(airport,false);
        if(firstAirports.size() == 0 || LastAirports.size() == 0){
            throw new NoAirportException("\nBrak Mozliwosci wyznaczenia trasy dla lotniska " + airport.getName()+ "! \nLotnisko nie może być lotniskiem tranzytowym");
        }
        System.out.println("Możliwe jest by " + airport.getName() + " Było lotniskiem tranzytowym. ");
        System.out.println("Cała trasa wyglądałaby wtedy np. tak ");
        for (int i = 0; i < firstAirports.size(); i++) {
            System.out.println(firstAirports.get(i).getName() + "->" + airport.getName() + "->" + LastAirports.get(i).getName());
        }
    }
    public List<Airport> routeTo(Airport airportd, boolean printOrNot) throws NoAirportException{
        List<Airport> departureAirports = routesRepository.availableRoutes()
                .stream()
                .filter(routes -> routes.getDestination().getName().equals(airportd.getName()))
                .map(Routes::getDeparture)
                .collect(Collectors.toList());
        if(printOrNot){
            if(departureAirports.size()==0){
                throw new NoAirportException("\nBrak lotnisk, z których możesz dolecieć do "+airportd.getName()+"!\n");
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
