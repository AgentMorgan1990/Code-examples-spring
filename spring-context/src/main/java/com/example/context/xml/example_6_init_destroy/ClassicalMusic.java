package com.example.context.xml.example_6_init_destroy;

public class ClassicalMusic implements Music {

    public void initMethod(){
        System.out.println("Doing my init");
    }

    public void destroyMethod(){
        System.out.println("Doing my destroy");
    }

    @Override
    public String getMusic() {
        return "Hungarian Rhapsody";
    }
}
