//Innehåller alla funktioner från AbstractPositionable.

package pong.model;

public class Wall extends AbstractPositionable{

    private static final double HEIGHT = 1;
    private static final double WIDTH = Pong.GAME_WIDTH;

    public Wall(double x, double y, double height, double width) {
        super(x, y, height, width);
    }

    public Wall(double y) {
        super(0, y, HEIGHT, WIDTH);
    }


}
