public class decToHex {
    private int a;
    //records decimal.
    public decToHex(int a) {
        this.a = a;
    }
    //converts decimal number into hexadecimal number.
    public String convertDecToHex() {
        int temp = Math.abs(a);
        String conversion = "0123456789ABCDEF";
        String hex = "";
        int b = 0;

        if(temp == 0) {
            return "0";
        }
        while (temp > 0) {
            b = temp % 16;
            hex = conversion.charAt(b) + hex;
            temp = temp/16;
        }
        if(a < 0) {
            hex = "-" + hex;
        }
        return hex;
    }
}
