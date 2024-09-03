/***
 * Problem Statement: Given a string s, find the length of the longest substring without repeating characters.
 * Owner-name = Aadhya Goyal
 * Date of creation = 03-09-24
 */



import java.util.*;

public class LongestSubstring {

    // Function to find the length of the longest substring without repeating characters
    static int longestSubstring(String s) {
        int n = s.length();
        Set<Character> seen = new HashSet<>();
        int maxLength = 0;
        int left = 0;  // Left pointer for the sliding window

        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);

            // If the character is already in the set, remove characters from the left
            while (seen.contains(currentChar)) {
                seen.remove(s.charAt(left));
                left++;
            }

            // Add the current character to the set and update the maxLength
            seen.add(currentChar);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number(The input should be in Characters): ");
        String s = sc.nextLine();
        sc.close();
        System.out.println(longestSubstring(s));
    }
}
