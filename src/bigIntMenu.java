import java.math.BigInteger;
import java.util.Scanner;

public class bigIntMenu {

    public bigIntMenu(Scanner s) {
        bigIntCalc(s);
    }

    //further processing for bigIntCalc
    public number bigIntCalculation(bigIntNum x, bigIntNum y, String choice) {
        numericCalculator finalDecimal = new bigIntCalculator(x, y);
        if(choice.equals("+")) {
            return finalDecimal.add();
        } if(choice.equals("-")) {
            return finalDecimal.sub();
        } if(choice.equals("x")) {
            return finalDecimal.mult();
        } if(choice.equals("/")) {
            return finalDecimal.div();
        } else throw new IllegalArgumentException("You do not have a proper sign."); //If String choice does not match, wrong input.
    }
    //menu for bigInt Calculator
    public void bigIntCalc(Scanner s) {
        boolean resume = true;

        while(resume) {
            int b = 0;

            try {
                System.out.print("\nB I G  I N T  C A L C U L A T O R\n1.BigInt calculation\n" +
                        "2.exit\nUser: ");
                try {
                    b = s.nextInt(); //must be a valid number or else throws exception.
                } catch (Exception e) {
                    System.err.println("Not a number.");
                    s.nextLine();
                    throw e;
                }
                if (b == 1) {
                    int input = 0;
                    bigIntNum x, y;
                    String choice;
                    System.out.print("\nx value: ");
                    BigInteger bigInt = BigInteger.valueOf(s.nextLong());
                    x = new bigIntNum(bigInt);
                    System.out.print("\ny value: ");
                    BigInteger bigInt2 = BigInteger.valueOf(s.nextLong());
                    y = new bigIntNum(bigInt2);
                    System.out.print("(+ - x /)?: ");
                    choice = s.next();
                    number finalNum = bigIntCalculation(x, y, choice);
                    System.out.print("\nDecimal value: " + finalNum.toString());
                } if (b == 2) {
                    resume = false;
                } else if (b < 1 || b > 2) {
                    throw new Exception();
                }
            } catch(Exception e) {
                System.out.println("\nIncorrect input. Please try again.");
                resume = true;
            }
        }
    }

}
