public class binaryCalculator extends numericCalculator {
    private number a;
    private number b;
    private int c;
    private int d;
    private binaryNum remainder;
    //records binNum and its decimal.
    public binaryCalculator(binaryNum a, binaryNum b) {
        this.a = a;
        this.b = b;
        c = (int) a.convertToDec();
        d = (int) b.convertToDec();
    }
    //add method
    @Override
    public number add() {
        int cd = c + d;
        decToBin bin = new decToBin(cd);
        binaryNum finalBin = new binaryNum(bin.convertDecToBin());
        return finalBin;
    }
    //sub method
    @Override
    public number sub() {
        int cd = c - d;
        decToBin bin = new decToBin(cd);
        binaryNum finalBin = new binaryNum(bin.convertDecToBin());
        return finalBin;
    }
    //mult method
    @Override
    public number mult() {
        int cd = c * d;
        decToBin bin = new decToBin(cd);
        binaryNum finalBin = new binaryNum(bin.convertDecToBin());
        return finalBin;
    }
    //div method
    @Override
    public number div() {
        int cd = c / d;
        int remainderDecimal = c % d;

        decToBin remainderBin = new decToBin(remainderDecimal);
        remainder = new binaryNum(remainderBin.convertDecToBin());

        decToBin bin = new decToBin(cd);
        binaryNum finalBin = new binaryNum(bin.convertDecToBin());
        return finalBin;
    }
    //getRemainder, paired with div
    public binaryNum getRemainder() {
        return remainder;
    }
    //to String method, displays binNum a and b.
    @Override
    public String toString() {
        return "binary1: " + a.toString() + " binary2: " + b.toString();
    }
}
