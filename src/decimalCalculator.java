public class decimalCalculator extends numericCalculator{
    private number a;
    private number b;
    //takes two decimal numbers
    public decimalCalculator(decNum a, decNum b) {
        this.a = a;
        this.b = b;
    }
    //add method
    @Override
    public number add() {
        number c = new decNum(a.convertToDec() + b.convertToDec());
        return c;
    }
    //sub method
    @Override
    public number sub() {
        number c = new decNum(a.convertToDec() - b.convertToDec());
        return c;
    }
    //mult method
    @Override
    public number mult() {
        number c = new decNum(a.convertToDec() * b.convertToDec());
        return c;
    }
    //divide method
    @Override
    public number div() {
        number c = new decNum(a.convertToDec() / b.convertToDec());
        return c;
    }

    //to string, prints both number a and b.
    @Override
    public String toString() {
        return "dec1: " + a.toString() + " dec2: " + b.toString();
    }
}
