public class Main {
    public static void main(String[] args) {
        printHello();
        System.out.println(hello("Anton"));

        System.out.printf("%s * %s = %s%s", 2, 3, multiply(2, 3), System.lineSeparator());
        System.out.printf("%s * %s = %s%s", 2.0, 3.0, multiply(2.0, 3.0), System.lineSeparator());
        System.out.printf("%s * %s * %s = %s%s", 2, 3, 4, multiply(2, 3, 4), System.lineSeparator());

        System.out.printf("%s! = %s%s", 3, factorial(3), System.lineSeparator());
    }

    public static void printHello() {
        System.out.println("Hello World");
    }

    public static String hello(String name) {
        return "Hello " + name;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static int multiply(int a, int b, int c) {
        return a * b * c;
    }

    /**
     * 3! = 3 * 2 * 1 = 6
     * 3! = 3 * 2! = 6
     * <p>
     * 3! = 3 * 2 * 1 * 0! * -1!...
     * <p>
     * <p>
     * factorial(3)
     * 3 * factorial(2)
     * 2 * factorial(1)
     * 1 (базовый случай)
     * -> 2 * 1 = 2
     * -> 3 * 2 = 6
     * -> 6
     */
    static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
