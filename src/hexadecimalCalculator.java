public class hexadecimalCalculator extends numericCalculator {
    private number a;
    private number b;
    private int c;
    private int d;
    private hexNum remainder;
    //records hexNum and its decimal.
    public hexadecimalCalculator(hexNum a, hexNum b) {
        this.a = a;
        this.b = b;
        c = (int) a.convertToDec();
        d = (int) b.convertToDec();
    }
    //add method
    @Override
    public number add() {
        int cd = c + d;
        decToHex hex = new decToHex(cd);
        hexNum finalHex = new hexNum(hex.convertDecToHex());
        return finalHex;
    }
    //sub method
    @Override
    public number sub() {
        int cd = c - d;
        decToHex hex = new decToHex(cd);
        hexNum finalHex = new hexNum(hex.convertDecToHex());
        return finalHex;
    }
    //mult method
    @Override
    public number mult() {
        int cd = c * d;
        decToHex hex = new decToHex(cd);
        hexNum finalHex = new hexNum(hex.convertDecToHex());
        return finalHex;
    }
    //div method
    @Override
    public number div() {
        int cd = c / d;
        int remainderDecimal = c % d;

        decToHex remainderHex = new decToHex(remainderDecimal);
        remainder = new hexNum(remainderHex.convertDecToHex());

        decToHex hex = new decToHex(cd);
        hexNum finalHex = new hexNum(hex.convertDecToHex());
        return finalHex;
    }
    //getRemainder, paired with div
    public hexNum getRemainder() {
        return remainder;
    }
    //to String method, displays hexNum a and b.
    @Override
    public String toString() {
        return "hex1: " + a.toString() + " hex2: " + b.toString();
    }
}
