import java.util.*;

public class bandCalc {
    private List<String> unitList;
    private Map<String, Double> converter;

    public bandCalc(Scanner s) {
        unitList = new ArrayList<String>();
        unitList.add("b");
        unitList.add("kb");
        unitList.add("mb");
        unitList.add("gb");
        unitList.add("tb");
        unitList.add("B");
        unitList.add("KB");
        unitList.add("MB");
        unitList.add("GB");
        unitList.add("TB");

        converter = new HashMap<String, Double>();
        converter.put("b", 1.0);
        converter.put("kb", 1000.0);
        converter.put("mb", 1000000.0);
        converter.put("gb", 1000000000.0);
        converter.put("tb", 1000000000000.0);
        converter.put("B", 8.0);
        converter.put("KB", 8000.0);
        converter.put("MB", 8000000.0);
        converter.put("GB", 8000000000.0);
        converter.put("TB", 8000000000000.0);

        baCalc(s);
    }
    //checks unit if correct.
    public void checkUnit(String unit) {
        if(!unitList.contains(unit)) {
            throw new IllegalArgumentException();
        }
    }

    public HashMap<String, Double> convertBitsToEverything(double bits) {
        HashMap<String, Double> convertAll = new HashMap<>();
        convertAll.put("b", bits);
        convertAll.put("kb", bits / 1000.0);
        convertAll.put("mb", bits / 1000000.0);
        convertAll.put("gb", bits / 1000000000.0);
        convertAll.put("tb", bits / 1000000000000.0);
        convertAll.put("B", bits / 8.0);
        convertAll.put("KB", bits / 8000.0);
        convertAll.put("MB", bits / 8000000.0);
        convertAll.put("GB", bits / 8000000000.0);
        convertAll.put("TB", bits / 8000000000000.0);

        return convertAll;
    }
    //converts bit to any other data unit.
    public double convertBitsToOther(double bits, String unitChange) {
        return (bits / converter.get(unitChange));
    }
    //converts unit into bits.
    public double convertToBits(double number, String unit) {
        double bitNum = number * converter.get(unit);
        return bitNum;
    }
    //asks for data units.
    public String askDatUnit(Scanner s) {
        String unit = "";

        System.out.print("\nUnit:\n(b / kb / mb / gb / tb / B / KB / MB / GB / TB)\nUser: ");
        unit = s.next();

        return unit;
    }
    //bandwidth calculator menu. *Website Bandwidth Calculator is incomplete*
    public void baCalc(Scanner s) {
        boolean resume = true;

        while(resume) {
            int b = 0;
            double number = 0.0;
            double number2 = 0.0;
            double bitNumber = 0.0;
            double bitNumber2 = 0.0;

            try {
                System.out.print("\nB A N D W I D T H  C A L C U L A T O R\n1.Data Unit Converter\n" +
                        "2.Donwload/upload time calculator\n3.Website bandwidth calculator\n" +
                        "4.Hosting bandiwdth calculator\n5.Test Mode\n6.Exit\nUser: ");
                try {
                    b = s.nextInt(); //must be a valid number or else throws exception.
                } catch (Exception e) {
                    System.err.println("Not a number.");
                    s.nextLine();
                    throw e;
                }
                if (b == 1){
                    System.out.print("\nNumber: ");
                    try {
                        number = (double) s.nextInt(); //must be a valid number or else throws exception.
                    } catch (Exception e) {
                        System.err.println("Not a number.");
                        s.nextLine();
                        throw e;
                    }

                    String unit = askDatUnit(s);
                    checkUnit(unit);
                    bitNumber = convertToBits(number, unit);
                    System.out.print("\n" + convertBitsToEverything(bitNumber).toString() + "\n");


                } if (b == 2){
                    System.out.print("\nFileSize\nNumber: ");
                    try {
                        number = (double) s.nextInt(); //must be a valid number or else throws exception.
                    } catch (Exception e) {
                        System.err.println("Not a number.");
                        s.nextLine();
                        throw e;
                    }

                    String unit = askDatUnit(s);
                    checkUnit(unit);
                    bitNumber = convertToBits(number, unit);

                    System.out.print("\nBandwidth Per Second\nNumber: ");
                    try {
                        number2 = (double) s.nextInt(); //must be a valid number or else throws exception.
                    } catch (Exception e) {
                        System.err.println("Not a number.");
                        s.nextLine();
                        throw e;
                    }

                    String unit2 = askDatUnit(s);
                    checkUnit(unit);
                    bitNumber2 = convertToBits(number2, unit2);

                    System.out.print("\nDownload or upload time needed is: ~" + (bitNumber/bitNumber2) + "second(s)");

                } if (b == 3){ //Website Bandwidth Calculator incomplete.

                } if (b == 4){
                    System.out.print("\nMonthly Usage: ");
                    try {
                        number = (double) s.nextInt(); //must be a valid number or else throws exception.
                    } catch (Exception e) {
                        System.err.println("Not a number.");
                        s.nextLine();
                        throw e;
                    }
                    String unit = askDatUnit(s);
                    checkUnit(unit);
                    bitNumber = convertToBits(number, unit);

                    System.out.print("\nBandwidth (in seconds)");
                    String unit2 = askDatUnit(s);
                    checkUnit(unit2);
                    Double finalNumber = convertBitsToOther(bitNumber, unit2); //number with correct unit user asked for

                    System.out.print("\n" + number + " " + unit + " per month is equivalent to " +
                            (finalNumber / 2628002.88) + " " + unit2 + "/s");

                } if (b == 5){

                    System.out.println("\nData unit converter, X = 500 MB \nExpected:\n4000000000 bits (b)\n" +
                            "4000000 kilobits (kb)\n" +
                            "4000 megabits (mb)\n" +
                            "4 gigabits (gb)\n" +
                            "0.004 terabits (tb)\n" +
                            "500000000 Bytes (B)\n" +
                            "500000 Kilobytes (KB)\n" +
                            "0.5 Gigabytes (GB)\n" +
                            "0.0005 Terabytes (TB)\n\nResult:");
                    bitNumber = convertToBits(500, "MB");
                    System.out.print(convertBitsToEverything(bitNumber).toString());

                    System.out.print("\n\nDownload/Upload Time Calculator, X = 500MB, Y = 5mb/s\n " +
                            "expected: 13 minutes 20 seconds\nresult: ");
                    bitNumber = convertToBits(500, "MB");
                    bitNumber2 = convertToBits(5, "mb");
                    System.out.print((bitNumber/bitNumber2) + "second(s)");

                    System.out.print("\n\nHosting Bandwidth Converter X = 1000GB Y = mb/s\n" +
                            "expected: 3.0420564301468 mb/s\nresult: ");
                    bitNumber = convertToBits(1000, "GB");
                    bitNumber2 = convertBitsToOther(bitNumber, "mb");
                    System.out.print((bitNumber2 / 2628002.88) + " " + "mb/s");
                } if (b == 6){
                    resume = false;
                } else if (b < 1 || b > 6) {
                    throw new Exception();
                }
            } catch(Exception e) {
                System.out.println("\nIncorrect input. Please try again.");
                resume = true;
            }
        }
    }
}