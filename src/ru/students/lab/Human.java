package ru.students.lab;

import java.util.ArrayList;
import java.util.Arrays;

public class Human implements InterCreature, InterActions, InterSenses, InterUtilities {

    private String name;
    private int timeSinceLastFood;
    private ArrayList<Feelings> feelings;
    private Place actualPlace;
    private boolean awake;

    public Human(String name, Place place, int timeSinceLastFood) {
        this.name = name;
        this.actualPlace = place;
        this.timeSinceLastFood = timeSinceLastFood;
        this.feelings = new ArrayList<>(Arrays.asList(Feelings.values()));
        this.awake = true;
    }

    public Human(String name, Place place, int timeSinceLastFood, boolean awake) {
        this.name = name;
        this.actualPlace = place;
        this.timeSinceLastFood = timeSinceLastFood;
        this.feelings = new ArrayList<>(Arrays.asList(Feelings.values()));
        this.awake = awake;
    }


    @Override
    public int getTimeSinceLastFood() {
        return this.timeSinceLastFood;
    }

    @Override
    public boolean isTimeToEat(int timeElapsed) {
        return this.getTimeSinceLastFood() + timeElapsed >= 5;
    }


    @Override
    public void changeFeeling(Feelings feeling) {
        if (this.getFeelings().contains(feeling)) {
            feeling.changeIsFelt();
            int indFeeling = this.getFeelings().indexOf(feeling);
            this.getFeelings().set(indFeeling, feeling);
        }
    }

    public ArrayList<Feelings> getFeelings() {
        return feelings;
    }


    @Override
    public void eats(Thing thing) {
        if (thing.isType(TypeThings.Food) && thing.existing()) {
            System.out.println(getName() + " eats " + thing.toString());
            thing.decreaseAmount();
            this.feels(Feelings.Satisfied);
            this.changeFeeling(Feelings.Hunger);
        }
        else
            System.out.println("There is no more "+ thing.getName());
    }


    @Override
    public void sees(Object objToSee, Object objInterrupt) {
        if (!this.isAwake())
            System.out.println(this.getName() + " can not see " +
                    objToSee.toString() + " because is sleeping" /*+ this.getStatus()*/);
        else {
            if (objInterrupt != null)
                System.out.println(this.getName() + " can not see " +
                        objToSee.toString() + " because has " +
                        objInterrupt.toString() + " in the middle");
            else {
                if (objToSee.equals(Planets.Moon)) {
                    System.out.println(this.getName() + " saw the " + objToSee.toString());
                    this.feels(Feelings.Interest);
                }
                else if (objToSee instanceof Velocity) {
                    System.out.println(this.getName() + " can not see the Velocity of " + objToSee.toString());
                    this.feels(Feelings.Stagnation);
                }
                else
                    System.out.println(this.getName() + " sees the " + objToSee.toString());
            }
        }
    }


    @Override
    public void feels(Feelings feeling) {
        this.changeFeeling(feeling);
        System.out.println(this.getName() + feeling.getTextFeeling());
    }


    @Override
    public void wakesUp() {
        if (!this.isAwake()) {
            this.awake = true;
            System.out.println(getName() + " wakes up");
        }
    }


    @Override
    public void showStatus() {
        if(!this.isAwake())
            System.out.println(getName() + " is sleeping");
        else
            System.out.println(getName() + " is awake");
    }

    @Override
    public void printLocation() {
        System.out.println(getName() + " is in " + getActualPlace());
    }

    @Override
    public void moves(Place nextPlace) {
        this.actualPlace = nextPlace;
        System.out.println(getName() + " moves to " + nextPlace.getName());
    }

    public boolean isAwake() {
        return this.awake;
    }

    public String getName() {
        return this.name;
    }

    public String getActualPlace() {
        return actualPlace.getName();
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode() + this.getActualPlace().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Human))
            return false;
        if (obj == this)
            return true;
        return this.hashCode() == obj.hashCode();
    }

    @Override
    public String toString() {
        return getName();
    }
}
