package org.example;

public class Main {
    public static void main(String[] args) {
        Airport airport = new Airport("Warsaw");
        Airport airport1 = new Airport("Tokio");
        RoutesProcessor routesProcessor = new RoutesProcessor(new RoutesRepositoryClass());
        try{
            routesProcessor.routeFrom(airport,true);
        } catch (NoAirportException e){
            System.out.println(e.getMessage());
        }
        try{
            routesProcessor.routeFrom(airport1,true);
        } catch(NoAirportException e){
            System.out.println(e.getMessage());
        }
        try{
            routesProcessor.routeTo(airport,true);
        } catch(NoAirportException e){
            System.out.println(e.getMessage());
        }
        try{
            routesProcessor.routeTo(airport1, true);
        } catch(NoAirportException e){
            System.out.println(e.getMessage());
        }
        try{
            routesProcessor.routesThrough(airport);
        }catch(NoAirportException e){
            System.out.println(e.getMessage());
        }
        try{
            routesProcessor.routesThrough(airport1);
        } catch(NoAirportException e){
            System.out.println(e.getMessage());
        }
    }
}