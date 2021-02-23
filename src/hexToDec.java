public class hexToDec {
    private String a;
    //takes hex value.
    public hexToDec(String a) {
        this.a = a;
    }
    //converts hexadecimal number into a decimal number.
    public int convertHexToDec() {

        String conversion = "0123456789ABCDEF"; //since ABCDEF is 10-15, we had theses letters to 0-9.
        a = a.toUpperCase();
        int decimal = 0;

        for (int i = 0; i < a.length(); i++) {
            char b = a.charAt(i); //check orginal string
            int c = conversion.indexOf(b); //verify this number/letter.
            decimal = 16*decimal + c;
        }
        return decimal;
    }
}
