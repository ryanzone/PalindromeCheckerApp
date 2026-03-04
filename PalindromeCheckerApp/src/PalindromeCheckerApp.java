/**
 * MAIN CLASS: PalindromeCheckerApp
 * Use Case 7: Deque-Based Optimized Palindrome Checker
 *
 * Description:
 * Use Deque to compare front and rear elements.
 *
 * Key Concepts Used:
 * Deque (Double Ended Queue) – A data structure that allows insertion and deletion from both front and rear ends.
 * Front and Rear Access – Enables direct comparison of first and last characters.
 * Optimized Data Handling – Eliminates the need for separate reversal data structures.
 *
 * @author Ryan John Mathew
 * @version 7.0
 */

import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeCheckerApp {

    public static void main(String[] args){

        // String to be checked
        String word = "racecar";

        // Create a Deque
        Deque<Character> deque = new ArrayDeque<>();

        // Insert characters into deque
        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }

        boolean isPalindrome = true;

        // Compare front and rear characters
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                isPalindrome = false;
                break;
            }
        }

        // Print result
        if (isPalindrome) {
            System.out.println(word + " is a Palindrome");
        } else {
            System.out.println(word + " is NOT a Palindrome");
        }
    }
}