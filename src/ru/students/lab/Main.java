package ru.students.lab;

public class Main {

    public static void main(String[] args) {
		System.out.println();
		Thing anyFood = new Thing("что-то", TypeThings.Food, 5);
		Place controlRoom = new Place("диспетчерская");
		Place dinningRoom = new Place("пищевой отсек");
		dinningRoom.addThing(anyFood);
		Trajectory earthToMoon = new Trajectory(Planets.Earth, Planets.Moon);
		Rocket rocket = new Rocket(TypeVehicles.Rocket, 12, earthToMoon);
		rocket.addRoom(controlRoom);
		rocket.addRoom(dinningRoom);
		Human unknown = new Human("Незнайка", controlRoom, 2);
		Human dunno = new Human("Пончик", dinningRoom, 5, false);

		unknown.showStatus();
		rocket.starts();
		rocket.printTrajectory();
		unknown.printLocation();
		if (!rocket.isVelocityBig()) {
			unknown.sees(rocket.getVelocity(), null);
			rocket.printLocation();
		}
		unknown.sees(Planets.Moon, null);
		//unknown.sees(Planets.Moon, dunno);
		int timeElapsedOfTravel = 3;
		rocket.addTimElapsed(timeElapsedOfTravel);
		rocket.printMovement();
	    if (rocket.getTimElapsed() > (2*3600)) {
			if (unknown.isTimeToEat(timeElapsedOfTravel))
				unknown.feels(Feelings.Hunger);
			unknown.moves(dinningRoom);
			dunno.wakesUp();
			unknown.sees(dunno, null);
			dunno.eats(anyFood);
		}
    }
}
