package ru.students.lab;

public enum Feelings {
    Interest("Interest", false),
    Hunger("Hunger", false),
    Closeness("Closeness", false),
    Stagnation("Stagnation", false),
    Tiredness("Tiredness", false),
    Satisfied("Satisfied", false);

    private final String name;
    private boolean isFelt;
    Feelings(String name, boolean isFelt) {
        this.name = name;
        this.isFelt = isFelt;
    }

    public boolean getIsFelt() {
        return isFelt;
    }

    public void changeIsFelt() {
        this.isFelt = !this.isFelt;
    }

    public String getTextFeeling() {
        return " feels " + this.toString();
    }

    @Override
    public String toString() {
        return name;
    }
}
