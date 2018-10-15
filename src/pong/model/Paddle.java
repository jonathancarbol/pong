package pong.model;

import static pong.model.Pong.GAME_HEIGHT;

/*
 * A Paddle for the Pong game
 * A model class
 *
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


    public void move() {
        double tempY = getY() + getdY();
        if (tempY > 0 && tempY < GAME_HEIGHT - getHeight()) {
            setY(tempY);
        }
    }
}
