package ru.students.lab.sensesTools;

import ru.students.lab.exceptions.ProblemSeeingObjException;
import ru.students.lab.galaxy.CelestialBody;
import ru.students.lab.living.Human;
import ru.students.lab.locationTools.Coordinate;
import ru.students.lab.locationTools.InterLocationUtilities;
import ru.students.lab.things.Thing;
import ru.students.lab.things.TypeThings;

public class VisionManager {
    private Human human;
    private InterLocationUtilities objToSee;
    private VisionLinealFun mainFunc;
    private VisionLinealFun tempObjsFunc;
    private InterLocationUtilities objInterrupting;

    public static class VisionLinealFun {
        private Coordinate c1;
        private Coordinate c2;
        private double slope;
        private double b;

        public VisionLinealFun(Coordinate c1, Coordinate c2) {
            this.c1 = c1;
            this.c2 = c2;
            this.slope = this.calculateSlope();
            this.b = this.calculateB();
        }

        public double calDeltaY() {
            return (this.getC2().getY() - this.getC1().getY());
        }

        public double calcDeltaX() {
            return (this.getC2().getX() - this.getC1().getX());
        }

        public double calculateSlope() {
            if (calcDeltaX() == 0)
                return this.getC1().getX();
            else if (calDeltaY() == 0)
                return this.getC1().getY();
            return calDeltaY() / calcDeltaX();
        }

        public double calculateB() {
            if (calcDeltaX() == 0 || calDeltaY() == 0)
                return 0;
            return this.getC1().getY() - (this.getSlope() * this.getC1().getX());
        }

        public double getYFromFunction(double x) {
            return (this.getSlope() * this.getC1().getX()) + this.getB();
        }

        public Coordinate getC1() {
            return c1;
        }

        public Coordinate getC2() {
            return c2;
        }

        public double getSlope() {
            return this.slope;
        }

        public double getB() {
            return this.b;
        }

        @Override
        public int hashCode() {
            int result = 59;
            result += this.getC1().hashCode();
            result >>= 1;
            result += this.getC2().hashCode();
            result += (int) this.getSlope();
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof VisionLinealFun))
                return false;
            if (obj == this)
                return true;
            VisionLinealFun objVision = (VisionLinealFun) obj;
            return this.getSlope() == objVision.getSlope()  &&
                    this.getB() == objVision.getB();
        }

        @Override
        public String toString() {
            return "[f(x) = " + this.getSlope() + "x " + this.getB() + "]";
        }
    }

    public VisionManager(Human human, InterLocationUtilities objToSee) {
        this.human = human;
        this.objToSee = objToSee;
        this.mainFunc = new VisionLinealFun(this.getHumanCoords(), this.getObjCoords());
        this.tempObjsFunc = null;
        this.objInterrupting = this.calcObjInterrupting();
    }

    public String getStrSeeingProcess() {
        if (this.getObjInterrupting() == null) {
            if (this.getObjToSee().getClass() == CelestialBody.class)
                return this.getHuman().getName() + " only can see " + this.getObjToSee().toString() + " through " + TypeThings.WINDOW;
            else
                return this.getHuman().getName() + " sees " + this.getObjToSee().toString();
        } else if (this.getObjInterrupting().getClass() == Thing.class &&
                ((Thing) this.getObjInterrupting()).isCanSeeThrough()) {
            return this.getHuman().getName() + " sees " + this.getObjToSee().toString() +
                    " through " + this.getObjInterrupting().toString();
        } else
            return this.getHuman().getName() + " can not see " + this.getObjToSee().toString() +
                    " because " + this.getObjInterrupting().toString() + " is in the middle";
    }


    public boolean canSeeObj(InterLocationUtilities objToSee) throws ProblemSeeingObjException {
        if (objToSee.getClass() == Human.class)
            if (this.getHuman().getActualPlace().equals(((Human) objToSee).getActualPlace()))
                return true;
            else
                throw new ProblemSeeingObjException("are not in same place(room)");
        else if (objToSee.getClass() == Thing.class)
            if (this.getHuman().getActualPlace().hasThing((Thing) objToSee))
                return true;
            else
                throw new ProblemSeeingObjException("object is in different place");
        else
            return true;
    }


    private InterLocationUtilities calcObjInterrupting() {
        for (Thing thing : this.getHuman().getActualPlace().getThings())
            if (this.visionHasObjInterrupting(thing.getLocation()))
                return thing;

        return null;
    }


    private boolean visionHasObjInterrupting(Coordinate objInterruptCoords) {
        this.tempObjsFunc = new VisionLinealFun(objInterruptCoords, this.getObjCoords());

        if (insideRangeVision(objInterruptCoords))
            return this.getMainFunc().equals(tempObjsFunc);
        return false;
    }


    private boolean insideRangeVision(Coordinate objInterCoords) {
        int x1 = (int) this.getHumanCoords().getX();
        int y1 = (int) this.getHumanCoords().getY();
        int x2 = (int) this.getObjCoords().getX();
        int y2 = (int) this.getObjCoords().getY();

        if (x2 - x1 == 0) {
            return ((objInterCoords.getY() > y1 && objInterCoords.getY() < y2)) ||
                    (objInterCoords.getY() > y2 && objInterCoords.getY() < y1);
        } else if (y2 - y1 == 0)
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


    public Human getHuman() {
        return this.human;
    }

    public InterLocationUtilities getObjToSee() {
        return this.objToSee;
    }

    public InterLocationUtilities getObjInterrupting() {
        return this.objInterrupting;
    }

    public Coordinate getHumanCoords() {
        return this.getHuman().getLocation();
    }

    public Coordinate getObjCoords() {
        return this.getObjToSee().getLocation();
    }

    public VisionLinealFun getMainFunc() {
        return this.mainFunc;
    }
}
