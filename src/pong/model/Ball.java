package pong.model;

import static pong.model.Pong.*;

/*
 * A Ball for the Pong game
 * A model class
 * Includes all information from AbstractPositionable & AbstractMovable.
 */
public class Ball extends AbstractMovable {

    public static final double WIDTH = 40;
    public static final double HEIGHT = 40;
    public static double BALL_XSPEED = 4;
    public static double BALL_YSPEED = 2;

    public Ball(double x, double y, double height, double width, double dX, double dY) {
        super(x, y, height, width, dX, dY);
    }

    public Ball(double x, double y) {
        super(x, y, HEIGHT, WIDTH, BALL_XSPEED, BALL_YSPEED);

    }

    public void move(){         //Moves the ball in X and Y directions.
        setX(getX() + getdX());
        setY(getY() + getdY());
    }
}
