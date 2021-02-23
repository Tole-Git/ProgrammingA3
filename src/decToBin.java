public class decToBin {
    private int a;
    //records decimal.
    public decToBin(int a) {
        this.a = a;
    }
    //converts decimal into binary number.
    public String convertDecToBin() {
        String b = "";
        int c = Math.abs(a); //creates an absolute value of a. decimal must be positive in order to compute.
        int binary[] = new int[50];
        int index = 0;

        while(c > 0) {
            binary[index++] = c % 2;
            c = c/2;
        }
        if(a < 0) { //if a is a negative number, simply add a negative sign.
            b = "-";
        }
        for(int i = index; i >= 0; i--) {
            b = b + binary[i];
        }
        return b;
    }
}
