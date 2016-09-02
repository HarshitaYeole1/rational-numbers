package RationalNumbers;

/**
 * @author Harshita
 * @version 1
 * @since 2016
 * <p>
 * Created by harshita on 31/8/16.
 */
class RationalNumber extends Number implements Comparable<RationalNumber> {

    private long numerator;
    private long denominator;


    RationalNumber() {
        this.numerator = 0;
        this.denominator = 1;

    }

    RationalNumber(long numerator, long denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("denominator cannot be zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        reduce(this);
    }

    public long getNumerator() {
        return this.numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    /**
     * Calculates gcd of two rational numbers
     *
     * @param numerator  long numerator
     * @param denominator  long denominator
     * @return Long returns GCD
     */
    @TestMe()
    private long gcd(long numerator, long denominator) throws NullPointerException {
        long x;
        while (denominator != 0) {
            x = numerator % denominator;
            numerator = denominator;
            denominator = x;
        }
        return numerator;

    }


    /**
     * Rational object is reduced to their lowest terms.
     *
     * @param number RationalNumber
     * @return void
     */
    @TestMe
    private void reduce(RationalNumber number) {
        // long common = gcd(Math.abs(number.numerator), number.denominator);
        long common = gcd((number.numerator), number.denominator);
        number.numerator = number.numerator / common;
        number.denominator = number.denominator / common;
    }


    /**
     * Calculates addition of two rational numbers.
     *
     * @param numberTwo  RationalNumber
     * @return RationalNumbers.RationalNumber addition of two rational numbers
     */
    //@TestMe(value1 = 6)
    public RationalNumber addition(RationalNumber numberTwo) {

        long myDenominator = denominator * numberTwo.denominator;
        long firstValue = numerator * numberTwo.denominator;
        long secondValue = numberTwo.numerator * denominator;
        long myNumerator = firstValue + secondValue;
        RationalNumber answer = new RationalNumber(myNumerator, myDenominator);
        reduce(answer);
        return answer;

    }

    /**
     * Calculates subtraction of two rational numbers
     *
     * @param numberTwo  RationalNumber
     * @return RationalNumbers.RationalNumber subtraction of two rational numbers
     */
    public RationalNumber subtract(RationalNumber numberTwo) {
        long myDenominator = denominator * numberTwo.denominator;
        long firstValue = numerator * numberTwo.denominator;
        long secondValue = numberTwo.numerator * denominator;
        long myNumerator = firstValue - secondValue;
        RationalNumber answer = new RationalNumber(myNumerator, myDenominator);
        reduce(answer);
        return answer;
    }

    /**
     * Calculates multiplication of two rational numbers
     *
     * @param numberTwo  RationalNumber
     * @return RationalNUmber MUltiplication of two rational numbers
     */
    public RationalNumber multiply(RationalNumber numberTwo) {

        long myDenominator = denominator * numberTwo.denominator;
        long myNumerator = numerator * numberTwo.numerator;
        RationalNumber answer = new RationalNumber(myNumerator, myDenominator);
        reduce(answer);
        return answer;
    }

    /**
     * Calculates division of two rational numbers
     *
     * @param numberTwo  RationalNUmber
     * @return RationalNumbers.RationalNumber
     */
    public RationalNumber divide(RationalNumber numberTwo) {

//        long temp = numberTwo.numerator;
//        numberTwo.numerator = denominator;
//        numberTwo.denominator = temp;

        long myDenominator = denominator * numberTwo.numerator;
        long myNumerator = numerator * numberTwo.denominator;
        RationalNumber answer = new RationalNumber(myNumerator, myDenominator);
        reduce(answer);
        return answer;

    }

    /**
     * String representation of the RationalNUmber
     *
     * @return String
     */
    @Override
    public String toString() {

        if (getDenominator() == 1) {
            return (getNumerator() + "");
        }
        if (getDenominator() == -1) {
            return ("-" + getNumerator());
        }
        if (getDenominator() < 0) {
            return ("-" + getNumerator() + "/" + Math.abs(getDenominator()));
        }
        return (getNumerator() + "/" + getDenominator());

    }

    /**
     * integer value of the rational number
     *
     * @return Integer
     */
    @Override
    public int intValue() {
        return (int) ((int) numerator / denominator);
    }

    /**
     * long value of the rational number
     *
     * @return Long
     */
    @Override
    public long longValue() {
        return (long) numerator / denominator;
    }

    /**
     * Float value of the rational number
     *
     * @return Float
     */
    @Override
    public float floatValue() {
        return (float) numerator / denominator;
    }

    /**
     * double value of the rational number
     *
     * @return double
     */
    //@TestMe
    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }

    /**
     * Compares one rational number with the other
     *
     * @param number RationalNUmber
     * @return Integer
     */

    @Override
    public int compareTo(RationalNumber number) {

        if (number == null) {
            throw new NullPointerException();
        } else if (!(number instanceof RationalNumber)) {
            throw new ClassCastException();
        }
        if (this.doubleValue() == number.doubleValue()) {
            return 0;
        } else if (this.doubleValue() > number.doubleValue()) {
            return 1;
        } else {
            return -1;
        }

    }
}




