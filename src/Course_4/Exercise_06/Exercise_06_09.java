package Course_4.Exercise_06;

public class Exercise_06_09 {

  public static void main(String[] args) {
    System.out.println(
      "Feet    Meters        Meters  Feet\n" +
      "------------------------------------------");
    for (double feet = 1.0, meters = 20.0; feet <= 10.0; feet++, meters += 5) {
      System.out.printf("%-8.1f%-14.3f%-8.1f%-6.3f\n",
        feet, footToMeter(feet), meters, meterToFoot(meters));
    }
  }

  public static double footToMeter(double foot){
    return 0.305 * foot;
  }

  public static double meterToFoot(double meter){
    return 3.279 * meter;
  }
}
