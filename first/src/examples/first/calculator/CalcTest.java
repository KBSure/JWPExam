package examples.first.calculator;

public class CalcTest {
    public static void main(String[] args) {
        Calc cal1 = new Calc();

        System.out.println(cal1.getValue());

        cal1.plus(50);

        System.out.println(cal1.getValue());

        cal1.plus(100);

        System.out.println(cal1.getValue());

        cal1.minus(10);

        System.out.println(cal1.getValue());

        cal1.multiply(2);

        System.out.println(cal1.getValue());

        cal1.divide(3);

        System.out.println(cal1.getValue());

        cal1.clear();

        System.out.println(cal1.getValue());

    }
}
