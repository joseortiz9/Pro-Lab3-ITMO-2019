package ru.students.lab;

public class Thing implements InterThing, InterLocationUtilities {
    private String name;
    private TypeThings type;
    private int amount;
    private Coordinate location;
    private boolean canSeeThrough;

    public Thing(String name, TypeThings type, int amount, boolean canSeeThrough, Coordinate location) {
        this.name = name;
        this.type = type;
        this.amount = amount;
        this.canSeeThrough = canSeeThrough;
        this.location = location;
    }

    @Override
    public void decreaseAmount(){
        this.amount--;
    }

    @Override
    public boolean existing() {
        return this.amount > 0;
    }

    public boolean isType(TypeThings type) {
        return this.type.equals(type);
    }

    public String getName() {
        return this.name;
    }

    public TypeThings getType() {
        return type;
    }

    public int getAmount() {
        return this.amount;
    }

    public boolean isCanSeeThrough() {
        return this.canSeeThrough;
    }

    @Override
    public Coordinate getLocation() {
        return this.location;
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode() + this.getLocation().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Thing))
            return false;
        if (obj == this)
            return true;
        Thing objThing = (Thing) obj;
        return this.getLocation().equals(objThing.getLocation()) &&
                this.getType().equals(objThing.getType()) &&
                this.getName().equals(objThing.getName());
    }

    @Override
    public String toString() {
        if (this.getType().equals(TypeThings.FOOD))
            return this.getName() + " [Actual amount: " + this.getAmount() + "]";
        else
            return this.getName() + this.getLocation().toString();
    }
}
