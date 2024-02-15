package Course_4.Chapter_13;

public class Exercise_13_11 {
    public static void main(String[] args) {
        Octagon octagon1 = new Octagon(5, "blue", true);
        Octagon octagon2 = (Octagon) octagon1.clone();
        System.out.println("Octagon 1: " + octagon1);
        System.out.println("Octagon 2: " + octagon2);
        System.out.println("Octagon 1 area: " + octagon1.getArea());
        System.out.println("Octagon 2 area: " + octagon2.getArea());
        System.out.println("Octagon 1 compareTo Octagon 2: " + octagon1.compareTo(octagon2));
    }
}
