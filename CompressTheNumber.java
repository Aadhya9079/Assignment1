/***
 * Problem Statement: Write a Java program that takes a string input and outputs the frequency of each character in a compressed form.
 * Owner-name = Aadhya Goyal
 * Date of creation = 03-09-24
 */

import java.util.*;

public class CompressTheNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any input(For example:a1b78):");
        String str = sc.next();
        String ans = "" + str.charAt(0);    
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            char curr = str.charAt(i);
            char prev = str.charAt(i - 1);

            if (curr == prev) {
                count++;
            } else {
                if (count > 1)
                    ans += count;
                count = 1;
                ans += curr;
            }
        }

        if (count > 1)
            ans += count;

        System.out.println(ans);
    }
}