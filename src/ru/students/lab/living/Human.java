package ru.students.lab.living;

import ru.students.lab.exceptions.PerceivingCelBodyException;
import ru.students.lab.exceptions.ProblemSeeingObjException;
import ru.students.lab.galaxy.CelestialBody;
import ru.students.lab.locationTools.Coordinate;
import ru.students.lab.locationTools.InterLocationUtilities;
import ru.students.lab.locationTools.Place;
import ru.students.lab.sensesTools.CelBodyPerceptionManager;
import ru.students.lab.sensesTools.VisionManager;
import ru.students.lab.things.Thing;
import ru.students.lab.things.TypeThings;
import ru.students.lab.timeTools.TimeManager;
import ru.students.lab.vehicles.AbsVehicle;
import ru.students.lab.vehicles.MovingState;

public class Human implements InterCreature, InterBasicActions, /*InterPerception,*/ InterLocationUtilities {

    private String name;
    private int timeLastFood;
    private TypesFeelings mood;
    private Place actualPlace;
    private Coordinate location;
    private boolean awake;
    private VisionManager visionManager;
    //private boolean perceptive;
    //private CelBodyPerceptionManager celBodyPerceptionManager;

    public Human(String name, Place place, int timeLastFood, Coordinate location) {
        this.name = name;
        this.actualPlace = place;
        this.timeLastFood = timeLastFood;
        this.mood =  TypesFeelings.NEUTRAL;
        this.awake = true;
        this.location = location;
        this.visionManager = null;
        //this.perceptive = false;
        //this.celBodyPerceptionManager = null;
    }

    public Human(String name, Place place, int timeLastFood, boolean awake, Coordinate location) {
        this.name = name;
        this.actualPlace = place;
        this.timeLastFood = timeLastFood;
        this.mood =  TypesFeelings.NEUTRAL;
        this.awake = awake;
        this.location = location;
        this.visionManager = null;
        //this.celBodyPerceptionManager = null;
    }

    // The rocket is the time zero, so timeLastFood depends on how much hours before
    // or after the rocket's rush the person ate. And if the person it will change
    // to the actual time of travel.
    // For a better explanation see image in docs
    @Override
    public void timeToEat() {
        if (TimeManager.getTimeElapsed() - this.getTimeLastFood()  >= 5)
            this.feels(TypesFeelings.HUNGER);
        else
            System.out.println("Still is not time to eat!");
    }

    @Override
    public void eats(Thing thing) {
        if (this.getActualPlace().hasThing(thing)) {
            if (thing.isType(TypeThings.FOOD) && thing.existing()) {
                thing.decreaseAmount();
                this.setTimeLastFood(TimeManager.getTimeElapsed());
                System.out.println(getName() + " eats " + thing.toString());
                this.feels(TypesFeelings.SATISFACTION);
            } else
                System.out.println("There is no more " + thing.getName());
        } else
            System.out.println(thing.getName() + " is not in this room!");
    }


    @Override
    public void sees(InterLocationUtilities objToSee) {
        try {
            this.visionManager = new VisionManager(this, objToSee);

            if (this.visionManager.canSeeObj(objToSee))
                System.out.println(this.visionManager.getStrSeeingProcess());

        } catch (ClassCastException e) {
            System.out.println(objToSee.toString() + " has no coordinates");
        } catch (ProblemSeeingObjException e) {
            System.out.println(this.getName() + "can not see " + objToSee.toString() +
                    " because " + e.getMessage());
        }
    }

    @Override
    public void said(InterCreature creature, String msg) {
        System.out.println(this.getName() + " said to " + creature.getName() + " \"" + msg + "\"");
    }

    @Override
    public void feels(TypesFeelings feeling) {
        this.setMood(feeling);
        System.out.println(this.getName() + feeling.getTextFeeling());
    }

    @Override
    public void searchExit() {
        System.out.println(this.getName() + " looking for an exit...");
        for (Thing thing : this.getActualPlace().getThings()) {
            if (thing.isCanSeeThrough()) {
                this.sees(thing);
                return;
            }
        }
        System.out.println(this.getName() + " can not find exit");
    }


    @Override
    public void wakesUp() {
        if (!this.isAwake()) {
            this.setAwake(true);
            System.out.println(getName() + " wakes up");
        }
    }


    @Override
    public void printStatus() {
        if(!this.isAwake())
            System.out.println(getName() + " is sleeping");
        else
            System.out.println(getName() + " is awake");
    }

    public void printLocation() {
        System.out.println(getName() + " is in " + getActualPlace().getName());
    }

    @Override
    public void moves(Place nextPlace, Coordinate newCoord) {
        this.setActualPlace(nextPlace);
        this.setLocation(newCoord);
        System.out.println(getName() + " moves to " + nextPlace.getName());
    }

    public void setActualPlace(Place actualPlace) {
        this.actualPlace = actualPlace;
    }



    public void setLocation(Coordinate location) {
        this.location = location;
    }

    public void setMood(TypesFeelings mood) {
        this.mood = mood;
    }

    public void setAwake(boolean awake) {
        this.awake = awake;
        System.out.println(this.getName() + ((awake) ? " woke up" : " went to sleep"));
    }

    public void setTimeLastFood(int timeLastFood) {
        this.timeLastFood = timeLastFood;
    }

    @Override
    public int getTimeLastFood() {
        return this.timeLastFood;
    }

    public TypesFeelings getMood() {
        return mood;
    }

    public boolean isAwake() {
        return this.awake;
    }

    public String getName() {
        return this.name;
    }

    public Place getActualPlace() {
        return actualPlace;
    }

    @Override
    public Coordinate getLocation() {
        return this.location;
    }

    @Override
    public int hashCode() {
        int result = 7;
        result += (this.getName().hashCode()/50) >> 2;
        result += this.getLocation().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Human))
            return false;
        if (obj == this)
            return true;
        Human objHuman = (Human) obj;
        return this.getLocation().equals(objHuman.getLocation())  &&
                this.getActualPlace().equals(objHuman.getActualPlace()) &&
                this.getName().equals(objHuman.getName());
    }

    @Override
    public String toString() {
        return this.getName() + this.getLocation().toString();
    }
}
