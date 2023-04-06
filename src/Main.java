import java.util.Scanner;

class Main {
    static String strInput;

    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
        System.out.println("Input two numbers and operation, like \"1 + 1\" ");

        strInput = input.nextLine().replace(" ", ""); // Read user input, remove spaces
        System.out.println("Input is: " + strInput); // Output user input
        input.close(); // Close the Scanner object

        String result = calc(strInput); // Pass user input to the calc method
        System.out.println("Result is: " + result); // Output the result
    }

    public static String calc(String input) throws Exception {
        System.out.println("calc working");
        String[] tokens = input.split("(?<=[\\dIVXLCM])(?=[^\\dIVXLCM])|(?<=[^\\dIVXLCM])(?=[\\dIVXLCM])"); // divide input

         for (String token : tokens) {
           System.out.println(token);
         }
        System.out.println("tokens length-> " + tokens.length);
         Boolean isInputValid = isInputValid(tokens);

        return isInputValid.toString();
    }

    public static Boolean isInputValid(String[] tokens) throws Exception{
        if (tokens.length != 3)
            throw new Exception("Input is not valid");
        return true;

    }


}