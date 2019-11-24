package ru.students.lab;

public class Main {

    public static void main(String[] args) {
		System.out.println();
		Thing anyFood = new Thing("что-то", "food", 5);
		Place controlRoom = new Place("диспетчерская");
		Place dinningRoom = new Place("пищевой отсек");
		dinningRoom.addThing(anyFood);
		Trajectory earthToMoon = new Trajectory(Planets.Earth, Planets.Moon);
		Rocket rocket = new Rocket(TypeVehicle.Rocket, 12, earthToMoon);
		rocket.addRoom(controlRoom);
		rocket.addRoom(dinningRoom);
		Human unknown = new Human("Незнайка", controlRoom, true, false);
		Human dunno = new Human("Пончик", dinningRoom, false, true);

		unknown.showStatus();
		rocket.starts();
		rocket.printTrajectory();
		if (!rocket.isVelocityBig() && unknown.isAwake()) {
			unknown.thinks(rocket.isNearDestiny());
			unknown.sees("like the "+ rocket.getTypeVehicle().toString() +" has no velocity");
		}
		unknown.printLocation();
		if (unknown.isAwake()) {
			unknown.sees(Planets.Moon);
			unknown.usesOrgan(Organs.Eyes);
		}
		rocket.addTimElapsed(3);
		rocket.printMovement();
	    if (rocket.getTimElapsed() > (2*3600)) {
			unknown.changeHungry();
			unknown.usesOrgan(Organs.Stomach);
			unknown.wakeUp();
			unknown.moves(dinningRoom);
			dunno.wakeUp();
			unknown.sees(dunno);
			dunno.eats(anyFood);
		}
    }
}
