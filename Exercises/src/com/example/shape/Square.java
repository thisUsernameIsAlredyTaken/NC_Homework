package com.example.shape;

public class Square extends Rectangle {

    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return width;
    }

    public void setSide(double side) {
        width = height = side;
    }

    @Override
    public void setWidth(double width) {
        this.width = height = width;
    }

    @Override
    public void setHeight(double height) {
        this.height = width = height;
    }

    @Override
    public String toString() {
        return "Square[side=" + getSide() + "]";
    }
}
