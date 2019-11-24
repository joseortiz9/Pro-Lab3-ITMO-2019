package ru.students.lab;

public class Thing implements InterThing {
    private String name;
    private String type;
    private int amount;

    public Thing(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }
    public Thing(String name, String type, int amount) {
        this.name = name;
        this.type = type;
        this.amount = amount;
    }

    public boolean isType(String type) {
        return this.type.equals(type);
    }

    public String getName() {
        return this.name;
    }

    public int getAmount() {
        return this.amount;
    }

    public String getType() {
        return type;
    }

    @Override
    public void decreaseAmount(){
        this.amount--;
    }

    @Override
    public boolean existing() {
        return this.amount > 0;
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode() + this.getAmount();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Thing))
            return false;
        if (obj == this)
            return true;
        return this.hashCode() == obj.hashCode();
    }

    @Override
    public String toString() {
        return getName();
    }
}
