public class binaryNum extends number {
    private String a;
    //constructor;
    public binaryNum(String a) {
        this.a = a;
    }
    //returns the binary number.
    public String get() { return a; }
    //converts bin to dec.
    @Override
    public double convertToDec() {
        binToDec b = new binToDec(a);
        return (double) b.convertBinToDec();
    }
    //toString() method, returns the binary number.
    @Override
    public String toString() { return a; }

}
