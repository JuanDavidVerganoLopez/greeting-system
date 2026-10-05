package com.greetingsystem.model;

public enum TimeOfDay {
    AM("Good morning"),
    PM("Good evening");

    private final String greetingPrefix;

    TimeOfDay(String greetingPrefix) {
        this.greetingPrefix = greetingPrefix;
    }

    public String greetingPrefix() {
        return greetingPrefix;
    }
}
