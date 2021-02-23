import java.math.BigInteger;

public class bigIntNum extends number{
    private BigInteger a;
    //takes big int.
    public bigIntNum(BigInteger a) {
        this.a = a;
    }
    //converts into decimal.
    @Override
    public double convertToDec() {
        return a.doubleValue();
    }
    //shows big int as a string.
    @Override
    public String toString() {
        return a.toString();
    }
}
