package com.example.context.annotation.example_10_setter;

import org.springframework.stereotype.Component;

@Component("musicBean")
public class RockMusic implements Music {
    @Override
    public String getMusic() {
        return "Wind of Change";
    }
}
