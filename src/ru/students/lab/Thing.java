package ru.students.lab;

public class Thing implements InterStandardFunctions {
    private String name;
    private String type;

    public Thing(String name) {
        this.name = name;
    }
    public Thing(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public boolean isType(String type) {
        return this.type.equals(type);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
