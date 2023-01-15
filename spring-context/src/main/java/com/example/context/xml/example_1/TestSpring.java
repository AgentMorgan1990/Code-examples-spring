package com.example.context.xml.example_1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "example_1.xml"
        );

        Music music = context.getBean("musicBean",Music.class);

        /**
         * В этом примере создаём бин с помощью спринга, но внедряем зависимости в ручную
        */
        MusicPlayer musicPlayer = new MusicPlayer(music);

        musicPlayer.playMusic();
    }
}
