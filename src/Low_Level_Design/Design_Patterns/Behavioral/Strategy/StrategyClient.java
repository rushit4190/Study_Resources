package Low_Level_Design.Design_Patterns.Behavioral.Strategy;

//Navigation App example

// Context class

class NavigationApp {
    private RouteStrategy routeStrategy;

    public void setRouteStrategy(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    public void calculateRoute(String source, String destination) {
        routeStrategy.calculateRoute(source, destination);
    }
}

// Strategy Interface

interface RouteStrategy {
    void calculateRoute(String source, String destination);
}

//Concrete Strategy

class FastestRouteStrategy implements RouteStrategy {
    @Override
    public void calculateRoute(String source, String destination) {
        System.out.println("Calculating fastest route from " + source + " to " + destination);
        // Logic for calculating fastest route
    }
}

class ShortestRouteStrategy implements RouteStrategy {
    @Override
    public void calculateRoute(String source, String destination) {
        System.out.println("Calculating shortest route from " + source + " to " + destination);
        // Logic for calculating shortest route
    }
}

class ScenicRouteStrategy implements RouteStrategy {
    @Override
    public void calculateRoute(String source, String destination) {
        System.out.println("Calculating scenic route from " + source + " to " + destination);
        // Logic for calculating scenic route
    }
}


public class StrategyClient {

    public static void main(String[] args) {
        NavigationApp navigationApp = new NavigationApp();

        navigationApp.setRouteStrategy(new FastestRouteStrategy());
        navigationApp.calculateRoute("A", "B");

        navigationApp.setRouteStrategy(new ShortestRouteStrategy());
        navigationApp.calculateRoute("X", "Y");

        navigationApp.setRouteStrategy(new ScenicRouteStrategy());
        navigationApp.calculateRoute("P", "Q");
    }
}
