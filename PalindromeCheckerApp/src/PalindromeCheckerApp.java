import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

/**
 * MAIN CLASS: PalindromeCheckerApp
 * Use Case 12: Strategy Pattern for Palindrome Algorithms
 *
 * Description:
 * This console-based application validates whether a given string
 * is a palindrome using dynamically selectable algorithms.
 *
 * The program follows the Strategy Design Pattern where different
 * palindrome checking algorithms are encapsulated into separate
 * strategy classes implementing a common interface.
 *
 * Flow:
 * 1. Accept user input from the console.
 * 2. Normalize the string (convert to lowercase).
 * 3. Remove whitespace using regular expressions.
 * 4. Ask the user to choose a palindrome algorithm.
 * 5. Inject the selected strategy into the PalindromeChecker service.
 * 6. Execute palindrome validation using the chosen strategy.
 * 7. Display the result to the user.
 *
 * Key Concepts Used (OOPS):
 * Interface – Defines the contract for palindrome strategies.
 * Polymorphism – Different strategies implement the same interface.
 * Strategy Pattern – Algorithm can be changed dynamically at runtime.
 * Encapsulation – Each algorithm is isolated within its own class.
 *
 * Programming Concepts Used:
 * String Preprocessing – Preparing input before validation.
 * Regular Expressions – Removing whitespace characters.
 * Case Normalization – Converting characters to uniform case.
 * Dynamic Behavior – Selecting algorithms at runtime.
 *
 * Data Structures Used:
 * Stack (StackStrategy)
 * Deque (DequeStrategy)
 *
 * @author Ryan John Mathew
 * @version 12.0
 */

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check if it is a palindrome:");
        String input = scanner.nextLine();

        // Normalize input
        String processed = input.toLowerCase().replaceAll("\\s+", "");

        System.out.println("\nChoose Algorithm:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");

        int choice = scanner.nextInt();

        PalindromeStrategy strategy;

        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        PalindromeChecker checker = new PalindromeChecker(strategy);

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
 * Strategy Interface
 * Defines the contract for palindrome algorithms.
 */
interface PalindromeStrategy {

    boolean checkPalindrome(String text);
}

/**
 * Context Class
 * Uses a selected palindrome strategy.
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
 * Stack-Based Palindrome Algorithm
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
 * Deque-Based Palindrome Algorithm
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