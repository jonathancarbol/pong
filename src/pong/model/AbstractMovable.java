// A super class which includes the size and position
// of objects from Positionable and additionally handles the x and y speeds.

package pong.model;

public class AbstractMovable extends AbstractPositionable{

    private double dX;
    private double dY;

    public AbstractMovable(double x, double y, double height, double width, double dX, double dY) {
        super(x, y, height, width);
        this.dX = dX;
        this.dY = dY;
    }

    public double getdX() {
        return dX;
    }

    public void setdX(double dX) {
        this.dX = dX;
    }

    public double getdY() {
        return dY;
    }

    public void setdY(double dY) {
        this.dY = dY;
    }
}
