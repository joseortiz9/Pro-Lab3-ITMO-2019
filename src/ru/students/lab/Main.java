package ru.students.lab;

public class Main {

    public static void main(String[] args) {
		System.out.println();
		Thing anyFood = new Thing("что-то", TypeThings.FOOD, 5);
		Place controlRoom = new Place("диспетчерская");
		Place dinningRoom = new Place("пищевой отсек");
		dinningRoom.addThing(anyFood);
		Trajectory earthToMoon = new Trajectory(Planets.EARTH, Planets.MOON);
		Rocket rocket = new Rocket(TypeVehicles.ROCKET, 12, earthToMoon);
		rocket.addRoom(controlRoom);
		rocket.addRoom(dinningRoom);
		Human unknown = new Human("Незнайка", controlRoom, 5);
		Human dunno = new Human("Пончик", dinningRoom, -5, false);

		unknown.printStatus();
		rocket.starts();
		rocket.printTrajectory();
		unknown.printLocation();
		if (!rocket.isVelocityBig()) {
			unknown.sees(rocket.getVelocity(), null);
			rocket.printLocation();
		}
		unknown.sees(Planets.MOON, null);
		//unknown.sees(Planets.Moon, dunno);
		int timeElapsedOfTravel = 9;
		rocket.addTimElapsed(timeElapsedOfTravel);
		rocket.printMovement();
	    if (rocket.getTimElapsed() > (2*3600)) {
			if (unknown.isTimeToEat(timeElapsedOfTravel))
				unknown.feels(TypesFeelings.HUNGER);
			unknown.moves(dinningRoom);
			dunno.wakesUp();
			unknown.sees(dunno, null);
			dunno.eats(anyFood);
		}
    }
}
