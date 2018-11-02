package examples.first.test2;

import examples.first.test.Test;

public class Test1 extends Test{
    void testtesttest(){
        String b = new String("a");
        b.equals(EnumTest.TEST2);
        Integer a = new Integer(1);
        a.equals(intTest);
    }

    static void testtest(){
        String b = new String("a");
        b.equals(EnumTest.TEST2);
        Integer a = new Integer(1);
//        a.equals(intTest);
    }

    public static void main(String[] args) {
        examples.first.test.Test test = new examples.first.test.Test();
        Test.Test3 test3 = test.new Test3();
        test3.test();
        EnumTest test2 = Test.EnumTest.TEST2;

        ExtendingClass extendingClass = new ExtendingClass();
//        new AbstractClass()

        OnlyStaticClass.upA();
        System.out.println(OnlyStaticClass.getA());
    }
}
