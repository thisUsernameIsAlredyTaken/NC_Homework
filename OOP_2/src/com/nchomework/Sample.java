package com.nchomework;

import com.nchomework.classes.Ball;
import com.nchomework.classes.Container;

public class Sample {

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
