package com.example.context.java_config;


import com.example.context.Camera;
import com.example.context.CameraRoll;
import com.example.context.ColorCameraRoll;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Пример JavaConfig
 *
 * */
@Configuration
public class AppConfig {
    @Bean(name = "cameraRoll")
    public CameraRoll cameraRoll() {
        return new ColorCameraRoll();
    }

    @Bean(name = "camera")
    public Camera camera(CameraRoll cameraRoll) {
        Camera camera = new Camera();
        camera.setCameraRoll(cameraRoll);
        return camera;
    }
}
