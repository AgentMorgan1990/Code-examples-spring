package com.example.context.xml.example_5_scope;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("example_5.xml");

/**
 * Пример использования scope prototype
 * */
        MusicPlayer firstMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer secondMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        boolean comparing = firstMusicPlayer == secondMusicPlayer;
        System.out.println(comparing);

        firstMusicPlayer.setVolume(20);

        System.out.println(firstMusicPlayer.getVolume());
        System.out.println(secondMusicPlayer.getVolume());


    }
}
