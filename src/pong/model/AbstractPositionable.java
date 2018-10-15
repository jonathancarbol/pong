package pong.model;

public class AbstractPositionable {

    private double X;
    private double Y;

    private double Height;
    private double Width;


    public AbstractPositionable(double x, double y, double height, double width) {
        this.X = x;
        this.Y = y;
        this.Height = height;
        this.Width = width;
    }

    public double getMaxX() {
        return X + Width;
    }

    public double getMaxY() {
        return Y + Height;
    }

    public boolean intersects(AbstractPositionable other) {
        boolean above = other.getMaxY() < getY();
        boolean below = other.getY() > getMaxY();
        boolean leftof = other.getMaxX() < getX();
        boolean rightof = other.getX() > getMaxY();

        return!(above || below || rightof || leftof);
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    @Override
    public double getHeight() {
        return Height;
    }

    @Override
    public double getWidth() {
        return Width;
    }

    public void setX(double x) {
        X = x;
    }

    public void setY(double y) {
        Y = y;
    }
}
