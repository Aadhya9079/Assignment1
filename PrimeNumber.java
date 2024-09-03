/***
 * Java program to determine if a given integer is a prime number.
 *   Owner-name = Aadhya Goyal
 *   Date of creation = 03-09-24
 */

import java.util.*;

public class PrimeNumber {
    public static void main(String[] args) {
        int n;
        int counter=0;
        Scanner sc = new Scanner(System.in);
        Constant constant = new Constant();
        for (n = 0; n <= 1000000; n++) {
            System.out.println("Enter the Number(The input should be in integer): ");
            n = sc.nextInt();
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    counter++;
                }
            }
            if (counter == 2) {
                System.out.println("The given number is prime number");
            } else {
                System.out.println("The given number is not a prime number ");
            }
        }
    }
}



