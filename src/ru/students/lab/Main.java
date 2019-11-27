package ru.students.lab;

import ru.students.lab.living.Human;
import ru.students.lab.living.TypesFeelings;
import ru.students.lab.locationTools.Coordinate;
import ru.students.lab.locationTools.Place;
import ru.students.lab.planets.Planet;
import ru.students.lab.planets.TypePlanets;
import ru.students.lab.things.Thing;
import ru.students.lab.things.TypeThings;
import ru.students.lab.vehicles.MovingState;
import ru.students.lab.vehicles.Rocket;
import ru.students.lab.vehicles.Trajectory;
import ru.students.lab.vehicles.TypeVehicles;

public class Main {

    public static void main(String[] args) {
		System.out.println();
		Thing anyFood = new Thing("что-то", TypeThings.FOOD, 5, true, new Coordinate(11, 15));
		Thing computer1 = new Thing("Central Computer", TypeThings.COMPUTER, 1, false, new Coordinate(30, 12));
		Thing panel1 = new Thing("Central Panel", TypeThings.PANEL, 1, false, new Coordinate(30, 10));
		Thing backWindow = new Thing("Back window", TypeThings.WINDOW, 1, false, new Coordinate(-60, 0));
		Thing frontWindow1 = new Thing("Front Window", TypeThings.WINDOW, 1, true, new Coordinate(60, 1));
		Thing frontWindow2 = new Thing("Front Window", TypeThings.WINDOW, 1, true, new Coordinate(60, 0));
		Thing frontWindow3 = new Thing("Front Window", TypeThings.WINDOW, 1, true, new Coordinate(60, -1));

		Place controlRoom = new Place("диспетчерская");
		controlRoom.addThing(computer1);
		controlRoom.addThing(panel1);
		controlRoom.addThing(frontWindow1);
		controlRoom.addThing(frontWindow2);
		controlRoom.addThing(frontWindow3);
		Place dinningRoom = new Place("пищевой отсек");
		dinningRoom.addThing(anyFood);
		Place machinesRoom = new Place("машинный зал");
		machinesRoom.addThing(backWindow);

		Planet earth = new Planet(TypePlanets.EARTH, new Coordinate(-61, 0));
		Planet moon = new Planet(TypePlanets.MOON, new Coordinate(400000, 0));
		Trajectory earthToMoon = new Trajectory(earth, moon);

		Rocket rocket = new Rocket(TypeVehicles.ROCKET, 12, earthToMoon);
		rocket.addRoom(controlRoom);
		rocket.addRoom(dinningRoom);
		rocket.addRoom(machinesRoom);

		Human unknown = new Human("Незнайка", controlRoom, 2, new Coordinate(30, 0));
		Human dunno = new Human("Пончик", dinningRoom, -5, false, new Coordinate(10, 15));

		unknown.printStatus();
		rocket.starts();
		rocket.printTrajectory();
		unknown.printLocation();
		if (rocket.getMovingState().equals(MovingState.SLOW) || rocket.getMovingState().equals(MovingState.STAGNATION)) {
			unknown.feels(TypesFeelings.STAGNATION);
			System.out.println(unknown.getName() + " thinks " + rocket.getTypeVehicles().toString() + " has " + MovingState.STAGNATION + " velocity");
			rocket.printLocation();
		}


		//unknown.sees(earth);
		unknown.feels(TypesFeelings.INTEREST);

		int timeElapsedOfTravel = 7;
		rocket.addTimElapsed(timeElapsedOfTravel);
		rocket.printMovement();
	    if (rocket.getTrajectory().getTimElapsed() > (2*3600)) {
	    	unknown.timeToEat(timeElapsedOfTravel);
			unknown.moves(dinningRoom, new Coordinate(0,0));
			dunno.wakesUp();
			unknown.sees(dunno);
			dunno.eats(anyFood);
		}
    }
}
