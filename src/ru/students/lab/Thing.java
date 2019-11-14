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

    public boolean isType(String type) {
        return this.type.equals(type);
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return getName();
    }
}
