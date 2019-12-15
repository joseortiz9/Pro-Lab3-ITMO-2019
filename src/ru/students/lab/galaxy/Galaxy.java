package ru.students.lab.galaxy;

import ru.students.lab.locationTools.Coordinate;
import ru.students.lab.vehicles.Trajectory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Galaxy {
    private static final ArrayList<CelestialBody> components;
    private static HashMap<String, Integer> initialDistPerceived; //Initial Distances from observer to all components
    public enum Colors { BLUE, BLACK, WHITE };
    private String name;
    private Colors spaceColor;

    public Galaxy(String name, Colors color) {
        this.name = name;
        this.spaceColor = color;
    }

    public CelestialBody getCelestialBody(String name) {
        for (CelestialBody celBody : getComponents())
            if (celBody.getName().equals(name))
                return celBody;
        return null;
    }

    public static void updatePosComponents(int newDistance, CelestialBody destiny) {
        for (CelestialBody celBody : components)
            if (!celBody.equals(destiny))
                celBody.getLocation().addX(newDistance);
    }

    public String getName() {
        return name;
    }

    public Colors getSpaceColor() {
        return spaceColor;
    }

    public static ArrayList<CelestialBody> getComponents() {
        return components;
    }

    public static HashMap<String, Integer> getInitialDistPerceived() {
        return initialDistPerceived;
    }

    static {
        components = new ArrayList<>();
        components.add(new CelestialBody("Земля", TypeCelestialBodies.PLANET, new Coordinate(-61, 0)));
        components.add(new CelestialBody("Луна", TypeCelestialBodies.PLANET, new Coordinate(400000, 0)));
        components.add(new CelestialBody("Cолнце", TypeCelestialBodies.STAR, new Coordinate(150000030, 150000000)));
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            Coordinate randCoord = new Coordinate(Math.pow(-1,i) * (rand.nextInt(150000) + 100), Math.pow(-1,i) * (rand.nextInt(150000) + 100));
            components.add(new CelestialBody("Star#" + i, TypeCelestialBodies.STAR, randCoord));
        }

        initialDistPerceived = new HashMap<>();
        for (CelestialBody celBody : components)
            initialDistPerceived.putIfAbsent(celBody.getName(), Trajectory.calcDisFromObserver(celBody));
    }
}
