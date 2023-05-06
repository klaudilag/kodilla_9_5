package org.example;

import java.util.ArrayList;

public class RoutesRepositoryClass implements RoutesRepository{

    @Override
    public ArrayList<Routes> availableRoutes() {
        Airport airport = new Airport("Gdansk");
        Airport airport1 = new Airport("Warsaw");
        Airport airport2 = new Airport("Paris");
        Airport airport3 = new Airport("London");
        Airport airport4 = new Airport("Tokio");

        Routes routes = new Routes(airport1, airport2);
        Routes routes1 = new Routes(airport1, airport3);
        Routes routes2 = new Routes(airport3,airport);
        Routes routes3 = new Routes(airport3, airport1);
        Routes route4 = new Routes(airport, airport1);

        ArrayList<Routes> routesList = new ArrayList<>();
        routesList.add(routes);
        routesList.add(routes1);
        routesList.add(routes2);
        routesList.add(routes3);
        routesList.add(route4);
        return routesList;
    }
}
