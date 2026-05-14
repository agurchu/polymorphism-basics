package com.mentee.polymorphism.shapes;

public class Circle extends Shape implements Drawable, Resizable {
    private double radius;

    // TODO: Create constructor (name, color, radius)
    public  Circle (String newName, String newColor, Double newRadius){
        super(newName, newColor);
        radius = newRadius;
    }

    // TODO: Implement all abstract methods from Shape, Drawable, and Resizable
    @Override
    public double calculateArea(){
//        pi * r^2
        return Math.PI * radius * radius ;
    }

    @Override
    public double calculatePerimeter(){
//        2*pi * r
        return 2 * Math.PI * radius;
    }

    @Override
    public void draw(){

    }

    public void resize(double factor){

    }
    // TODO: Override describe() if needed (optional)
}