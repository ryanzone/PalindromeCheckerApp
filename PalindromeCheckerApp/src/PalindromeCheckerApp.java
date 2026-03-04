/**
 * MAIN CLASS: PalindromeCheckerApp
 * Use Case 9: Recursive Palindrome Checker
 *
 * Description:
 * Check palindrome using recursion.
 *
 * Key Concepts Used:
 * Recursion – A technique where a method calls itself to solve smaller subproblems.
 * Base Condition – Stops recursion to prevent infinite calls.
 * String Indexing – Comparing characters using start and end indices.
 * Call Stack – Stores recursive method calls in memory until execution completes.
 *
 * @author Ryan John Mathew
 * @version 9.0
 */
import java.util.Scanner;

public class PalindromeCheckerApp {

    // Recursive method
    public static boolean isPalindrome(String str, int start, int end) {

        // Base Condition: If pointers cross or meet
        if (start >= end) {
            return true;
        }

        // If characters don't match
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Optional: Normalize input (remove spaces & convert to lowercase)
        input = input.replaceAll("\\s+", "").toLowerCase();

        boolean result = isPalindrome(input, 0, input.length() - 1);

        if (result) {
            System.out.println("The string is a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }

        scanner.close();
    }
}