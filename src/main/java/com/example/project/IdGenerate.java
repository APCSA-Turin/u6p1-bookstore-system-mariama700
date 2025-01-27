package com.example.project;

public class IdGenerate {
    private static String currentId = "99";  // Keep currentId as a String to pass gradle tests

    public static String getCurrentId() {
        return currentId;  // Return currentId as a String
    }

    public static void generateID() {
        int id = Integer.parseInt(currentId);  // Convert String to int
        id++;  // Increment the ID
        currentId = String.valueOf(id);  // Store as String
    }

    public static void reset() {
        currentId = "99";  // Reset currentId to String
    }
} 