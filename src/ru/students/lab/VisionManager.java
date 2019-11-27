package ru.students.lab;

public class VisionManager {
    private Coordinate humanCoords;
    private Coordinate objCoords;
    private VisionFunc mainFunc;

    public VisionManager(Coordinate humanCoords, Coordinate objCoords) {
        this.humanCoords = humanCoords;
        this.objCoords = objCoords;
        this.mainFunc = new VisionFunc(humanCoords, objCoords);
    }

    public boolean elementInsideDomain (Coordinate objInterruptCoords) {
        VisionFunc tempObjsFunc = new VisionFunc(objInterruptCoords, this.getObjCoords());

        if(this.getMainFunc().equals(tempObjsFunc)) {
            System.out.println("MAIN " + getMainFunc().toString());
            System.out.println(tempObjsFunc.toString());
            int startPToEvaluate = (int) this.getHumanCoords().getX() + 1; //not count the human
            int endPToEvaluate = (int) this.getObjCoords().getX();

            if (this.getMainFunc().positiveFunc()) {
                for (int x = startPToEvaluate; x < endPToEvaluate; x++) {
                    if (x == (int) objInterruptCoords.getX()
                            && this.getMainFunc().getYFromFunction(x) == objInterruptCoords.getY())
                        return true;
                }
            } else {
                for (int x = startPToEvaluate; x < endPToEvaluate; x--) {
                    if (this.getMainFunc().getYFromFunction(x) == objInterruptCoords.getY() && x == objInterruptCoords.getX())
                        return true;
                }
            }
        }

        return false;
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
