package ru.students.lab.locationTools;

public class VisionManager {
    private Coordinate humanCoords;
    private Coordinate objCoords;
    private VisionFunc mainFunc;
    private VisionFunc tempObjsFunc;

    public VisionManager(Coordinate humanCoords, Coordinate objCoords) {
        this.humanCoords = humanCoords;
        this.objCoords = objCoords;
        this.mainFunc = new VisionFunc(humanCoords, objCoords);
        this.tempObjsFunc = null;
    }

    public boolean visionHasObjInterrupting(Coordinate objInterruptCoords) {
        this.tempObjsFunc = new VisionFunc(objInterruptCoords, this.getObjCoords());

        if (insideRangeVision(objInterruptCoords))
            return this.getMainFunc().equals(tempObjsFunc);
        return false;
    }

    public boolean insideRangeVision(Coordinate objInterCoords) {
        int x1 = (int) this.getHumanCoords().getX();
        int y1 = (int) this.getHumanCoords().getY();
        int x2 = (int) this.getObjCoords().getX();
        int y2 = (int) this.getObjCoords().getY();

        if (x2 - x1 == 0) {
            return ((objInterCoords.getY() > y1 && objInterCoords.getY() < y2)) ||
                    (objInterCoords.getY() > y2 && objInterCoords.getY() < y1);
        }else if (y2 - y1 == 0)
            return ((objInterCoords.getX() > x1 && objInterCoords.getX() < x2)) ||
                    (objInterCoords.getX() > x2 && objInterCoords.getX() < x1);
        else
            return ((objInterCoords.getX() > x1 && objInterCoords.getX() < x2) &&
                    (objInterCoords.getY() > y1 && objInterCoords.getY() < y2)) ||
                    ((objInterCoords.getX() > x2 && objInterCoords.getX() < x1) &&
                    (objInterCoords.getY() > y2 && objInterCoords.getY() < y1)) ||
                    ((objInterCoords.getX() > x2 && objInterCoords.getX() < x1) &&
                    (objInterCoords.getY() > y1 && objInterCoords.getY() < y2)) ||
                    ((objInterCoords.getX() > x1 && objInterCoords.getX() < x2) &&
                    (objInterCoords.getY() > y2 && objInterCoords.getY() < y1));
    }


    public Coordinate getHumanCoords() {
        return this.humanCoords;
    }

    public Coordinate getObjCoords() {
        return this.objCoords;
    }

    public VisionFunc getMainFunc() {
        return mainFunc;
    }
}
