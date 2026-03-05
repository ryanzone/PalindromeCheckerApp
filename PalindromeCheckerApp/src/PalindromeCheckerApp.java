import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

/**
 * MAIN CLASS: PalindromeCheckerApp
 * Use Case 13: Performance Comparison of Palindrome Algorithms
 *
 * Description:
 * This console-based application evaluates whether a given string
 * is a palindrome using multiple algorithms and compares their
 * execution performance.
 *
 * The program builds on the Strategy Pattern architecture where
 * each palindrome algorithm is encapsulated in its own strategy class.
 * The application runs all strategies sequentially and measures
 * execution time using System.nanoTime().
 *
 * Flow:
 * 1. Accept user input from the console.
 * 2. Normalize the string (convert to lowercase).
 * 3. Remove whitespace using regular expressions.
 * 4. Execute multiple palindrome algorithms.
 * 5. Capture execution time using System.nanoTime().
 * 6. Display whether the string is a palindrome.
 * 7. Show performance comparison results.
 *
 * Key Concepts Used (OOPS):
 * Interface – Defines the contract for palindrome algorithms.
 * Polymorphism – Multiple strategies implement the same interface.
 * Strategy Pattern – Algorithms are interchangeable.
 *
 * Programming Concepts Used:
 * System.nanoTime() – High-precision execution time measurement.
 * Algorithm Comparison – Evaluating performance across strategies.
 * String Preprocessing – Normalizing input before validation.
 *
 * Data Structures Used:
 * Stack (StackStrategy)
 * Deque (DequeStrategy)
 * Two-Pointer Traversal (TwoPointerStrategy)
 *
 * @author Ryan John Mathew
 * @version 13.0
 */

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check if it is a palindrome:");
        String input = scanner.nextLine();

        // Normalize input
        String processed = input.toLowerCase().replaceAll("\\s+", "");

        // Create strategy list
        PalindromeStrategy[] strategies = {
                new StackStrategy(),
                new DequeStrategy(),
                new TwoPointerStrategy()
        };

        String[] names = {
                "Stack Strategy",
                "Deque Strategy",
                "Two Pointer Strategy"
        };

        System.out.println("\n--- Performance Comparison ---");

        for (int i = 0; i < strategies.length; i++) {

            PalindromeChecker checker = new PalindromeChecker(strategies[i]);

            long startTime = System.nanoTime();

            boolean result = checker.checkPalindrome(processed);

            long endTime = System.nanoTime();

            long executionTime = endTime - startTime;

            System.out.println("\nAlgorithm: " + names[i]);
            System.out.println("Palindrome: " + result);
            System.out.println("Execution Time: " + executionTime + " ns");
        }

        scanner.close();
    }
}

/**
 * Strategy Interface
 * Defines the contract for palindrome algorithms.
 */
interface PalindromeStrategy {

    boolean checkPalindrome(String text);
}

/**
 * Context Class
 * Executes a selected strategy.
 */
class PalindromeChecker {

    private PalindromeStrategy strategy;

    public PalindromeChecker(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String text) {
        return strategy.checkPalindrome(text);
    }
}

/**
 * Stack-Based Algorithm
 */
class StackStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String text) {

        Stack<Character> stack = new Stack<>();

        for (char c : text.toCharArray()) {
            stack.push(c);
        }

        for (char c : text.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

/**
 * Deque-Based Algorithm
 */
class DequeStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String text) {

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : text.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}

/**
 * Two-Pointer Algorithm (Most Efficient)
 */
class TwoPointerStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String text) {

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {

            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}