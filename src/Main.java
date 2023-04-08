import java.util.Map;
import java.util.Scanner;

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

    static Map<String, Integer> arabicNumeralMapInput = Map.of(
            "1", 1,
            "2", 2,
            "3", 3,
            "4", 4,
            "5", 5,
            "6", 6,
            "7", 7,
            "8", 8,
            "9", 9,
            "10", 10
    );



    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);

        System.out.println("Input two numbers and operation, like \"1 + 1\" or \" I + II\" ");
        System.out.println("Use \"+\", \"-\",\"*\", \"/\" only  ");

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
        //TODO: add two variables for both operands
        if (Integer.parseInt(tokens[0])>10 || Integer.parseInt(tokens[2])>10) throw new Exception("Wrong input: Operand is greater then 10");
        String operator = tokens[1];
        int result = switch (operator) {
            case "+" -> Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[2]);
            case "-" -> Integer.parseInt(tokens[0]) - Integer.parseInt(tokens[2]);
            case "*" -> Integer.parseInt(tokens[0]) * Integer.parseInt(tokens[2]);
            case "/" -> Integer.parseInt(tokens[0]) / Integer.parseInt(tokens[2]);
            default -> throw new Exception("Operator is not valid"); // just for case
        };
        return String.valueOf(result);
    }

    public static String romanCalc(String[] tokens){
        return "XXX";
    }

    public static void isInputValid(String[] tokens) throws Exception{
        if (tokens.length != 3) throw new Exception("Input is not valid: input two numbers and one operator only!");
        // TODO: add check for mixed operands like "1 +II "
    }

    public static Boolean isInputRoman(String[] tokens) {
        if (romanNumeralMapInput.containsKey(tokens[0]) && romanNumeralMapInput.containsKey(tokens[2])) {
            return true;
        }
//        else {
//            System.out.println("The map does not contain the key 'II'");
//        }
        return false;
    }


}
