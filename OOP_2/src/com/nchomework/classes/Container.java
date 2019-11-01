package com.nchomework.classes;

public class Container {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Container(int x, int y, int width, int height) {
        x1 = x;
        y1 = y;
        x2 = x + width;
        y2 = y + height;
    }

    public int getX() {
        return x1;
    }

    public int getY() {
        return y1;
    }

    public int getWidth() {
        return x2 - x1;
    }

    public int getHeight() {
        return y2 - y1;
    }

    public boolean collidesWidth(Ball ball) {
        if (ball.getX() + ball.getRadius() >= x2) {
            return false;
        }
        if (ball.getX() - ball.getRadius() <= x1) {
            return false;
        }
        return true;
    }

    public boolean collidesHeight(Ball ball) {
        if (ball.getY() + ball.getRadius() >= y2) {
            return false;
        }
        if (ball.getY() - ball.getRadius() <= y1) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Container[(" + x1 + "," + y1 + "),(" + x2 + "," + y2 + ")]";
    }


    public static void main(String[] args) {
        Container container = new Container(0, 0, 200, 200);
        Ball ball = new Ball(100, 100, 5, 1, 17);
        for (;;) {
            while (container.collidesWidth(ball) && container.collidesHeight(ball)) {
                ball.move();
            }
            if (!container.collidesWidth(ball)) {
                ball.reflectHorizontal();
            }
            if (!container.collidesHeight(ball)) {
                ball.reflectVertical();
            }
            System.out.println(ball);
            ball.move();
        }
    }
}
