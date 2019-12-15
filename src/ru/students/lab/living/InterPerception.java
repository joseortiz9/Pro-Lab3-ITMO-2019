package ru.students.lab.living;

import ru.students.lab.galaxy.CelestialBody;
import ru.students.lab.vehicles.AbsVehicle;

public interface InterPerception {
    public void perceiveSize(CelestialBody celBody);
    public void perceiveDetails(CelestialBody celBody);
    public void perceiveMovement(AbsVehicle vehicle);
}
