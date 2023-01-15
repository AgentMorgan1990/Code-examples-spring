package com.example.context.annotation.example_14_qualifier_constructor;

import org.springframework.stereotype.Component;

@Component
public class ClassicalMusic implements Music {
    @Override
    public String getMusic() {
        return "Hungarian Rhapsody";
    }
}
