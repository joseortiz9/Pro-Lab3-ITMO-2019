package ru.students.lab;

public interface InterCreature {
    public void setTimeLastFood(int timeLastFood);
    public int getTimeLastFood();
    public boolean isTimeToEat(int timeElapsed);
    public void printStatus();
}
