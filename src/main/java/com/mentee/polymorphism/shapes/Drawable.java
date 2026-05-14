package com.mentee.polymorphism.shapes;

public interface Drawable {

    void draw();                    // Abstract method

    // TODO: Add a default method called "printInfo()"
    // that prints "Drawing a [shape name]"
    default public void printInfo(){
        System.out.println("Drawing a "+ this.getClass().getName());
    }
}