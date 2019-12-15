package ru.students.lab.living;

public enum TypesFeelings {
    NEUTRAL("Neutral"),
    INTEREST("Interest"),
    DOUBTFUL("Doubtful"),
    HUNGER("Hunger"),
    STAGNATION("Stagnation"),
    TIREDNESS("Tiredness"),
    SATISFACTION("Satisfaction"),
    ATTENTION("Attention"),
    TRAPPED("Trapped");

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
