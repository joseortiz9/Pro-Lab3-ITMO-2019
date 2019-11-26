package ru.students.lab;

public interface InterActions {
    public void moves(Place nextPlace);
    public void sees(Object objToSee, Object objInterrupt);
    public void eats(Thing food);
    public void wakesUp();
}
