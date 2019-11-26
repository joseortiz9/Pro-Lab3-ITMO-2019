package ru.students.lab;

public interface InterCreature {
    public int getTimeSinceLastFood();
    public boolean isTimeToEat(int timeElapsed);
    public void showStatus();
}
