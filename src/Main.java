import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import static java.util.Map.entry;

class Main {

    static Map<String, Integer> romanNumeralMapInput = Map.of(
            "I", 1,
            "II", 2,
            "III", 3,
            "IV", 4,
            "V", 5,
            "VI", 6,
            "VII", 7,
            "VIII", 8,
            "IX", 9,
            "X", 10
    );

    static Map<String, Integer> arabicNumeralMapInput = Map.ofEntries(
            entry("0", 0),
            entry("1", 1),
            entry("2", 2),
            entry("3", 3),
            entry("4", 4),
            entry("5", 5),
            entry("6", 6),
            entry("7", 7),
            entry("8", 8),
            entry("9", 9),
            entry("10", 10)
    );


    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);

        System.out.println("Input two numbers and operation, like \"1 + 1\" or \" I + II\" ");
        System.out.println("Use \"+\", \"-\",\"*\", \"/\" operators only  ");

        String strInput = input.nextLine().replace(" ", ""); // Read user input, remove spaces
        System.out.println("Input is: " + strInput); // Output user input
        input.close(); // Close the Scanner object

        String result = calc(strInput); // Pass user input to the calc method
        System.out.println("Result is: " + result); // Output the result
    }

    public static String calc(String input) throws Exception {
        System.out.println("calc working");
        String[] tokens = input.split("(?<=[\\dIVX])(?=[^\\dIVX])|(?<=[^\\dIVX])(?=[\\dIVX])"); // divide input - Roman 10 maximum

        isInputValid(tokens); //check if input is valid

        if(isInputRoman(tokens)) return romanCalc(tokens);
        else return arabicCalc(tokens);
    }

    public static String arabicCalc(String[] tokens) throws Exception{
        if (Integer.parseInt(tokens[0])>10 || Integer.parseInt(tokens[2])>10) throw new Exception("Wrong input: Operand is greater then 10");
        if ( (arabicNumeralMapInput.get(tokens[2]) == 0) && (Objects.equals(tokens[1], "/")) ) throw new Exception("Do not divide by Zero, it is dangerous!"); //case divide by zero

        String operator = tokens[1];
        int result = switch (operator) {
            case "+" -> Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[2]);
            case "-" -> Integer.parseInt(tokens[0]) - Integer.parseInt(tokens[2]);
            case "*" -> Integer.parseInt(tokens[0]) * Integer.parseInt(tokens[2]);
            case "/" -> Integer.parseInt(tokens[0]) / Integer.parseInt(tokens[2]);
            default -> throw new Exception("Operator is not valid => " + operator); // just for case ... %
        };
        return String.valueOf(result);
    }

    public static String romanCalc(String[] tokens) throws Exception {

//        try { // case if in input roman numbers greater then 10, like XX, XI ... which passing input regex
//            int operand1 = romanNumeralMapInput.get(tokens[0]);// try to get numeric value from Map by roman as key
//            int operand2 = romanNumeralMapInput.get(tokens[2]);
//        } catch (Exception e) {
//            throw new Exception("Wrong input: operand is greater then 10 or does not fit input format!");
//        }

        int operand1 = romanNumeralMapInput.get(tokens[0]);// get numeric value from Map by roman as key
        int operand2 = romanNumeralMapInput.get(tokens[2]);
        String operator = tokens[1];
        int result = switch (operator) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            case "/" -> operand1 / operand2;
            default -> throw new Exception("Operator is not valid"); // just for case
        };
        if (result < 1) throw new Exception("Wrong output: roman numbers does not include Null or negative number");
//        System.out.println("result ->" + result);
        RomanOutput RomanOutput = new RomanOutput(); // make instance
        return RomanOutput.romanFromArabic(result);
    }

    public static void isInputValid(String[] tokens) throws Exception{
        if (tokens.length != 3) throw new Exception("Input is not valid: input two numbers and one operator only!");
        if (romanNumeralMapInput.containsKey(tokens[0]) && arabicNumeralMapInput.containsKey(tokens[2])) throw new Exception("Input is not valid: do not mix arabic and roman numbers!");
        if (romanNumeralMapInput.containsKey(tokens[2]) && arabicNumeralMapInput.containsKey(tokens[0])) throw new Exception("Input is not valid: do not mix arabic and roman numbers!");
    }

    public static Boolean isInputRoman(String[] tokens) throws Exception {
        String message = "Input is not valid: roman num > 10!";
        if (!romanNumeralMapInput.containsKey(tokens[0]) && tokens[0].matches("^[IVXLCDM]+$")) throw new Exception(message);
        if (!romanNumeralMapInput.containsKey(tokens[2]) && tokens[2].matches("^[IVXLCDM]+$")) throw new Exception(message);
        return romanNumeralMapInput.containsKey(tokens[0]) && romanNumeralMapInput.containsKey(tokens[2]);
    }


}

