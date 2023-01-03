package com.example.context.dependency_injection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * Пример внедрения значений примитивных типов и строк:
 * 1) Через аннотацию @Value
 * 2) Через конструктор
 * 3) Через сеттер
 *
 */

@Component
public class Camera {
    @Value("X1")
    private String model;

    public Camera(String model) {
        this.model = model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}