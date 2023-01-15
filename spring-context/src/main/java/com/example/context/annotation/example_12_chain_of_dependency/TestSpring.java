package com.example.context.annotation.example_12_chain_of_dependency;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "example_12.xml"
        );

        Computer computer = context.getBean("computer", Computer.class);
        System.out.println(computer.toString());
        context.close();
    }
}
