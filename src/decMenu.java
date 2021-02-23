import java.util.Scanner;

public class decMenu {

    public decMenu(Scanner s) {
        dCalc(s);
    }
    //further processing for dCalc
    public number decimalCalculation(decNum x, decNum y, String choice) {
        numericCalculator finalDecimal = new decimalCalculator(x, y);
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
    //menu for decimal calculator
    public void dCalc(Scanner s) {
        boolean resume = true;

        while(resume) {
            int b = 0;

            try {
                System.out.print("\nD E C I M A L  C A L C U L A T O R\n1.decimal calculation\n" +
                        "2.exit\nUser: ");
                try {
                    b = s.nextInt(); //must be a valid number or else throws exception.
                } catch (Exception e) {
                    System.err.println("Not a number.");
                    s.nextLine();
                    throw e;
                }
                if (b == 1) {
                    decNum x, y;
                    String choice;
                    System.out.print("\nx value: ");
                    x = new decNum(s.nextDouble());
                    System.out.print("\ny value: ");
                    y = new decNum(s.nextDouble());
                    System.out.print("(+ - x /)?: ");
                    choice = s.next();
                    number finalNum = decimalCalculation(x, y, choice);
                    System.out.print("\nDecimal value: " + finalNum.convertToDec());
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
