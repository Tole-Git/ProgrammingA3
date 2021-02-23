public class decNum extends number {
    private double a;
    //constructor receives int and stores value.
    public decNum(double a) {
        this.a = a;
    }
    //returns encapsulated value.
    public double convertToDec() {
        return a;
    }
    //to string method. returns int into string.
    public String toString() {
        String b = "";
        b += a;
        return b;
    }
}
