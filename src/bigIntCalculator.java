import java.math.BigInteger;

public class bigIntCalculator extends numericCalculator{
    private number a;
    private number b;
    private BigInteger bigIntStr1;
    private BigInteger bigIntStr2;
    //records number and also records the big integer inside
    public bigIntCalculator(bigIntNum a, bigIntNum b) {
        this.a = a;
        this.b = b;
        bigIntStr1 = new BigInteger(a.toString());
        bigIntStr2 = new BigInteger(b.toString());
    }
    //add method
    @Override
    public number add() {
        number c = new bigIntNum(bigIntStr1.add(bigIntStr2));
        return c;
    }
    //sub method
    @Override
    public number sub() {
        number c = new bigIntNum(bigIntStr1.subtract(bigIntStr2));
        return c;
    }
    //mult method
    @Override
    public number mult() {
        number c = new bigIntNum(bigIntStr1.multiply(bigIntStr2));
        return c;
    }
    //div method
    @Override
    public number div() {
        number c = new bigIntNum(bigIntStr1.divide(bigIntStr2));
        return c;
    }
    //to string, prints both numbers a and b.
    @Override
    public String toString() {
        return "bigInt1: " + a.toString() + "\nbigInt2: " + b.toString();
    }
}
