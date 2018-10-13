package pong.model;

import static pong.model.Pong.GAME_HEIGHT;

/*
 * A Paddle for the Pong game
 * A model class
 *
 */
public class Paddle implements IPositionable {

    public static final double PADDLE_WIDTH = 20;
    public static final double PADDLE_HEIGHT = 120;
    public static final double PADDLE_SPEED = 5;
    private final double X;
    private double Y;
    private double dY;

    public Paddle(double x, double y) {
        this.X = x;
        this.Y = y;
        this.dY = 0;
    }

    public void setdY(double dY) {
        this.dY = dY;
    }

    public double getdY() {
        return dY;
    }

    @Override
    public double getX() {
        return X;
    }

    @Override
    public double getY() {
        return Y;
    }

    @Override
    public double getWidth() {
        return PADDLE_WIDTH;
    }

    @Override
    public double getHeight() {
        return PADDLE_HEIGHT;
    }


    public void  newY() {
        double tempY = this.Y + this.dY*Pong.time;
        if (tempY > 0 && tempY < GAME_HEIGHT - Paddle.PADDLE_HEIGHT) {
            this.Y = tempY;
        }
    }
}
