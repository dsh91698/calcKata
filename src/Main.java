import java.util.Scanner;

class Main {

    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
        System.out.println("Input two numbers and operation, like \"1 + 1\" ");

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

        return arabicCalc(tokens);
    }

    public static String arabicCalc(String[] tokens) throws Exception{
        if (Integer.parseInt(tokens[0])>10 || Integer.parseInt(tokens[2])>10) throw new Exception("Wrong input: Operand is greater then 10");
        int result;
        String operator = tokens[1];
        switch (operator) {
            case "+":
                result = Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[2]);
                break;
            case "-":
                result = Integer.parseInt(tokens[0]) - Integer.parseInt(tokens[2]);
                break;
            case "*":
                result = Integer.parseInt(tokens[0]) * Integer.parseInt(tokens[2]);
                break;
            case "/":
                result = Integer.parseInt(tokens[0]) / Integer.parseInt(tokens[2]);
                break;
            default:
                throw new Exception("Operator is not valid");
        }
        return String.valueOf(result);
    }

    public static String romanCalc(){
        return "XXX";
    }

    public static void isInputValid(String[] tokens) throws Exception{
        if (tokens.length != 3)
            throw new Exception("Input is not valid: two numbers and one operator only!");
    }

    public static Boolean isInputRoman(String[] tokens) {
        return false;
    }


}