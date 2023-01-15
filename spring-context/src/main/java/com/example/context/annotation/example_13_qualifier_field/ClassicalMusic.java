package com.example.context.annotation.example_13_qualifier_field;

import org.springframework.stereotype.Component;

@Component
public class ClassicalMusic implements Music {
    @Override
    public String getMusic() {
        return "Hungarian Rhapsody";
    }
}
