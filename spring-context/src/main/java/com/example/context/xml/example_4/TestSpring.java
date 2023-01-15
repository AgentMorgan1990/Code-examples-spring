package com.example.context.xml.example_4;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "example_4.xml"
        );

        /**
         * В этом примере создаём бин с помощью спринга, и внедряем зависимостьчерез спринг с помощью конструктора
        */
        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer.playMusic();
        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());
    }
}
