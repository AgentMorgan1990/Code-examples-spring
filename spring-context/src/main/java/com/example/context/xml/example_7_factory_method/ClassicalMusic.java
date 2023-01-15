package com.example.context.xml.example_7_factory_method;

public class ClassicalMusic implements Music {

    /**
     * Создаём приватный конструктор, чтобы невозможно было создать объект, через оператор new
     * */
    private ClassicalMusic(){}


    /**
     * Это фабричный метод и он должен быть статическим, так как если он не статический, мы не сможем вызвать метод
     * и не сможем создать объект
     * */
    public static ClassicalMusic getClassicalMusic(){
        return new ClassicalMusic();
    }

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
