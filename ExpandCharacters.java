/***
 * Problem Statement: Given a string containing characters followed by digits, expand each character by repeating it according to the digit that follows.
 * Owner-name = Aadhya Goyal
 * Date of creation = 03-09-24
 */

import java.util.*;

public class ExpandCharacters{
 public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continueInput = "y";

        while (continueInput.equalsIgnoreCase("y")) {
            System.out.print("Enter the string (e.g., 'a52b9c89'): ");
            String inputString = scanner.nextLine();

            // Validate input
            if (!isValidInput(inputString)) {
                System.out.println("Invalid input. Please ensure the string only contains lowercase letters followed by digits and digits do not exceed 99.");
            } else {
                String outputString = "";

                for (int i = 0; i < inputString.length(); i++) {
                    char ch = inputString.charAt(i);
                    StringBuilder num = new StringBuilder();

                    // Collect digits following the character
                    while (i + 1 < inputString.length() && Character.isDigit(inputString.charAt(i + 1))) {
                        num.append(inputString.charAt(i + 1));
                        i++;
                    }

                    // Convert collected digits to an integer
                    int count = Integer.parseInt(num.toString());
                    for (int j = 0; j < count; j++) {
                        outputString += ch;
                    }
                }

                System.out.println("Expanded string: " + outputString);
            }

            // Ask the user if they want to continue
            System.out.print("Do you want to enter another string? (y/n): ");
            continueInput = scanner.nextLine();
        }

        System.out.println("Program terminated.");
        scanner.close();
    }

    // Method to validate input
    public static boolean isValidInput(String s) {
        if (s.length() == 0) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if (!Character.isLowerCase(s.charAt(i))) {
                return false;
            }
            i++;
            if (i < s.length() && !Character.isDigit(s.charAt(i))) {
                return false;
            }

            // Collect the digits to check if the number exceeds 99
            StringBuilder num = new StringBuilder();
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                num.append(s.charAt(i));
                i++;
            }
            i--;

            // Convert collected digits to an integer and check if it exceeds 99
            if (Integer.parseInt(num.toString()) > 99) {
                return false;
            }
        }
        return true;
    }
}