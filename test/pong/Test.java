package pong;

import pong.model.Ball;
import pong.model.Paddle;

import static java.lang.System.out;

/**
 * Here you should write your tests
 *
 * Right click and run ...
 */
public class Test {

    public static void main(String[] args) {
        new Test().test();
    }

    void test() {
        //Ball b = new Ball();

        Paddle p1 = new Paddle(10,10);

        out.println(p1.getX());
        out.println(p1.getY());
        out.println(p1.getWidth());
        out.println(p1.getHeight());
        // Create an object  ...
        // .. call methods to test.



    }


}
