package ru.students.lab;

import java.util.ArrayList;
import java.util.Arrays;

public class Human implements InterCreature, InterActions, InterSenses, InterLocationUtilities {

    private String name;
    private int timeLastFood;
    private ArrayList<Feeling> feelings;
    private Place actualPlace;
    private boolean awake;

    public Human(String name, Place place, int timeLastFood) {
        this.name = name;
        this.actualPlace = place;
        this.timeLastFood = timeLastFood;
        this.feelings =  this.fillFeelings();
        this.awake = true;
    }

    public Human(String name, Place place, int timeLastFood, boolean awake) {
        this.name = name;
        this.actualPlace = place;
        this.timeLastFood = timeLastFood;
        this.feelings =  this.fillFeelings();
        this.awake = awake;
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
    public boolean isTimeToEat(int timeElapsed) {
        return timeElapsed - this.getTimeLastFood()  >= 5;
    }


    @Override
    public void changeFeeling(TypesFeelings feeling) {
        if (this.getFeelings().contains()) {
            feeling.changeIsFelt();
            int indFeeling = this.getFeelings().indexOf(feeling);
            this.getFeelings().set(indFeeling, feeling);
        }
    }

    public ArrayList<Feeling> getFeelings() {
        return this.feelings;
    }


    @Override
    public void eats(Thing thing) {
        if (thing.isType(TypeThings.Food) && thing.existing()) {
            System.out.println(getName() + " eats " + thing.toString());
            thing.decreaseAmount();
            this.feels(TypesFeelings.Satisfied);
            this.changeFeeling(TypesFeelings.Hunger);
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
                    this.feels(TypesFeelings.Interest);
                }
                else if (objToSee instanceof Velocity) {
                    System.out.println(this.getName() + " can not see the Velocity of " + objToSee.toString());
                    this.feels(TypesFeelings.Stagnation);
                }
                else
                    System.out.println(this.getName() + " sees the " + objToSee.toString());
            }
        }
    }


    @Override
    public void feels(TypesFeelings feeling) {
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
    public void printStatus() {
        if(!this.isAwake())
            System.out.println(getName() + " is sleeping");
        else
            System.out.println(getName() + " is awake");
    }

    @Override
    public void printLocation() {
        System.out.println(getName() + " is in " + getActualPlace().getName());
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

    public Place getActualPlace() {
        return actualPlace;
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode() + this.getActualPlace().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Human))
            return false;
        if (obj == this)
            return true;
        Human objHuman = (Human) obj;
        return this.getTimeLastFood() == objHuman.getTimeLastFood() &&
                this.getActualPlace().getName().equals(objHuman.getActualPlace().getName()) &&
                this.getName().equals(objHuman.getName());
    }

    @Override
    public String toString() {
        return getName();
    }
}
