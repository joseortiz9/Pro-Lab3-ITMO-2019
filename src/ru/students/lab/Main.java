package ru.students.lab;

public class Main {

    public static void main(String[] args) {
	    System.out.println();
        Thing donnut = new Thing("что-то", "food");
	    Place controlRoom = new Place("диспетчерская");
	    Place dinningRoom = new Place("пищевой отсек");
	    dinningRoom.addThing(donnut);
	    Vehicle rocket = new Vehicle(TypeVehicle.Rocket, 12);
	    rocket.addRoom(controlRoom);
	    rocket.addRoom(dinningRoom);
	    Human unknown = new Human("Незнайка", controlRoom);
	    Human dunno = new Human("Пончик", dinningRoom, false);

	    rocket.starts();
	    unknown.printLocation();
	    unknown.sees(Planets.Moon);
	    unknown.usesOrgan(Organs.Eyes);
	    //if (rocket.getActualTime() > 2)
	    	unknown.usesOrgan(Organs.Stomach);
	    unknown.moves(dinningRoom);
		dunno.wakeUp();
	    unknown.sees(dunno);
	    dunno.eats(donnut);
    }
}
