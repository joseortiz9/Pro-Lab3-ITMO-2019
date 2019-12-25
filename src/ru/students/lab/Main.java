package ru.students.lab;

import ru.students.lab.exceptions.NotPerceptiveHumanException;
import ru.students.lab.exceptions.PerceivingCelBodyException;
import ru.students.lab.galaxy.CelestialBody;
import ru.students.lab.galaxy.Galaxy;
import ru.students.lab.living.Human;
import ru.students.lab.living.InterPerception;
import ru.students.lab.living.TypesFeelings;
import ru.students.lab.locationTools.Coordinate;
import ru.students.lab.locationTools.InterLocationUtilities;
import ru.students.lab.locationTools.Place;
import ru.students.lab.sensesTools.CelBodyPerceptionManager;
import ru.students.lab.things.Thing;
import ru.students.lab.things.TypeThings;
import ru.students.lab.timeTools.TimeManager;
import ru.students.lab.vehicles.*;

import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws NotPerceptiveHumanException {
		System.out.println();
		Thing anyFood = new Thing("что-то", TypeThings.FOOD, 5, false, new Coordinate(11, 15));
		Thing computer1 = new Thing("Central Computer", TypeThings.COMPUTER, 1, false, new Coordinate(30, 12));
		Thing panel1 = new Thing("Central Panel", TypeThings.PANEL, 1, false, new Coordinate(30, 10));
		Thing backWindow = new Thing("Back window", TypeThings.WINDOW, 1, true, new Coordinate(-60, 0));
		Thing frontWindow1 = new Thing("Sun Window", TypeThings.WINDOW, 1, true, new Coordinate(40, 10));
		Thing frontWindow2 = new Thing("Front Window", TypeThings.WINDOW, 1, true, new Coordinate(60, 0));
		Thing frontWindow3 = new Thing("Front Window", TypeThings.WINDOW, 1, true, new Coordinate(60, -1));

		Place astronomicRoom = new Place("астрономическая");
		astronomicRoom.addThing(computer1);
		astronomicRoom.addThing(panel1);
		astronomicRoom.addThing(frontWindow1);
		astronomicRoom.addThing(frontWindow2);
		astronomicRoom.addThing(frontWindow3);
		Place dinningRoom = new Place("пищевой отсек");
		dinningRoom.addThing(anyFood);
		Place machinesRoom = new Place("машинный зал");
		machinesRoom.addThing(backWindow);

		Galaxy milkyWay = new Galaxy("Млечный путь", Galaxy.Colors.BLACK);
		Trajectory earthToMoon = new Trajectory(milkyWay.getCelestialBody("Земля"), milkyWay.getCelestialBody("Луна"));

		Rocket rocket = new Rocket(TypeVehicles.ROCKET, 12, earthToMoon);
		rocket.addRoom(astronomicRoom);
		rocket.addRoom(dinningRoom);
		rocket.addRoom(machinesRoom);


		class PerceptiveHuman extends Human implements InterPerception {
			private CelBodyPerceptionManager celBodyPerceptionManager;
			public PerceptiveHuman(String name, Place place, int timeLastFood, boolean awake, Coordinate location) {
				super(name, place, timeLastFood, awake, location);
				this.celBodyPerceptionManager = null;
			}
			@Override
			public void perceiveSize(CelestialBody celBody) {
				try {
					this.celBodyPerceptionManager = new CelBodyPerceptionManager(this, celBody);
					System.out.println(celBodyPerceptionManager.getPerceptionOfSize());

				} catch (PerceivingCelBodyException e) {
					System.out.println(this.getName() + "can not perceive size of " + celBody.toString() +
							" because " + e.getMessage());
				}
			}
			@Override
			public void perceiveDetails(CelestialBody celBody) {
				try {
					this.celBodyPerceptionManager = new CelBodyPerceptionManager(this, celBody);
					this.celBodyPerceptionManager.perceiveDetails();

				} catch (PerceivingCelBodyException e) {
					System.out.println(this.getName() + "can not perceive details of " + celBody.toString() +
							" because " + e.getMessage());
				}
			}
			@Override
			public void perceiveMovement(AbsVehicle vehicle) {
				if (vehicle.getMovingState().equals(MovingState.SLOW) || vehicle.getMovingState().equals(MovingState.STAGNATION)) {
					//this.feels(TypesFeelings.STAGNATION);
					if (!vehicle.isVelocityBig())
						System.out.println("Velocity is not fast enough");
					System.out.println(this.getName() + " perceives " + vehicle.getTypeVehicles().toString() + " is " + MovingState.STAGNATION);
				}
			}

		}

		PerceptiveHuman unknown = new PerceptiveHuman("Незнайка", astronomicRoom, 2, true, new Coordinate(30, 0));
		PerceptiveHuman dunno = new PerceptiveHuman("Пончик", dinningRoom, -5, true, new Coordinate(10, 15));


		rocket.starts();
		rocket.printTrajectory();
		TimeManager.printActualPartDay();
		dunno.feels(TypesFeelings.TRAPPED);
		dunno.searchExit();
		TimeManager.addTimElapsed(7);
		rocket.moveForward(7);


		final InterLocationUtilities centerRocket = new InterLocationUtilities() {
			@Override
			public Coordinate getLocation() {
				return new Coordinate(0,0);
			}
		};

		unknown.moves(dinningRoom, centerRocket.getLocation());
		unknown.said(dunno, "go to rest");
		dunno.setAwake(false);
		unknown.moves(astronomicRoom, new Coordinate(30,0));
		System.out.println("on the window all was dark and full of stars..");
		unknown.sees(milkyWay.getCelestialBody("Cолнце"));


		class ClassPerceptiveChecker {
			private Class classToCheck;
			public ClassPerceptiveChecker(Class classToCheck) {
				this.classToCheck = classToCheck;
			}
			public boolean checkPerceptiveMethods() throws NoSuchMethodException {
				Method[] methods = classToCheck.getDeclaredMethods();
				for (Method method: methods) {
					if (method.getName().equals("perceiveSize"))
						return true;
				}
				return false;
			}
		}

		try {
			ClassPerceptiveChecker checker = new ClassPerceptiveChecker(unknown.getClass());
			if (checker.checkPerceptiveMethods()) {
				unknown.perceiveSize(milkyWay.getCelestialBody("Cолнце"));
				unknown.perceiveSize(milkyWay.getCelestialBody("Луна"));

				unknown.perceiveDetails(milkyWay.getCelestialBody("Луна"));
				unknown.feels(TypesFeelings.DOUBTFUL);

				System.out.println();
				unknown.perceiveMovement(rocket);
			}
			else
				throw new NotPerceptiveHumanException();
		} catch (NotPerceptiveHumanException e) {
			System.out.println(unknown.getName() + e.getMessage());
		} catch (NoSuchMethodException e) {
			System.out.println(e.getMessage());
		}


		rocket.printLocation();

		unknown.sees(milkyWay.getCelestialBody("Луна"));
		unknown.feels(TypesFeelings.INTEREST);

		TimeManager.addTimElapsed(1);
		rocket.moveForward(1);
		rocket.printMovement();
	    if (TimeManager.getTimeElapsed() > 2) {
	    	unknown.timeToEat();
			unknown.moves(dinningRoom, new Coordinate(0,0));
			dunno.wakesUp();
			unknown.sees(dunno);
			dunno.eats(anyFood);
		}
    }
}
