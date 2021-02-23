public class hexNum extends number{
    private String a;
    //takes hex number.
    public hexNum(String a) {
        this.a = a;
    }
    //converts hex to dec.
    @Override
    public double convertToDec() {
        hexToDec b = new hexToDec(a);
        return (double) b.convertHexToDec();
    }


    //returns hex number.
    @Override
    public String toString() {
        return a;
    }
}
