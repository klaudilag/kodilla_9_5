package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoutesThrough {
    private RoutesRepository routesRepository;

    public RoutesThrough(RoutesRepository routesRepository) {
        this.routesRepository = routesRepository;
    }
    public void routesThrough(Airport airport) throws NoAirportException{
        RoutesTo routesTo = new RoutesTo(new RoutesRepositoryClass());
        RoutesFrom routesFrom = new RoutesFrom(new RoutesRepositoryClass());
        List<Airport> firstAirports = new ArrayList<>();
        firstAirports = routesTo.routeTo(airport,0);
        List<Airport> LastAirports = new ArrayList<>();
        LastAirports = routesFrom.routeFrom(airport,0);
        if(firstAirports.size() == 0 || LastAirports.size() == 0){
            throw new NoAirportException("\nBrak Mozliwosci wyznaczenia trasy dla lotniska " + airport.getName()+ "! \nLotnisko nie może być lotniskiem tranzytowym");
        }
        System.out.println("Możliwe jest by " + airport.getName() + " Było lotniskiem tranzytowym. ");
        System.out.println("Cała trasa wyglądałaby wtedy np. tak ");
        for (int i = 0; i < firstAirports.size(); i++) {
            System.out.println(firstAirports.get(i).getName() + "->" + airport.getName() + "->" + LastAirports.get(i).getName());
        }
        }
    }


