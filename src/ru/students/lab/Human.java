package ru.students.lab;

import java.util.ArrayList;
import java.util.Arrays;

public class Human implements InterCreature {

    private String name;
    private ArrayList<Organs> organs;
    private Place actualPlace;
    private boolean awake;
    private boolean hungry;

    public Human(String name, Place place) {
        this.name = name;
        this.actualPlace = place;
        this.organs = new ArrayList<>(Arrays.asList(Organs.values()));
        this.awake = true;
        this.hungry = false;
    }

    public Human(String name, Place place, boolean awake, boolean hungry) {
        this.name = name;
        this.actualPlace = place;
        this.organs = new ArrayList<>(Arrays.asList(Organs.values()));
        this.organs.add(Organs.Eyes);
        this.organs.add(Organs.Stomach);
        this.awake = awake;
        this.hungry = hungry;
    }

    public boolean isHungry() {
        return hungry;
    }

    public void changeHungry () {
        this.hungry = !this.hungry;
    }

    @Override
    public void thinks(String whatThinks) {
        System.out.println(this.getName() + " thinks that " + whatThinks);
    }

    @Override
    public void sees(Object obj) {
        System.out.println(getName() + " sees " + obj.toString());
    }

    @Override
    public void eats(Thing thing) {
        if (thing.isType("food") && thing.existing()) {
            System.out.println(getName() + " eats " + thing.toString());
            thing.decreaseAmount();
            changeHungry();
        }
        else
            System.out.println("There is no "+ thing.getName());
    }

    @Override
    public void usesOrgan(Organs organ) {
        switch(organ) {
            case Eyes:
                System.out.println(getName() + " gets interested");
            break;
            case Stomach:
                System.out.println(getName() + " feels hunger");
            break;
            default:
                System.out.println(" Feeling Things");
        }
    }

    @Override
    public void wakeUp() {
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
