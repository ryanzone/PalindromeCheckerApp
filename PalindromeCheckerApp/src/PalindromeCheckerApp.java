/**
 * MAIN CLASS: PalindromeCheckerApp
 * Use Case 11: Object-Oriented Palindrome Service
 *
 * Description:
 * This console-based application validates whether a given string
 * is a palindrome by utilizing a dedicated PalindromeChecker class.
 * The palindrome logic is encapsulated inside the service class,
 * promoting clean architecture and maintainable code.
 *
 * The application also supports:
 * - Case-insensitive comparison
 * - Ignoring whitespace characters
 *
 * Flow:
 * 1. Accept user input from the console.
 * 2. Normalize the string (convert to lowercase).
 * 3. Remove whitespace using string preprocessing / regular expressions.
 * 4. Pass the processed string to the PalindromeChecker service class.
 * 5. The service internally performs palindrome validation using
 *    a data structure (Stack / Array).
 * 6. Display the result to the user.
 *
 * Key Concepts Used (OOPS):
 * Encapsulation – Palindrome logic is contained within the PalindromeChecker class.
 * Single Responsibility Principle – The PalindromeChecker class handles only palindrome validation.
 * Method Abstraction – The checkPalindrome() method exposes a clean interface.
 *
 * Programming Concepts Used:
 * String Preprocessing – Preparing input before validation.
 * Regular Expressions – Used to remove whitespace characters.
 * Case Normalization – Converting characters to a uniform case.
 * String Traversal – Comparing characters sequentially.
 *
 * Data Structure Used:
 * Stack / Character Array (internal implementation inside PalindromeChecker class)
 *
 * @author Ryan John Mathew
 * @version 11.0
 */
import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check if it is a palindrome:");
        String input = scanner.nextLine();

        // Normalize input
        String processed = input.toLowerCase().replaceAll("\\s+", "");

        // Create service object
        PalindromeChecker checker = new PalindromeChecker();

        boolean result = checker.checkPalindrome(processed);

        if (result) {
            System.out.println("The string IS a palindrome.");
        } else {
            System.out.println("The string is NOT a palindrome.");
        }

        scanner.close();
    }
}

/**
 * SERVICE CLASS: PalindromeChecker
 *
 * Responsible only for palindrome validation.
 * Demonstrates encapsulation and single responsibility principle.
 */
class PalindromeChecker {

    /**
     * Checks if a string is a palindrome using a Stack.
     *
     * @param text processed string (lowercase, no spaces)
     * @return true if palindrome, false otherwise
     */
    public boolean checkPalindrome(String text) {

        Stack<Character> stack = new Stack<>();

        // Push characters into stack
        for (int i = 0; i < text.length(); i++) {
            stack.push(text.charAt(i));
        }

        // Compare characters
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}