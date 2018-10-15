package pong.model;


import pong.event.Event;
import pong.event.EventService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/*
 * Logic for the Pong Game
 * Model class representing the "whole" game
 * Nothing visual here
 *
 */
public class Pong {
    Random rand = new Random();

    public static final double GAME_WIDTH = 1200;
    public static final double GAME_HEIGHT = 800;
    public static final double BALL_SPEED_FACTOR = 1.02;
    public static final long HALF_SEC = 500_000_000;
    public static final double time = 1.0;


    private int pointsLeft;
    private int pointsRight;
    private Ball ball;
    private Paddle rightPaddle;
    private Paddle leftPaddle;
    private List<Wall> walls;
    private long timeForLastHitWall;
    private long timeForLastHitPaddle;         // To avoid multiple collisions

    //

    public Pong(Ball ball, Paddle leftPaddle, Paddle rightPaddle, List<Wall> walls) {
        this.pointsLeft = 0;
        this.pointsRight = 0;
        this.timeForLastHitWall = HALF_SEC;
        this.timeForLastHitPaddle = HALF_SEC;
        this.ball = ball;
        this.leftPaddle = leftPaddle;
        this.rightPaddle = rightPaddle;
        this.walls = walls;
    }

    // --------  Game Logic -------------



    public void update(long now) {
        ball.move();
        leftPaddle.move();
        rightPaddle.move();


        if (now - timeForLastHitWall > HALF_SEC) {
            for (Wall w : walls) {
                if (ball.intersects(w)) {
                    ball.setdY(-ball.getdY());
                    timeForLastHitWall = now;
                }
            }
        }

        if (now - timeForLastHitPaddle > HALF_SEC) {
            if (ball.intersects(leftPaddle) || ball.intersects(rightPaddle)) {
                EventService.remove();
                ball.setdX(-ball.getdX() * BALL_SPEED_FACTOR);
                ball.setdY(ball.getdY() + (rand.nextDouble() * 0.5 - 1));
                timeForLastHitPaddle = now;
                Event evt = new Event(Event.Type.BALL_HIT_PADDLE);
                EventService.add(evt);
            }
        }

/*
        if (leftPaddle.getY() + leftPaddle.getdY() <= ball.getY() + ball.getdY() + Ball.HEIGHT
                && ball.getY() + ball.getdY() <= leftPaddle.getY() + leftPaddle.getdY() + Paddle.PADDLE_HEIGHT
                && ball.getX() < GAME_WIDTH/2) {
            ball.bouncePaddle();
        }

        if (rightPaddle.getY() + rightPaddle.getdY() <= ball.getY() + ball.getdY() + Ball.HEIGHT
                && ball.getY() + ball.getdY() <= rightPaddle.getY() + leftPaddle.getdY() + Paddle.PADDLE_HEIGHT
                && ball.getX() > GAME_WIDTH/2) {
            ball.bouncePaddle();
        }
*/
        //long time = now;
      // TODO Most game logic here, i.e. move paddles etc.
    }




    // --- Used by GUI  ------------------------

    public List<IPositionable> getPositionables() {
        List<IPositionable> drawables = new ArrayList<>();
        drawables.add(leftPaddle);
        drawables.add(rightPaddle);
        drawables.add(ball);
        return drawables;
    }

    public int getPointsLeft() {
        if (ball.getX() > GAME_WIDTH) {
            pointsLeft++;
            ball.setX(GAME_WIDTH/2 - Ball.WIDTH/2);
            ball.setY(GAME_HEIGHT/2 - Ball.HEIGHT/2);
            ball.setdX(-Ball.BALL_XSPEED);
            ball.setdY((rand.nextDouble() * 2 - 1)*Ball.BALL_YSPEED);
        }
        return pointsLeft;
    }

    public int getPointsRight() {
        if (ball.getX() < 0 - Ball.WIDTH) {
            pointsRight++;
            ball.setX(GAME_WIDTH/2 - Ball.WIDTH/2);
            ball.setY(GAME_HEIGHT/2 - Ball.HEIGHT/2);
            ball.setdX(Ball.BALL_XSPEED);
            ball.setdY((rand.nextDouble() * 2 - 1)*Ball.BALL_YSPEED);
        }
        return pointsRight;
    }

    public void setSpeedRightPaddle(double factor) {
            double paddleSpeed = factor * Paddle.PADDLE_SPEED;
            rightPaddle.setdY(paddleSpeed);
    }

    public void setSpeedLeftPaddle(double factor) {
            double paddleSpeed = factor * Paddle.PADDLE_SPEED;
            leftPaddle.setdY(paddleSpeed);
    }

}
