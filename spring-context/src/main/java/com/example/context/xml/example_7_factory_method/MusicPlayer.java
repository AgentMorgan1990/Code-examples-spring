package com.example.context.xml.example_7_factory_method;

public class MusicPlayer {
    private Music music;
    private String name;
    private int volume;

    //IoC
    public void setMusic(Music music) {
        this.music = music;
    }

    public void playMusic() {
        System.out.println("Playing: " + music.getMusic());
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

