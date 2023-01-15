package com.example.context.annotation.example_12_chain_of_dependency;

import org.springframework.stereotype.Component;

public class ClassicalMusic implements Music {
    @Override
    public String getMusic() {
        return "Hungarian Rhapsody";
    }
}
