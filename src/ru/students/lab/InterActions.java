package ru.students.lab;

public interface InterActions {
    public void moves(Place nextPlace, Coordinate newCoord);
    public void sees(InterLocationUtilities objToSee);
    public void eats(Thing food);
    public void feels(TypesFeelings feeling);
    public void wakesUp();
}
