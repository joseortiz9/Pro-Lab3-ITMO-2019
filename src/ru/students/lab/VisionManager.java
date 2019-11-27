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

        if (mainFunc.calcDeltaX() == 0) {
            int yToEvaluate = (int) this.getHumanCoords().getY();
            int endPToEvaluate = (int) this.getObjCoords().getY();

            if (getMainFunc().positiveFunc()) {
                while (yToEvaluate < endPToEvaluate) {
                    if (this.getHumanCoords().getX() == getMainFunc().getSlope() &&
                            yToEvaluate == (int)objInterruptCoords.getY())
                        return true;

                    yToEvaluate++;
                }
            }
            else {
                while (yToEvaluate > endPToEvaluate) {
                    if (this.getHumanCoords().getX() == getMainFunc().getSlope() &&
                            yToEvaluate == (int)objInterruptCoords.getY())
                        return true;

                    yToEvaluate--;
                }
            }
        }
        else if(this.getMainFunc().equals(tempObjsFunc)) {
            System.out.println("MAIN " + getMainFunc().toString());
            System.out.println(tempObjsFunc.toString());
            int xToEvaluate = (int) this.getHumanCoords().getX() + 1; //not count the human
            int endPToEvaluate = (int) this.getObjCoords().getX();

            System.out.println(getMainFunc().positiveFunc());

            if (getMainFunc().positiveFunc()) {
                while (xToEvaluate < endPToEvaluate) {
                    System.out.println(xToEvaluate);
                    if (xToEvaluate == (int)objInterruptCoords.getX()
                            && this.getMainFunc().getYFromFunction(xToEvaluate) == objInterruptCoords.getY())
                        return true;

                    xToEvaluate++;
                }
            }
            else {
                while (xToEvaluate > endPToEvaluate) {
                    if (xToEvaluate == (int)objInterruptCoords.getX()
                            && this.getMainFunc().getYFromFunction(xToEvaluate) == objInterruptCoords.getY())
                        return true;

                    xToEvaluate--;
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
