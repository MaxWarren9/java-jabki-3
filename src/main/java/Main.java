import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        printHello();
        System.out.println(hello("Anton"));

        System.out.printf("%s * %s = %s%s", 2, 3, multiply(2, 3), System.lineSeparator());
        System.out.printf("%s * %s = %s%s", 2.0, 3.0, multiply(2.0, 3.0), System.lineSeparator());
        System.out.printf("%s * %s * %s = %s%s", 2, 3, 4, multiply(2, 3, 4), System.lineSeparator());

        System.out.printf("%s! = %s%s", 3, factorial(3), System.lineSeparator());

//        Домашнее задание. 1.
        int a = 5;
        int b = 9;
        System.out.printf("Сумма чисел между %d и %d включительно равна %d", a, b, sumRange(a,b));
        System.out.println();

//        2.

        String greeting = "Привет, друг! \n";
        String feeling = "Как ты себя чувствуешь?";
        System.out.println(add(greeting, feeling));
        System.out.println(add(a, b));

//        3.
        int[] list = new int[]{1, 2, 52, 4, 32, -5};
        System.out.println(findMax(list));

//        4.
        System.out.println(calculateFactorial(3));

//        5.
        System.out.println(calculateArea(5));

        System.out.println(calculateArea(3, 4));

//        6.
        System.out.println(calculateAverage(2, 5, 9));

//        7.
        System.out.println(calculateHypotenuse(15, 8));
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


    /*
    Домашнее задание.
    1. Создайте метод sumRange, который принимает два числа
    (начало и конец диапазона) и возвращает сумму всех чисел между ними (включительно).
    2. Создайте два перегруженных метода add:
        Первый складывает два целых числа;
        Второй складывает две строки.
    3. Напишите метод findMax, который принимает массив целых чисел
        и возвращает его максимальный элемент.
    4. Напишите метод, вычисляющий факториал числа с помощью цикла for
    5. Создайте перегруженные методы calculateArea:
        Для круга (принимает радиус);
        Для прямоугольника (принимает длину и ширину).
    6. Реализуйте метод, который принимает три числа и возвращает их среднее арифметическое.
    7. Напишите метод, который принимает два числа, представляющие длины катетов,
        и возвращает длину гипотенузы (используйте теорему Пифагора).
     */

    // Метод 1. сумма чисел

    public static int sumRange(int a, int b) {
        if (a > b) {
            throw new IllegalArgumentException("Первое число в диапазоне должно быть меньше второго числа. Введите корректные параметры для чисел.");
        }
            int sum = 0;
            for (int i = a; i <= b; i++) {
                sum += i;
            }
            return sum;
    }

//    Метод 2. Сумма чисел и конкатенация

    public static int add(int a, int b) {
        long result = (long) a + b;
        if (result > Integer.MAX_VALUE) {
            throw new ArithmeticException("Сумма чисел больше максимально допустимой.");
        }
        return (int) result;
    }

    public static String add(String one, String two) {
        return one + two;
    }

//    Метод 3. Максимальное значение массива

    public static int findMax(int[] numbers) {
        if (numbers.length == 0 || numbers == null) {
            throw new IllegalArgumentException("Данный метод не работает с пустым массивом.");
        }
        int biggestNumber = numbers[0];
        for (int num : numbers) {
            if (num > biggestNumber) {
                biggestNumber = num;
            }
        }
        return biggestNumber;
    }

//    Метод 4. Вычисление факториала числа через цикл for

    public static int calculateFactorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Факториал может быть посчитан только для целых неотрицательных значений");
        }
        int factorial = 1;
        for (int i = number; i > 0; i--) {
            factorial *= i;
        }
        return factorial;
    }

//    Метод 5. Расчет площади круга и прямоугольника (с точностью до двух знаков для круга)

    public static double calculateArea(int radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Введите положительное значение радиуса.");
        }
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.getDefault());
        otherSymbols.setDecimalSeparator('.');
        String pattern = "0.##";
        DecimalFormat decimalFormat = new DecimalFormat(pattern, otherSymbols);
        String result = decimalFormat.format(Math.PI * Math.pow(radius, 2));
        return Double.parseDouble(result);
    }

    public static int calculateArea(int length, int width) {
        if (length < 0 || width < 0) {
            throw new IllegalArgumentException("Введите положительные значения сторон.");
        }
        return length * width;
    }

//    Метод 6. Расчет среднего арифметического для трех чисел

    public static double calculateAverage(double firstNumber, double secondNumber, double thirdNumber) {
        return (firstNumber + secondNumber + thirdNumber) / 3;
    }

//    Метод 7. Расчет длины гипотенузы по двум катетам

    public static double calculateHypotenuse(double cathetus1, double cathetus2) {
        if (cathetus1 <= 0 || cathetus2 <= 0) {
            throw new IllegalArgumentException("Катет не может быть меньше или равен 0");
        }
        double poweredHypotenuse = Math.pow(cathetus1, 2) + Math.pow(cathetus2, 2);
        return Math.sqrt(poweredHypotenuse);
    }
}

