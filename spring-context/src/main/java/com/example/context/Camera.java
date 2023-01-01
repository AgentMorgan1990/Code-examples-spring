package com.example.context;

public class Camera {
    private CameraRoll cameraRoll;
    public CameraRoll getCameraRoll() {
        return cameraRoll;
    }
    public void setCameraRoll(CameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }
    public void doPhotograph(){
        System.out.println("Щелк!");
        cameraRoll.processing();
    }
}
