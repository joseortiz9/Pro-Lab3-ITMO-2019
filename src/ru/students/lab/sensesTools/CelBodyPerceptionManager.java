package ru.students.lab.sensesTools;

import ru.students.lab.exceptions.PerceivingCelBodyException;
import ru.students.lab.galaxy.CelestialBody;
import ru.students.lab.galaxy.Galaxy;
import ru.students.lab.living.Human;
import ru.students.lab.living.TypesFeelings;
import ru.students.lab.vehicles.Trajectory;

public class CelBodyPerceptionManager {

    private Human human;
    private CelestialBody celBody;

    public CelBodyPerceptionManager(Human human, CelestialBody celBody) {
        this.human = human;
        this.celBody = celBody;
    }

    public void perceiveDetails() throws PerceivingCelBodyException {
        if (this.getHuman().getMood().equals(TypesFeelings.ATTENTION) || getPerceptionValOfSize().equals(TypeSizePerceptions.BIG))
            System.out.println(this.getHuman().getName() + " pays attention to details!");
        else
            throw new PerceivingCelBodyException("Is not Paying attention or is too far from " + this.getCelBody().toString());
    }


    public String getPerceptionOfSize() /*throws PerceivingCelBodyException*/ {
        return this.getHuman().getName() + " perceives that " +
                this.getCelBody().toString() + " is " + getPerceptionValOfSize().toString();
    }

    // for comparing the actual distance from rocket to the celestialBody and the initialDistance
    // with that we can know if the celBody has became bigger to the eyes of the observer.
    public TypeSizePerceptions getPerceptionValOfSize() {
        int disFromObserver = Trajectory.calcDisFromObserver(this.getCelBody());
        return whichRangeIsObserver(disFromObserver);
    }

    // Divide the initialDistance in three ranges. And depending on the actualPos (actualDistanceFromObserver)
    // we return the type of size to the perception of observer
    public TypeSizePerceptions whichRangeIsObserver(int actDisFromObserver) {
        int[] initialDisRanges = calcRangesOfSizes(Galaxy.getInitialDistPerceived().get(this.getCelBody().getName()));
        if (actDisFromObserver >= 0 && actDisFromObserver < initialDisRanges[0])
            return TypeSizePerceptions.BIG;
        else if (actDisFromObserver >= initialDisRanges[0] && actDisFromObserver < initialDisRanges[1])
            return TypeSizePerceptions.MEDIUM;
        else
            return TypeSizePerceptions.SMALL;
    }

    public int[] calcRangesOfSizes(int distance) {
        int[] rangesSizes = new int[3];
        rangesSizes[0] = distance * 1/3;
        rangesSizes[1] = distance * 2/3;
        rangesSizes[2] = distance;
        return rangesSizes;
    }


    public Human getHuman() {
        return human;
    }

    public CelestialBody getCelBody() {
        return celBody;
    }
}
