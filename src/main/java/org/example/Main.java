package org.example;

public class Main {
    public static void main(String[] args) {
        Airport airport = new Airport("Warsaw");
        Airport airport1 = new Airport("Tokio");
        RoutesFrom routesFrom = new RoutesFrom(new RoutesRepositoryClass());
        try{
            routesFrom.routeFrom(airport,1);
        } catch (NoAirportException e){
            System.out.println(e.getMessage());
        }
        RoutesTo routesTo = new RoutesTo(new RoutesRepositoryClass());
        try{
            routesTo.routeTo(airport,1);
        } catch (NoAirportException e){
            System.out.println(e.getMessage());
        }
        RoutesThrough routesThrough = new RoutesThrough(new RoutesRepositoryClass());
        try{
            routesThrough.routesThrough(airport);
            routesThrough.routesThrough(airport1);
        } catch(NoAirportException e){
            System.out.println(e.getMessage());
        }
    }
}