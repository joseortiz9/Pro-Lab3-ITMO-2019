package ru.students.lab.living;

public interface InterCreature {
    public void setTimeLastFood(int timeLastFood);
    public int getTimeLastFood();
    public void timeToEat(int timeElapsed);
    public void printStatus();
}