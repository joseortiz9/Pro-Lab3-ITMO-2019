package ru.students.lab.living;

import java.util.ArrayList;

public enum TypesFeelings {
    INTEREST("Interest"),
    HUNGER("Hunger"),
    STAGNATION("Stagnation"),
    TIREDNESS("Tiredness"),
    SATISFACTION("Satisfaction");

    private final String name;
    TypesFeelings(String name) {
        this.name = name;
    }

    public String getTextFeeling() {
        return " feels " + this.toString();
    }

    @Override
    public String toString() {
        return name;
    }
}
