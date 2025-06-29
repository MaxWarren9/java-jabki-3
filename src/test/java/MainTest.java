import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainTest {
    @Test
    public void hello() {
        String name = "Котик";
        Assertions.assertEquals("Hello " + name, Main.hello(name));
    }

    @Test
    public void multiply() {
        int a = 2;
        int b = 3;
        Assertions.assertEquals(a * b, Main.multiply(a, b));
    }

    @Test
    public void sumRange_IntegerNumbers_ReturnsCorrectSum() {
        Assertions.assertEquals(9, Main.sumRange(2, 4));
        Assertions.assertEquals(0, Main.sumRange(0, 0));
        Assertions.assertEquals(3, Main.sumRange(3, 3));
        Assertions.assertEquals(0, Main.sumRange(-3, 3));
    }

    @Test
    public void sumRange_FirstNumberIsBiggerThanSecondNumber_ThrowsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Main.sumRange(3, 2));
    }

    @Test
    public void add_IntegerNumbers_ReturnsCorrectSum() {
        Assertions.assertEquals(3, Main.add(1, 2));
        Assertions.assertEquals(0, Main.add(500, -500));
        Assertions.assertEquals(0, Main.add(0, 0));
        Assertions.assertEquals(-5, Main.add(-2, -3));
    }

    @Test
    public void add_TwoMaxIntegers_ReturnsException() {
        assertThrows(ArithmeticException.class, () -> Main.add(2147483647, 2147483647));
    }

    @Test
    public void add_Strings_ReturnsConcatenatedStrings() {
        Assertions.assertEquals("Hello", Main.add("He", "llo"));
        Assertions.assertEquals("Hello1", Main.add("Hello", "1"));
        Assertions.assertEquals("Hello", Main.add("", "Hello"));
    }

    @Test
    public void findMax_ArrayOfIntegers_ReturnsCorrectMaxValue() {

        Assertions.assertEquals(5, Main.findMax(new int[]{1, 2, 3, 4, 5}));
        Assertions.assertEquals(0, Main.findMax(new int[]{-1, -2, -3, 0, -4}));
        Assertions.assertEquals(-1, Main.findMax(new int[]{-1, -2, -3, -4}));
    }

    @Test
    public void findMax_EmptyArray_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> Main.findMax(new int[]{}));
    }

    @Test
    public void calculateFactorial_NaturalNumber_ReturnsCorrectFactorial() {
        Assertions.assertEquals(120, Main.calculateFactorial(5));
        Assertions.assertEquals(1, Main.calculateFactorial(1));
        Assertions.assertEquals(1, Main.calculateFactorial(0));
    }

    @Test
    public void calculateFactorial_NegativeNumber_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> Main.calculateFactorial(-5));
    }

    @Test
    public void calculateArea_RadiusCorrectValue_ReturnsCorrectSquare() {
        Assertions.assertEquals(78.54, Main.calculateArea(5));
        Assertions.assertEquals(3.14, Main.calculateArea(1));
        Assertions.assertEquals(0, Main.calculateArea(0));
    }

    @Test
    public void calculateArea_LengthAndWidthCorrectValue_ReturnsCorrectSquare() {
        Assertions.assertEquals(12, Main.calculateArea(3, 4));
        Assertions.assertEquals(3, Main.calculateArea(3, 1));
        Assertions.assertEquals(0, Main.calculateArea(0, 4));
    }

    @Test
    public void calculateArea_RadiusIncorrectValue_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> Main.calculateArea(-1));
    }

    @Test
    public void calculateArea_LengthOrWidthIncorrectValue_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> Main.calculateArea(-1, 3));
        assertThrows(IllegalArgumentException.class, () -> Main.calculateArea(1, -3));
        assertThrows(IllegalArgumentException.class, () -> Main.calculateArea(-1, -3));
    }

    @Test
    public void calculateAverage_CorrectValues_ReturnsCorrectAverage() {
        Assertions.assertEquals(4, Main.calculateAverage(3, 4, 5));
        Assertions.assertEquals(2.66, Main.calculateAverage(4, 0, 4), 0.01);
        Assertions.assertEquals(-4, Main.calculateAverage(-4, -4, -4));
        Assertions.assertEquals(0, Main.calculateAverage(0, 0, 0));
        Assertions.assertEquals(0.33, Main.calculateAverage(0, 0.33, 0.66), 0.01);
    }

    @Test
    public void calculateHypotenuse_CorrectValues_ReturnsCorrectHypotenuse() {
        Assertions.assertEquals(5, Main.calculateHypotenuse(3, 4), 0);
        Assertions.assertEquals(35.35, Main.calculateHypotenuse(25, 25), 0.01);
        Assertions.assertEquals(2.23, Main.calculateHypotenuse(1, 2), 0.01);
    }

    @Test
    public void calculateHypotenuse_OneOrBothCathetiAreLessOrEqualToZero_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> Main.calculateHypotenuse(3, 0));
        assertThrows(IllegalArgumentException.class, () -> Main.calculateHypotenuse(0, 3));
        assertThrows(IllegalArgumentException.class, () -> Main.calculateHypotenuse(0, 0));
        assertThrows(IllegalArgumentException.class, () -> Main.calculateHypotenuse(0, -3));
        assertThrows(IllegalArgumentException.class, () -> Main.calculateHypotenuse(-1, -3));
    }

}
