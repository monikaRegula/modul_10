package com.kodilla.spring.shape;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component// to mówi: utwórz mi Beana na podstawie definicji klasy oznaczonej tą adnotacją
@Scope("singleton")
public class Circle implements Shape {

    @Override
    public String getShapeName() {
        return "This is a circle.";
    }

}
