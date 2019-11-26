package ru.students.lab;

public class Thing implements InterThing {
    private String name;
    private TypeThings type;
    private int amount;

    public Thing(String name, TypeThings type, int amount) {
        this.name = name;
        this.type = type;
        this.amount = amount;
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
