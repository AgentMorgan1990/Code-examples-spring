package com.example.context.annotation.example_12_chain_of_dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
    @Autowired
    private Music music;
    public String playMusic() {
        return "Playing: " + music.getMusic();
    }
}