class RomanOutput {
    static Map<Integer, String> romanNumeralMapForOutput;
    RomanOutput() { // constructor
        romanNumeralMapForOutput = new HashMap<>(100);
        romanNumeralMapForOutput.put(1, "I");
        romanNumeralMapForOutput.put(2, "II");
        romanNumeralMapForOutput.put(3, "III");
        romanNumeralMapForOutput.put(4, "IV");
        romanNumeralMapForOutput.put(5, "V");
        romanNumeralMapForOutput.put(6, "VI");
        romanNumeralMapForOutput.put(7, "VII");
        romanNumeralMapForOutput.put(8, "VIII");
        romanNumeralMapForOutput.put(9, "IX");

        romanNumeralMapForOutput.put(10, "X");
        romanNumeralMapForOutput.put(11, "XI");
        romanNumeralMapForOutput.put(12, "XII");
        romanNumeralMapForOutput.put(13, "XIII");
        romanNumeralMapForOutput.put(14, "XIV");
        romanNumeralMapForOutput.put(15, "XV");
        romanNumeralMapForOutput.put(16, "XVI");
        romanNumeralMapForOutput.put(17, "XVII");
        romanNumeralMapForOutput.put(18, "XVIII");
        romanNumeralMapForOutput.put(19, "XIX");

        romanNumeralMapForOutput.put(20, "XX");
        romanNumeralMapForOutput.put(21, "XXI");
        romanNumeralMapForOutput.put(22, "XXII");
        romanNumeralMapForOutput.put(23, "XXIII");
        romanNumeralMapForOutput.put(24, "XXIV");
        romanNumeralMapForOutput.put(25, "XXV");
        romanNumeralMapForOutput.put(26, "XXVI");
        romanNumeralMapForOutput.put(27, "XXVII");
        romanNumeralMapForOutput.put(28, "XXVIII");
        romanNumeralMapForOutput.put(29, "XXIX");

        romanNumeralMapForOutput.put(30, "XXX");
        romanNumeralMapForOutput.put(31, "XXXI");
        romanNumeralMapForOutput.put(32, "XXXII");
        romanNumeralMapForOutput.put(33, "XXXIII");
        romanNumeralMapForOutput.put(34, "XXXIV");
        romanNumeralMapForOutput.put(35, "XXXV");
        romanNumeralMapForOutput.put(36, "XXXVI");
        romanNumeralMapForOutput.put(37, "XXXVII");
        romanNumeralMapForOutput.put(38, "XXXVIII");
        romanNumeralMapForOutput.put(39, "XXXIX");

        romanNumeralMapForOutput.put(40, "XL");
        romanNumeralMapForOutput.put(41, "XLI");
        romanNumeralMapForOutput.put(42, "XLII");
        romanNumeralMapForOutput.put(43, "XLIII");
        romanNumeralMapForOutput.put(44, "XLIV");
        romanNumeralMapForOutput.put(45, "XLV");
        romanNumeralMapForOutput.put(46, "XLVI");
        romanNumeralMapForOutput.put(47, "XLVII");
        romanNumeralMapForOutput.put(48, "XLVIII");
        romanNumeralMapForOutput.put(49, "XLIX");

        romanNumeralMapForOutput.put(50, "L");
        romanNumeralMapForOutput.put(51, "LI");
        romanNumeralMapForOutput.put(52, "LII");
        romanNumeralMapForOutput.put(53, "LIII");
        romanNumeralMapForOutput.put(54, "LIV");
        romanNumeralMapForOutput.put(55, "LV");
        romanNumeralMapForOutput.put(56, "LVI");
        romanNumeralMapForOutput.put(57, "LVII");
        romanNumeralMapForOutput.put(58, "LVIII");
        romanNumeralMapForOutput.put(59, "LIX");

        romanNumeralMapForOutput.put(60, "LX");
        romanNumeralMapForOutput.put(61, "LXI");
        romanNumeralMapForOutput.put(62, "LXII");
        romanNumeralMapForOutput.put(63, "LXIII");
        romanNumeralMapForOutput.put(64, "LXIV");
        romanNumeralMapForOutput.put(65, "LXV");
        romanNumeralMapForOutput.put(66, "LXVI");
        romanNumeralMapForOutput.put(67, "LXVII");
        romanNumeralMapForOutput.put(68, "LXVIII");
        romanNumeralMapForOutput.put(69, "LXIX");

        romanNumeralMapForOutput.put(70, "LXX");
        romanNumeralMapForOutput.put(71, "LXXI");
        romanNumeralMapForOutput.put(72, "LXXII");
        romanNumeralMapForOutput.put(73, "LXXIII");
        romanNumeralMapForOutput.put(74, "LXXIV");
        romanNumeralMapForOutput.put(75, "LXXV");
        romanNumeralMapForOutput.put(76, "LXXVI");
        romanNumeralMapForOutput.put(77, "LXXVII");
        romanNumeralMapForOutput.put(78, "LXXVIII");
        romanNumeralMapForOutput.put(79, "LXXIX");

        romanNumeralMapForOutput.put(80, "LXXX");
        romanNumeralMapForOutput.put(81, "LXXXI");
        romanNumeralMapForOutput.put(82, "LXXXII");
        romanNumeralMapForOutput.put(83, "LXXXIII");
        romanNumeralMapForOutput.put(84, "LXXXIV");
        romanNumeralMapForOutput.put(85, "LXXXV");
        romanNumeralMapForOutput.put(86, "LXXXVI");
        romanNumeralMapForOutput.put(87, "LXXXVII");
        romanNumeralMapForOutput.put(88, "LXXXVIII");
        romanNumeralMapForOutput.put(89, "LXXXIX");

        romanNumeralMapForOutput.put(90, "XC");
        romanNumeralMapForOutput.put(91, "XCI");
        romanNumeralMapForOutput.put(92, "XCII");
        romanNumeralMapForOutput.put(93, "XCIII");
        romanNumeralMapForOutput.put(94, "XCIV");
        romanNumeralMapForOutput.put(95, "XCV");
        romanNumeralMapForOutput.put(96, "XCVI");
        romanNumeralMapForOutput.put(97, "XCVII");
        romanNumeralMapForOutput.put(98, "XCVIII");
        romanNumeralMapForOutput.put(99, "XCIX");
        romanNumeralMapForOutput.put(100, "C");
    }
      String romanFromArabic (int num) {
        return romanNumeralMapForOutput.get(num); // roman num 3->"III"
    }
}


