package com.example.context.xml.example_7_factory_method;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("example_7.xml");


        ClassicalMusic classicalMusic = context.getBean("musicBean", ClassicalMusic.class);
        classicalMusic.getMusic();
        context.close();
    }
}
