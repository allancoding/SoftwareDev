package Course_4.Chapter_10;

public class Exercise_10_02 {
    public static void main(String[] args) {
        MyInteger myInteger = new MyInteger(5);
        MyInteger myInteger2 = new MyInteger(6);
        System.out.println("MyInteger:");
        System.out.println("Value: " + myInteger.getValue());
        System.out.println("Even: " + myInteger.isEven());
        System.out.println("Odd: " + myInteger.isOdd());
        System.out.println("Prime: " + myInteger.isPrime());
        System.out.println("MyInteger 2:");
        System.out.println("Even: " + MyInteger.isEven(4));
        System.out.println("Odd: " + MyInteger.isOdd(4));
        System.out.println("Prime: " + MyInteger.isPrime(4));
        System.out.println("MyInteger equals 5: " + myInteger.equals(5));
        System.out.println("MyInteger 2 equals 6: " + myInteger2.equals(6));
        System.out.println("MyInteger equals MyInteger 2: " + myInteger.equals(myInteger2));
        System.out.println("Parse int from char array: " + MyInteger.parseInt(new char[]{'1', '2', '3'}));
        System.out.println("Parse int from string: " + MyInteger.parseInt("123"));
    }
}

class MyInteger {
    private int value;
    public MyInteger(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public boolean isEven() {
        return value % 2 == 0;
    }
    public boolean isOdd() {
        return value % 2 != 0;
    }
    public boolean isPrime() {
        for (int i = 2; i < value; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static boolean isEven(int value) {
        return value % 2 == 0;
    }
    public static boolean isOdd(int value) {
        return value % 2 != 0;
    }
    public static boolean isPrime(int value) {
        for (int i = 2; i < value; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static boolean isEven(MyInteger value) {
        return value.value % 2 == 0;
    }
    public static boolean isOdd(MyInteger value) {
        return value.value % 2 != 0;
    }
    public static boolean isPrime(MyInteger value) {
        for (int i = 2; i < value.value; i++) {
            if (value.value % i == 0) {
                return false;
            }
        }
        return true;
    }
    public boolean equals(int value) {
        return this.value == value;
    }
    public boolean equals(MyInteger value) {
        return this.value == value.value;
    }
    public static int parseInt(char[] chars) {
        int value = 0;
        for (int i = 0; i < chars.length; i++) {
            value += (chars[i] - '0') * Math.pow(10, chars.length - i - 1);
        }
        return value;
    }
    public static int parseInt(String string) {
        int value = 0;
        for (int i = 0; i < string.length(); i++) {
            value += (string.charAt(i) - '0') * Math.pow(10, string.length() - i - 1);
        }
        return value;
    }
}