package com.example.context.annotation.example_13_qualifier_field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
    @Autowired
    @Qualifier("rockMusic")
    private Music music;

    public String playMusic() {
        return "Playing: " + music.getMusic();
    }
}
