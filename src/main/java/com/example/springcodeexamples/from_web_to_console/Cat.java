package com.example.springcodeexamples.from_web_to_console;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cat {

    @JsonProperty("name")
    private String name;

    @JsonProperty("color")
    public String color;

    @JsonProperty("age")
    private int age;
}
