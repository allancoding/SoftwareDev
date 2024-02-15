package Course_4.Chapter_13;

public class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable{
    private double side = 1.0;
    public Octagon() {
    }
    public Octagon(double side, String color, boolean filled) {
        this.side = side;
        setColor(color);
        setFilled(filled);
    }
    public double getSide() {
        return side;
    }
    public void setSide(double side) {
        this.side = side;
    }
    public double getArea() {
        return (2 + 4 / Math.sqrt(2)) * side * side;
    }
    public double getPerimeter() {
        return 8 * side;
    }
    public String toString() {
        return "Octagon: side = " + side;
    }
    public int compareTo(Octagon o) {
        if (getArea() > o.getArea()) {
            return 1;
        } else if (getArea() < o.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            return null;
        }
    }
    public void howToColor() {
        System.out.println("Color all eight sides");
    }
}
