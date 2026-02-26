/**
 * MAIN CLASS: PalindromeCheckerApp
 * Use Case 5: Stack-Based Palindrome Checker
 *
 * Description:
 * Use stack to reverse characters and validate palindrome.
 *
 * Key Concepts Used:
 *  - Stack
 *  - Push Operation
 *  - Pop Operation
 *  - Reversal Logic
 *
 * @author Ryan John Mathew
 * @version 5.0
 */
import java.util.Stack;
public class PalindromeCheckerApp {

    public static void main(String[] args){

        String word = "noon";
        Stack<Character> stack = new Stack<>();
        for (char c : word.toCharArray()){
            stack.push(c);
        }

        boolean isPalindrome = true;
        for (char c : word.toCharArray()){
            if (c != stack.pop()){
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