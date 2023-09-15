package Course_2.Exercise_08;
public class Exercise_08_5 {
    public static void main(String[] args) {
        double[][] a = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        double[][] b = {{0.0, 2.0, 4.0}, {1.0, 4.5, 2.2}, {1.1, 4.3, 5.2}};
        
        double[][] c = addMatrix(a, b);
        
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static double[][] addMatrix(double[][] a, double[][] b) {
        int rows = a.length;
        int columns = a[0].length;
        
        if (rows != b.length || columns != b[0].length) {
            throw new IllegalArgumentException("Matrices must have the same dimensions.");
        }
        
        double[][] c = new double[rows][columns];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        
        return c;
    }
        
}
