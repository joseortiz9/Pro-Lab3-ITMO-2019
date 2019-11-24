package ru.students.lab;

public interface InterCreature {
    public void moves(Place nextPlace);
    public void usesOrgan(Organs organ);
    public void thinks(String whatThinks);
    public void sees(Object planet);
    public void eats(Thing food);
    public void wakeUp();
    public void showStatus();
    public void printLocation();
}
