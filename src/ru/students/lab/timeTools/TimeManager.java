package ru.students.lab.timeTools;

public class TimeManager {
    private static int numDays;
    private static int timeOfDay;
    private static int timeElapsed;
    private static PartsOfDay actualPartOfDay;

    static {
        numDays = 0;
        timeOfDay = 0;
        timeElapsed = 0;
        updateActualPartOfDay();
    }

    public static void addTimElapsed(int hours) {
        timeElapsed += hours;
        numDays = (int) Math.round((timeElapsed / 24) - 0.5); //always round to the minimal number
        timeOfDay = Math.abs(timeElapsed - (numDays * 24));
        updateActualPartOfDay();
        System.out.println("Passed " + hours + " hours");
        System.out.println("Day of travel #" + numDays);
        printActualPartDay();
    }

    private static void updateActualPartOfDay() {
        if (timeOfDay >= 0 && timeOfDay < 6)
            TimeManager.actualPartOfDay = PartsOfDay.NIGHT;
        else if (timeOfDay >= 6 && timeOfDay < 12)
            TimeManager.actualPartOfDay = PartsOfDay.MORNING;
        else if (timeOfDay >= 12 && timeOfDay < 18)
            TimeManager.actualPartOfDay = PartsOfDay.AFTERNOON;
        else if (timeOfDay >= 18 && timeOfDay < 24)
            TimeManager.actualPartOfDay = PartsOfDay.EVENING;
    }

    public static int getTimeElapsed() {
        return timeElapsed;
    }

    public static void printActualPartDay() {
        System.out.println("Actual time: " + TimeManager.getActualPartOfDay().toString());
    }

    public static PartsOfDay getActualPartOfDay() {
        return actualPartOfDay;
    }
}
