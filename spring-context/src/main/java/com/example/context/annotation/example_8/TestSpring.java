package com.example.context.annotation.example_8;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "example_8.xml"
        );

        Music music = context.getBean("musicBean", Music.class);
        Music classicalMusic = context.getBean("classicalMusic", Music.class);
        MusicPlayer musicPlayer = new MusicPlayer(music);
        MusicPlayer classicalMusicPlayer = new MusicPlayer(classicalMusic);
        musicPlayer.playMusic();
        classicalMusicPlayer.playMusic();
        context.close();
    }
}
