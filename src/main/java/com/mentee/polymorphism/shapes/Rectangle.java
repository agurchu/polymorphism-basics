package com.mentee.polymorphism.shapes;


import java.util.List;

public class Rectangle extends Shape implements Drawable, Resizable {

    private double width;
    private double height;


    // TODO: Create constructor (name, color, width, height)

    public  Rectangle(String newName, String newColor, Double newW, Double newH){
        super(newName, newColor);
        width = newW;
        height = newH;
    }
    @Override
    public double calculateArea(){
//        w * h
        return  width * height ;
    }

    @Override
    public double calculatePerimeter(){
//        2 (w + h)
        return 2 * (width + height );
    }

    @Override
    public void draw(){

    }

    public void resize(double factor){

    }
    // TODO: Implement all abstract methods from Shape, Drawable, and Resizable
}
