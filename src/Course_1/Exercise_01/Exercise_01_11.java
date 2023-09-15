package Course_1.Exercise_01;
public class Exercise_01_11 {
    public static void main(String[] args) {
        int population = 312032486;
        int year = 5;
        int seconds = 60 * 60 * 24 * 365;
        int birth = seconds / 7;
        int death = seconds / 13;
        int immigrants = seconds / 45;
        System.out.println("Current population: " + population);
        for (int i = 0; i < year; i++) {
            for (int i1 = 0; i1 < birth; i1++) {
                population++;
            }
            for (int i2 = 0; i2 < death; i2++) {
                population--;
            }
            for (int i3 = 0; i3 < immigrants; i3++) {
                population++;
            }
            System.out.println("The population after year " + (i + 1) + ": " + population);
        }
    }
}