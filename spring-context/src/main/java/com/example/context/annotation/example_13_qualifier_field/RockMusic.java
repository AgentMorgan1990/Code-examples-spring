package com.example.context.annotation.example_13_qualifier_field;

import org.springframework.stereotype.Component;

@Component
public class RockMusic implements Music {
    @Override
    public String getMusic() {
        return "Wind of Change";
    }
}
