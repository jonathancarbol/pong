package pong.model;

import java.util.Random;

import static pong.model.Pong.GAME_HEIGHT;
import static pong.model.Pong.GAME_WIDTH;
import static pong.model.Pong.HALF_SEC;

/*
 * A Ball for the Pong game
 * A model class
 */
public class Ball implements IPositionable {

    public static final double WIDTH = 40;
    public static final double HEIGHT = 40;
    public static double BALL_XSPEED = 4;
    public static double BALL_YSPEED = 2;
    private double X;
    private double Y;
    private double dX;
    private double dY;

    public Ball(double x, double y, double dX, double dY) {
        X = x;
        Y = y;
        this.dX = dX;
        this.dY = dY;
    }

    public double getWidth() {
        return WIDTH;
    }

    public double getHeight() {
        return HEIGHT;
    }

    @Override
    public double getX() {
        return X;
    }

    @Override
    public double getY() {
        return Y;
    }

    public double getdX() {
        return dX;
    }

    public double getdY() {
        return dY;
    }


    public void setX(double x) {
        X = x;
    }

    public void setY(double y) {
        Y = y;
    }


    public void setdX(double dX) {
        this.dX = dX;
    }

    public void setdY(double dY) {
        this.dY = dY;
    }

    public void newX() {
        this.X = this.X + dX*Pong.time;
    }

    public void newY() {
        this.Y = this.Y + dY*Pong.time;
    }

    public void bounceWall() {
        if (Y + dY <= 0 || Y + dY >= GAME_HEIGHT - HEIGHT) {
            dY = -dY;
        }
    }

    public void bouncePaddle() {
        if (X + dX <= 5 + Paddle.PADDLE_WIDTH || X + dX >= GAME_WIDTH - WIDTH  - 5 - Paddle.PADDLE_WIDTH) {
            dX = -dX;
        }
    }
}
