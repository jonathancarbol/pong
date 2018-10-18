package pong.model;

import static pong.model.Pong.GAME_HEIGHT;

/*
 * A Paddle for the Pong game
 * A model class
 * Includes all information from AbstractMovable & AbstractPositionable.
 */
public class Paddle extends AbstractMovable {

    public static final double PADDLE_WIDTH = 20;
    public static final double PADDLE_HEIGHT = 120;
    public static final double PADDLE_SPEED = 5;

    public Paddle(double x, double y, double height, double width, double dX, double dY) {
        super(x, y, height, width, dX, dY);
    }

    public Paddle(double x, double y) {
        super(x, y, PADDLE_HEIGHT, PADDLE_WIDTH, 0, 0);
    }


    public void move() {                            //Moves the paddles in the direction of the Y-axis, but limits the movement to the size of the Game field.
        double tempY = getY() + getdY();
        if (tempY > 0 && tempY < GAME_HEIGHT - getHeight()) {
            setY(tempY);
        }
    }
}
