package com.example.context.annotation.example_15_value_scope_postconstruct_predestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class RockMusic implements Music {
    @Override
    public String getMusic() {
        return "Wind of Change";
    }
}
