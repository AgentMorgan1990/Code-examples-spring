package com.example.context.xml.example_4;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
    private List<Music> musics = new ArrayList<>();
    private String name;
    private int volume;


    public void setMusics(List<Music> musics) {
        this.musics = musics;
    }

    public void playMusic() {
        musics.forEach(music -> System.out.println("Playing: " + music.getMusic()));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
