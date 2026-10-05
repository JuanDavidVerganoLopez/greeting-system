package com.greetingsystem.model;

public record Student(String name, int age, TimeOfDay timeOfDay) {
    public Student {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is required.");
        }
        if (age < 1 || age > 120) {
            throw new IllegalArgumentException("Age must be between 1 and 120.");
        }
        if (timeOfDay == null) {
            throw new IllegalArgumentException("Time of day is required.");
        }
        name = name.trim();
    }
}
