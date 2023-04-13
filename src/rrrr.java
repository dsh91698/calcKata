import java.util.Scanner;

public class rrrr {
    public static int sum(int num, int num2) {
        return num + num2;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String strInput = input.nextLine();// Read user input, remove spaces
        String strInput2 = input.nextLine();
        input.close(); // Close the Scanner object

        int sum = sum(Integer.parseInt(strInput), Integer.parseInt(strInput2));
//        return sum;
        System.out.println("sum is ->" + sum);
        System.out.printf("sum" + sum);
    }

}

