package org.example;

public class HRCalculator {
    public static int calculateMaxHR(int age){
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age must be between 0 and 120");
        }
        return 220 - age;
    }
    public static String getWorkoutZone(int age, int bpm){
        return "?";
    }
}