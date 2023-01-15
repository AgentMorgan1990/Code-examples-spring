//package com.example.context.configuration.java;
//
//import com.example.context.Camera;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//
//public class Client {
//    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        Camera camera = context.getBean("camera", Camera.class);
//        camera.doPhotograph();
//    }
//}
