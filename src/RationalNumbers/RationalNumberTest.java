package RationalNumbers;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by harshita on 31/8/16.
 */
public class RationalNumberTest {


    RationalNumber number1;
    RationalNumber number2;
    RationalNumber number3;

    @Before
    public void setUp() throws Exception {
        number1=new RationalNumber(6l,12l);
        number1=new RationalNumber(3l,9l);

    }

    
 
    @Test
    public void itShouldCompareToOneRationalNumberToOther() throws Exception {
        int expected=1;
        int actual= number1.compareTo(number2);
        assertEquals("The number is bigger",expected,actual);
    }

    @Test
    public void itShouldDoAdditionOfTwoRationalNumbers() throws Exception {

        String expected="5/6";
        String actual= number1.addition(number2).toString();
        assertEquals("test passed",expected,actual);

    }

    @Test
    public void itShouldDoSubtractionOfTwoRationalNumbers() throws Exception {
        String expected="1/6";
        String actual= number1.subtract(number2).toString();
        assertEquals("test passed",expected,actual);
    }

    @Test
    public void itShouldDoMultiplicationOfTwoRationalNumbers() throws Exception {
        String expected="1/6";
        String actual= number1.multiply(number2).toString();
        assertEquals("test passed",expected,actual);
    }

    @Test
    public void itShouldDoDivisionOfTwoRationalNumbers() throws Exception {
        String expected="3/2";
        String actual= number1.divide(number2).toString();
        assertEquals("test passed",expected,actual);
    }

    @Test
    public void itShouldReturnIntValueOfRationalNumber() throws Exception {
        int expected=0;
        int actual= number1.intValue();
        assertEquals(expected,actual);

    }

    @Test
    public void itShouldReturnLongValueOfRationalNumber() throws Exception {

        long expected=0;
        long actual= number1.longValue();
        assertEquals(expected,actual);
    }

    @Test
    public void itShouldReturnFloatValueOfRationalNumber() throws Exception {
        float expected=0.5F;
        float actual= number1.floatValue();
        assertEquals(expected,actual,0.0001);
    }

    @Test
    public void itShouldReturnDoubleValueOfRationalNumber() throws Exception {
        double expected=0.5;
        double actual= number1.doubleValue();
        assertEquals(expected,actual,0.0001);
    }

    @Test
    public void testDoubleValue() throws InvocationTargetException, IllegalAccessException {
        Class<RationalNumber> classRational = RationalNumber.class;
        Method[] methods = classRational.getDeclaredMethods();
        List<Method> list = new ArrayList<>();

        Method methodToTest = null;
        for (Method method : methods) {
            if (method.isAnnotationPresent(TestMe.class)) {
                methodToTest = method;
            }
        }
        methodToTest.setAccessible(true);
        double value = (Double) methodToTest.invoke(number1);
        double expected = 0.5;
        assertEquals(value, expected, 0.0001);
    }



    @Test
    public void testGcd() throws InvocationTargetException, IllegalAccessException {
        Class<RationalNumber> classRational = RationalNumber.class;
        Method[] methods = classRational.getDeclaredMethods();
        List<Method> list = new ArrayList<>();
        Method gcdMethod = null, reductionMethod = null;

        for (Method method : methods) {
            if (method.isAnnotationPresent(TestMe.class)) {
                list.add(method);
            }
        }

        for (Method method : list) {
            if (method.getName().equalsIgnoreCase("gcd")) {
                gcdMethod = method;
            }
            if (method.getName().equalsIgnoreCase("reduce")) {
                reductionMethod = method;
            }
        }
        reductionMethod.setAccessible(true);
        reductionMethod.invoke(number1,number1);
        assertEquals(number1.getNumerator(), 1l);
        gcdMethod.setAccessible(true);
        long gcd = (long) gcdMethod.invoke(number1, 4l, 8l);
        assertEquals(gcd, 4l);
    }


}