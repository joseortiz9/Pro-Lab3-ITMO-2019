package ru.students.lab.living;

import ru.students.lab.locationTools.Coordinate;
import ru.students.lab.locationTools.InterLocationUtilities;
import ru.students.lab.locationTools.Place;
import ru.students.lab.locationTools.VisionManager;
import ru.students.lab.planets.Planet;
import ru.students.lab.things.Thing;
import ru.students.lab.things.TypeThings;

public class Human implements InterCreature, InterActions, InterLocationUtilities {

    private String name;
    private int timeLastFood;
    private TypesFeelings mood;
    private Place actualPlace;
    private Coordinate location;
    private boolean awake;
    private VisionManager visionManager;

    public Human(String name, Place place, int timeLastFood, Coordinate location) {
        this.name = name;
        this.actualPlace = place;
        this.timeLastFood = timeLastFood;
        this.mood =  null;
        this.awake = true;
        this.location = location;
        this.visionManager = null;
    }

    public Human(String name, Place place, int timeLastFood, boolean awake, Coordinate location) {
        this.name = name;
        this.actualPlace = place;
        this.timeLastFood = timeLastFood;
        this.mood =  null;
        this.awake = awake;
        this.location = location;
        this.visionManager = null;
    }

    @Override
    public void setTimeLastFood(int timeLastFood) {
        this.timeLastFood = timeLastFood;
    }

    @Override
    public int getTimeLastFood() {
        return this.timeLastFood;
    }

    //The rocket is the time zero, so timeLastFood depends on how much hours before
    //or after the rocket's rush the person ate. For a better explanation see image in docs
    @Override
    public void timeToEat(int timeElapsed) {
        if (timeElapsed - this.getTimeLastFood()  >= 5)
            this.feels(TypesFeelings.HUNGER);
        else
            System.out.println("Still is not time to eat!");
    }

    public boolean actualPlaceHasThing(Thing thing) {
        return this.getActualPlace().getThings().contains(thing);
    }

    @Override
    public void eats(Thing thing) {
        if (actualPlaceHasThing(thing)) {
            if (thing.isType(TypeThings.FOOD) && thing.existing()) {
                thing.decreaseAmount();
                System.out.println(getName() + " eats " + thing.toString());
                this.feels(TypesFeelings.SATISFACTION);
            } else
                System.out.println("There is no more " + thing.getName());
        } else
            System.out.println(thing.getName() + " is not in this room!");
    }


    public InterLocationUtilities getObjInterrupting(InterLocationUtilities objToSee) {
        try {
            this.visionManager = new VisionManager(this.getLocation(), objToSee.getLocation());

            for (Thing thing : this.getActualPlace().getThings()) {
                if (this.visionManager.visionHasObjInterrupting(thing.getLocation())) {
                    return thing;
                }
            }
        } catch (ClassCastException e) {
            System.out.println(objToSee.toString() + " has no coordinates");
        }
        return null;
    }


    public void sees(InterLocationUtilities objToSee) {
        if (this.canSeeObj(objToSee)) {
            InterLocationUtilities objInterrupting = getObjInterrupting(objToSee);
            if (objInterrupting == null)
                if (objToSee.getClass() == Planet.class)
                    System.out.println(this.getName() + " only can see " + objToSee.toString() + " through " + TypeThings.WINDOW);
                else
                    System.out.println(this.getName() + " sees " + objToSee.toString());
            else if (objInterrupting.getClass() == Thing.class &&
                    ((Thing) objInterrupting).isCanSeeThrough()) {
                    System.out.println(this.getName() + " sees " + objToSee.toString() +
                            " through " + objInterrupting.toString());
            } else
                System.out.println(this.getName() + " can not see " + objToSee.toString() +
                        " because " + objInterrupting.toString() + " is in the middle");
        } else
            System.out.println();
    }


    public boolean canSeeObj(InterLocationUtilities objToSee) {
        if (objToSee.getClass() == Human.class)
            return this.getActualPlace().equals(((Human) objToSee).getActualPlace());
        else if (objToSee.getClass() == Thing.class)
            return this.getActualPlace().getThings().contains(((Thing) objToSee));
        else
            return true;
    }


    @Override
    public void feels(TypesFeelings feeling) {
        this.setMood(feeling);
        System.out.println(this.getName() + feeling.getTextFeeling());
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
        return this.getName().hashCode() + this.getLocation().hashCode();
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
