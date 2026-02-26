/**
 * MAIN CLASS: PalindromeCheckerApp
 * Use Case 6: Queue + Stack Based Palindrome Check
 *
 * Description:
 * Demonstrate FIFO vs LIFO using Queue and Stack.
 *
 * Key Concepts Used:
 *  - Queue
 *  - Enqueue & Dequeue Operations
 *  - Stack vs Queue
 *  - Logical Comparison
 *
 * @author Ryan John Mathew
 * @version 6.0
 */

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class PalindromeCheckerApp {

    public static void main(String[] args){

        String word = "civic";
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (char c : word.toCharArray()){
            queue.add(c);
            stack.push(c);
        }

        boolean isPalindrome = true;

        while (!queue.isEmpty()){
            if (!queue.remove().equals(stack.pop())) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println(word + " is a palindrome");
        } else {
            System.out.println(word + " is not a palindrome");
        }
    }
}