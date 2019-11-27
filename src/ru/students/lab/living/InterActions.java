package ru.students.lab.living;

import ru.students.lab.locationTools.Coordinate;
import ru.students.lab.locationTools.InterLocationUtilities;
import ru.students.lab.locationTools.Place;
import ru.students.lab.things.Thing;

public interface InterActions {
    public void moves(Place nextPlace, Coordinate newCoord);
    public void sees(InterLocationUtilities objToSee);
    public void eats(Thing food);
    public void feels(TypesFeelings feeling);
    public void wakesUp();
}
