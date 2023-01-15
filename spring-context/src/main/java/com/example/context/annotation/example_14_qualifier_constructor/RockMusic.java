package com.example.context.annotation.example_14_qualifier_constructor;

import org.springframework.stereotype.Component;

@Component
public class RockMusic implements Music {
    @Override
    public String getMusic() {
        return "Wind of Change";
    }
}
