package pong.model;

import java.util.Random;

import static pong.model.Pong.*;

/*
 * A Ball for the Pong game
 * A model class
 */
public class Ball extends AbstractMovable {

    Random rand = new Random();

    public static final double WIDTH = 40;
    public static final double HEIGHT = 40;
    public static double BALL_XSPEED = 1;
    public static double BALL_YSPEED = 2;

    public Ball(double x, double y, double height, double width, double dX, double dY) {
        super(x, y, height, width, dX, dY);
    }

    public Ball(double x, double y) {
        super(x, y, HEIGHT, WIDTH, BALL_XSPEED, BALL_YSPEED);

    }

    public void move(){
        setX(getX() + getdX());
        setY(getY() + getdY());
    }
/*
    public void bounceWall() {
        if (getY() + getdY() <= 0 || getY() + getdY() >= GAME_HEIGHT - HEIGHT) {
            setdY(-getdY());
        }
    }

    public void bouncePaddle() {
        if (getX() + getdX() <= 5 + Paddle.PADDLE_WIDTH || getX() + getdX() >= GAME_WIDTH - WIDTH  - 5 - Paddle.PADDLE_WIDTH) {
            setdX(-getdX() * BALL_SPEED_FACTOR);
        }
    }
    */
}
