package com.example.context.xml.example_6_init_destroy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("example_6.xml");


        ClassicalMusic classicalMusic = context.getBean("musicBean", ClassicalMusic.class);
        classicalMusic.getMusic();
        context.close();
    }
}
