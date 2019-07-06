package com.kodilla.spring.intro.shape;


public class Drawer {

    final Shape shape;

    public Drawer(final Shape shape) {//halo halo wstrzykiwanie zależności przez konstruktor
        this.shape = shape;//czyli dependency injection
    }

    public String doDrawing() {
        return shape.draw();
    }


}
