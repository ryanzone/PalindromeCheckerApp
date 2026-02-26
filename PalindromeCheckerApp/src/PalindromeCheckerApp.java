/**
 * MAIN CLASS: PalindromeCheckerApp
 * Use Case 3: Palindrome Check Using String Reverse
 *
 * Description:
 * This class demonstrates palindrome validation
 * by reversing the string and comparing it
 * with the original value.
 *
 * Key Concepts Used:
 *  - Loop (for loop)
 *  - String Immutability
 *  - String Concatenation (+)
 *  - equals() Method
 *
 * @author Ryan John Mathew
 * @version 3.0
 */

public class PalindromeCheckerApp {

    public static void main(String[] args){

        String word = "madam";
        String reversed = "";

        for (int i = word.length() - 1; i >= 0; i--) {

            reversed = reversed + word.charAt(i);
        }

        if (word.equals(reversed)) {
            System.out.println(word + " is a palindrome");
        } else {
            System.out.println(word + " is not a palindrome");
        }
    }
}