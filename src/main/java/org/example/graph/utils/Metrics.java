package org.example.graph.utils;

public class Metrics {
    public static long startTime;
    public static long endTime;

    public static void startTimer() {
        startTime = System.nanoTime();
    }

    public static void stopTimer() {
        endTime = System.nanoTime();
    }

    public static long getElapsedTime() {
        return endTime - startTime;
    }
}
