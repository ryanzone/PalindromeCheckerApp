/**
 * MAIN CLASS: PalindromeCheckerApp
 * Use Case 10: Case-Insensitive & Space-Ignored Palindrome
 *
 * Description:
 * Validates whether a given string is a palindrome by ignoring
 * letter case differences and whitespace characters.
 *
 * Flow:
 * 1. Normalize the string (convert to lowercase).
 * 2. Remove spaces using string preprocessing / regular expressions.
 * 3. Apply palindrome checking logic.
 *
 * Key Concepts Used:
 * String Preprocessing – Modifying input string before validation.
 * Regular Expressions – Used to remove whitespace characters.
 * Case Normalization – Converting characters to uniform case for accurate comparison.
 * String Traversal – Comparing characters sequentially.
 *
 * Data Structure Used:
 * String / Character Array
 *
 * @author Ryan John Mathew
 * @version 10.0
 */

import java.util.Scanner;

public class PalindromeCheckerApp {

    // Method to check palindrome (Iterative Two-Pointer Approach)
    public static boolean isPalindrome(String str) {

        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Step 1: Convert to lowercase
        input = input.toLowerCase();

        // Step 2: Remove all whitespace using regular expression
        input = input.replaceAll("\\s+", "");

        // Step 3: Apply palindrome logic
        boolean result = isPalindrome(input);

        if (result) {
            System.out.println("The string is a Palindrome (Ignoring spaces & case).");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }

        scanner.close();
    }
}