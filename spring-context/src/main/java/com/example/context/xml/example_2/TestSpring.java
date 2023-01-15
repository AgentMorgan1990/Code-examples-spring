package com.example.context.xml.example_2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "example_2.xml"
        );

        /**
         * В этом примере создаём бин с помощью спринга, и внедряем зависимостьчерез спринг с помощью конструктора
        */
        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer.playMusic();
    }
}
