package com.example.context.annotation.example_8;

import org.springframework.stereotype.Component;

@Component
public class ClassicalMusic implements Music {
    @Override
    public String getMusic() {
        return "Hungarian Rhapsody";
    }
}
