package org.example;

public class HRCalculator {
    public static int calculateMaxHR(int age){
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age must be between 0 and 120");
        }
        return 220 - age;
    }
    public static String getWorkoutZone(int age, int bpm){
        int max = calculateMaxHR(age);
        if (bpm < 0 || bpm > max) {
            throw new IllegalArgumentException("Invalid BPM");
        }

        double percent = (double) bpm / max;

        if (percent < 0.50) return "Below zone";
        if (percent < 0.60) return "Recovery";
        if (percent < 0.70) return "Fat burn";
        if (percent < 0.80) return "Cardio";
        if (percent < 0.90) return "Anaerobic";
        return "VO2 max";
    }

}