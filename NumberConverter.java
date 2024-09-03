/***
 * Problem Statement: Write a Java program that converts a given integer into its written English form.
 * Owner-name = Aadhya Goyal
 * Date of creation = 03-09-24
 */



import java.util.*;

public class NumberToWordsConverter{

    private static final String[] Ones = {
            "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen"
    };

    private static final String[] Tens = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private static final String[] Thousands = {
            "", "Thousand", "Million", "Billion"
    };

    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number(The input should be in number): ");
     long number = sc.nextInt();
        System.out.println(convert(number));
    }

    public static String convert(long number) {
        if (number == 0) {
            return Ones[0];
        }

        String words = "";
        int i = 0;
        while (number > 0) {
            if (number % 1000 != 0) {
                words = convertHundreds((int) (number % 1000)) + Thousands[i] + " " + words;
            }
            number /= 1000;
            i++;
        }
        return words.trim();
    }

    private static String convertHundreds(int number) {
        String words = "";
        if (number % 100 < 20) {
            words = Ones[number % 100];
            number /= 100;
        } else {
            words = Ones[number % 10];
            number /= 10;

            words = Tens[number % 10] + (words.isEmpty() ? "" : " " + words);
            number /= 10;
        }
        if (number == 0) return words;
        return Ones[number] + " Hundred" + (words.isEmpty() ? "" : " " + words);
    }
}

