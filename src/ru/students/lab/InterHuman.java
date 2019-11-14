package ru.students.lab;

public interface InterHuman {
    public void moves(Place nextPlace);
    public void usesOrgan(Organs organ);
    public void knows(boolean know);
    public void sees(Object planet);
    public void eats(Thing food);
    public void wakeUp();
}
