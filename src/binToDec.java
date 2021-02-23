public class binToDec {
   private String a;
    //converts binToDec
    public binToDec(String a){
        this.a = a;
    }
    //converting a binary number into a decimal number.
    public int convertBinToDec() {
        int binary = Integer.parseInt(a); //converts String binary to int.
        int decimal = 0, n = 0;

        while (binary != 0) {
            int temp = binary % 10;
            decimal += temp * Math.pow(2, n);
            binary = binary/10;
            n++;
        }
        return decimal;
    }
}
