package com.greetingsystem;

import com.greetingsystem.model.Student;

public final class GreetingService {
    private GreetingService() {
    }

    public static String greet(Student student) {
        return "%s, %s! You are %d years old.".formatted(
                student.timeOfDay().greetingPrefix(),
                student.name(),
                student.age()
        );
    }
}
