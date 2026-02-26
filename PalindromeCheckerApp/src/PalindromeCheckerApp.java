/**
 * MAIN CLASS: PalindromeCheckerApp
 * Use Case 4: Character Array Based Palindrome Check
 *
 * Description:
 * Convert string to character array and compare characters
 * using the Two-Pointer Technique.
 *
 * Key Concepts Used:
 *  - Character Array (char[])
 *  - Array Indexing
 *  - Two-Pointer Technique
 *  - Time Complexity Awareness
 *
 * @author Ryan John Mathew
 * @version 4.0
 */

public class PalindromeCheckerApp {

    public static void main(String[] args){

        String word = "radar";
        char[] chars = word.toCharArray();

        int start = 0;
        int end = chars.length - 1;

        boolean isPalindrome = true;

        while (start < end) {

            if (chars[start] != chars[end]) {
                isPalindrome = false;
                break;
            }

            start++;
            end--;
        }

        if (isPalindrome) {
            System.out.println(word + " is a palindrome");
        } else {
            System.out.println(word + " is not a palindrome");
        }
    }
}