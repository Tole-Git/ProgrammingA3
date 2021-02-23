import java.util.Scanner;

public class hexMenu {

    public hexMenu(Scanner s) {
        hCalc(s);
    }

    public int findRemainder(int a, int b) {
        return a % b;
    }

    //Verifies if Hex
    public void checkHex(String a) {
        String conversion = "0123456789ABCDEF";

        for (int i = 0; i < a.length(); i++) {
            char b = a.charAt(i); //check orginal string
            boolean check = conversion.matches("(.*)" + b + "(.*)"); //checks to see if each number or letter
            if(check == false) {                                           //matches one inside conversion string.
                throw new IllegalArgumentException();
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
    //takes two hexadeimcal numbers and solves equation. uses convertDecToHex & convertHexToDex methods.
    public void hexCalculation(String hexA, String hexB, String choice) {
        decToHex finalHex;
        int remainder = 0;
        decNum aDecimal;
        decNum bDecimal;
        number finalDecimal;
        numericCalculator calcDecimal;

        number a = new hexNum(hexA);
        number b = new hexNum(hexB);


        aDecimal = new decNum((int) a.convertToDec());
        bDecimal = new decNum((int) b.convertToDec());
        calcDecimal = new decimalCalculator(aDecimal, bDecimal);

        finalDecimal = displayEquationResults(calcDecimal, choice);

        finalHex = new decToHex((int) finalDecimal.convertToDec());
        if(choice.equals("/")) {
            remainder = findRemainder((int) aDecimal.convertToDec(), (int) bDecimal.convertToDec());
            decToHex convert = new decToHex(remainder);
            String valueRemainder = convert.convertDecToHex();
            System.out.println("\nHex Value: " + finalHex.convertDecToHex() + " remainder : " + valueRemainder + "\nDecimal Value: "
                    + finalDecimal + " remainder : " + remainder + "\n");
        } else if(!choice.equals("/")) {
            System.out.println("\nHex Value: " + finalHex.convertDecToHex() + "\nDecimal Value: "
                    + finalDecimal + "\n");
        }
    }

    //hexadecimal calculator. Includes test mode.
    public void hCalc(Scanner s) {
        boolean resume = true;

        while(resume) {
            int b = 0;

            try {
                System.out.print("\nH E X A D E C I M A L  C A L C U L A T O R\n1.Hexadecimal Calculation\n" +
                        "2.Covert Hexadecimal Value to Decimal\n3.Convert Decimal Value to Hexadecimal\n" +
                        "4.Test Mode\n5.Exit\nUser: ");
                try {
                    b = s.nextInt(); //must be a valid number or else throws exception.
                } catch (Exception e) {
                    System.err.println("Not a number.");
                    s.nextLine();
                    throw e;
                }

                if(b == 1) {
                    String hexA = "", hexB = "";
                    String choice;
                    System.out.print("\nHexadecimal A: ");
                    hexA = s.next();
                    System.out.print("Hexadecimal B: ");
                    hexB = s.next();
                    System.out.print("(+ - x /)?: ");
                    choice = s.next();
                    hexA = hexA.toUpperCase();
                    hexB = hexB.toUpperCase();
                    checkHex(hexA);
                    checkHex(hexB);
                    hexCalculation(hexA, hexB, choice);
                } if(b == 2) {
                    System.out.print("\nHexadecimal Value: ");
                    String hexadecimalNumber= s.next();
                    checkHex(hexadecimalNumber);
                    hexNum convert = new hexNum(hexadecimalNumber);
                    int decimal = (int) convert.convertToDec();
                    System.out.println("Decimal Value: " + decimal + "\n");
                } if(b == 3) {
                    System.out.print("\nDecimal Value: ");
                    int decimal = 0;
                    try {
                        decimal = s.nextInt(); //must be a valid number or else throws exception.
                        decToHex convert = new decToHex(decimal);
                        hexNum hexadecimalNumber = new hexNum(convert.convertDecToHex());
                        System.out.println("Hexadecimal Value: " + hexadecimalNumber.toString() + "\n");
                    } catch (Exception e) {
                        System.err.println("Not a number.");
                        s.nextLine();
                        throw e;
                    }
                } if(b == 4) {
                    String hexA = "8AB", hexB = "B78";
                    int decimal = 170;
                    System.out.print("\nA = " + hexA + ", B = " + hexB + ",C = " + decimal + "\n\nA+B =");
                    hexCalculation(hexA, hexB, "+");
                    System.out.print("Expected Hex = 1423\nExpected Decimal: 5155\n\nA-B =");
                    hexCalculation(hexA, hexB, "-");
                    System.out.print("Expected Hex = -2CD\nExpected Decimal: -717\n\nAxB =");
                    hexCalculation(hexA, hexB, "x");
                    System.out.print("Expected Hex = 636928\nExpected Decimal: 6514984\n\nA/B =");
                    hexCalculation(hexA, hexB, "/");
                    decToHex convert = new decToHex(decimal);
                    System.out.print("Expected Hex = 0 remainder : 8AB\nExpected Decimal: 0 remainder : 2219\n\n170 to Hex value:" +
                            "\nHex value: " + convert.convertDecToHex() + "\n\n");
                } if (b == 5) {
                    resume = false;
                } else if (b < 1 || b > 5) throw new Exception();

            } catch(Exception e) {
                System.out.println("\nIncorrect input. Please try again.");
                resume = true;
            }
        }

    }



}

