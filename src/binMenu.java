import java.util.Scanner;

public class binMenu {

    public binMenu(Scanner s) {
        bCalc(s);
    }

    //check is the binary number is and actual binary number.
    public void checkBinary(String a) {
        int temp = Integer.parseInt(a);

        while (temp != 0) {
            if (temp % 10 > 1) {
                throw new IllegalArgumentException("This is not a binary number.");
            } else temp = temp / 10;
        }
    }


    //menu for binary calculator. Includes test mode.
    public void bCalc(Scanner s) {
        boolean resume = true;

        while(resume) {
            int b = 0;

            try {
                System.out.print("\nB I N A R Y  C A L C U L A T O R\n1.Binary Calculation\n" +
                        "2.Covert Binary Value to Decimal\n3.Convert Decimal Value to Binary\n" +
                        "4.Test Mode\n5.Exit\nUser: ");
                try {
                    b = s.nextInt(); //must be a valid number or else throws exception.
                } catch (Exception e) {
                    System.err.println("Not a number.");
                    s.nextLine();
                    throw e;
                }
                if (b == 1) {
                    String binaryA, binaryB;
                    String choice;
                    System.out.print("\nBinary A: ");
                    binaryA = s.next();
                    System.out.print("Binary B: ");
                    binaryB = s.next();
                    System.out.print("(+ - x /)?: ");
                    choice = s.next();
                    binaryCalculation(binaryA, binaryB, choice);
                } if (b == 2) {
                    System.out.print("\nBinary Value: ");
                    String binaryNumber= s.next();
                    checkBinary(binaryNumber);
                    binaryNum convert = new binaryNum(binaryNumber);
                    int decimal = (int) convert.convertToDec();
                    System.out.println("Decimal Value: " + decimal + "\n");
                } if (b == 3) {
                    System.out.print("\nDecimal Value: ");
                    int decimal = s.nextInt();
                    decToBin convert = new decToBin(decimal);
                    binaryNum binaryNumber = new binaryNum(convert.convertDecToBin());
                    System.out.println("Binary Value: " + binaryNumber.toString() + "\n");
                } if (b == 4) {
                    String binaryA = "10101010", binaryB = "11001100";
                    int decimal = 170;
                    System.out.print("\nA = 10101010, B = 11001100, C = 170\n\nA+B =");
                    binaryCalculation(binaryA, binaryB, "+");
                    System.out.print("Expected Binary: 0101110110\nExpected Decimal: 374\n\n");
                    System.out.print("A-B =");
                    binaryCalculation(binaryA, binaryB, "-");
                    System.out.print("Expected Binary: -0100010\nExpected Decimal: -34\n\n");
                    System.out.print("AxB =");
                    binaryCalculation(binaryA, binaryB, "x");
                    System.out.print("Expected Binary: 01000011101111000\nExpected Decimal: 34680\n\n");
                    System.out.print("A/B =");
                    binaryCalculation(binaryA, binaryB, "/");
                    System.out.print("Expected Binary: 0 remainder : 010101010\nExpected Decimal: 0 remainder : 170\n\n");
                    decToBin convert = new decToBin(decimal);
                    System.out.print("170 into binary =\n\n" + "Binary Value: " + convert.convertDecToBin() + "\n");
                    System.out.print("Expected Binary: 010101010\n\n");
                } if (b == 5) {
                    resume = false;
                } else if (b < 1 || b > 5) {
                    throw new Exception();
                }
            } catch(Exception e) {
                System.out.println("\nIncorrect input. Please try again.");
                resume = true;
            }
        }
    }
    //returns results of users equation in decimal
    public number displayEquationResults(numericCalculator finalDecimal, String choice) {
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

    public void binaryCalculation(String binaryA, String binaryB, String choice) {
        decToBin finalBinary;
        int remainder = 0;
        decNum aDecimal;
        decNum bDecimal;
        number finalDecimal;
        numericCalculator calcDecimal;
        checkBinary(binaryA); //checks both binary numbers if both are binary.
        checkBinary(binaryB);

        number a = new binaryNum(binaryA);
        number b = new binaryNum(binaryB);

        aDecimal = new decNum((int) a.convertToDec());
        bDecimal = new decNum((int) b.convertToDec());
        calcDecimal = new decimalCalculator(aDecimal, bDecimal);

        finalDecimal = displayEquationResults(calcDecimal, choice);

        finalBinary = new decToBin((int) finalDecimal.convertToDec());

        System.out.println("\nBinary Value: " + finalBinary.convertDecToBin() + "\nDecimal Value: "
                    + finalDecimal.convertToDec() + "\n");
    }

}
