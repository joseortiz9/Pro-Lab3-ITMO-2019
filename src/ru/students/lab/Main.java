package ru.students.lab;

public class Main {

    public static void main(String[] args) {
	    System.out.println();
        Thing anyFood = new Thing("что-то", "food");
	    Place controlRoom = new Place("диспетчерская");
	    Place dinningRoom = new Place("пищевой отсек");
	    dinningRoom.addThing(anyFood);
	    Trajectory earthToMoon = new Trajectory(Planets.Earth, Planets.Moon);
	    Rocket rocket = new Rocket(TypeVehicle.Rocket, 12, earthToMoon);
	    rocket.addRoom(controlRoom);
	    rocket.addRoom(dinningRoom);
	    Human unknown = new Human("Незнайка", controlRoom);
	    Human dunno = new Human("Пончик", dinningRoom, false);

	    rocket.starts();
	    unknown.printLocation();
	    unknown.sees(Planets.Moon);
	    unknown.usesOrgan(Organs.Eyes);
	    rocket.addTimElapsed(3);
		rocket.printMovement();
		rocket.printTrajectory();
	    unknown.knows(false);
		rocket.isNearDestiny();
	    if (rocket.getTimElapsed() > (2*60))
	    	unknown.usesOrgan(Organs.Stomach);
	    unknown.moves(dinningRoom);
		dunno.wakeUp();
	    unknown.sees(dunno);
	    dunno.eats(anyFood);
    }
}
