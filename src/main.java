import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = 0;

        while(!(a == 6)) {
            int b = 0;
            System.out.print("what would you like to do?\n1.Binary Calculator\n2.Hex Calculator\n" +
                    "3.Bandwidth Calculator\n4.Decimal Calculator\n5.BigInt Calculator\n6.Exit\nUser: ");
            try {
                b = s.nextInt();
            } catch (Exception e) {
                System.err.println("Not a number.");
                s.nextLine();
            }

            if (b == 1) {
                new binMenu(s);
            } if (b == 2) {
                new hexMenu(s);

            } if (b == 3) {
                new bandCalc(s);

            } if (b ==4) {
                new decMenu(s);

            } if (b == 5) {
                new bigIntMenu(s);
            } if(b == 6) {
                a = b;
            }
            System.out.println();
        }
    }

    
}
