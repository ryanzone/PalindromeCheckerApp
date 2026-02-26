/**
 * MAIN CLASS: PalindromeCheckerApp
 * Use Case 3: Palindrome Check Using String Reverse
 *
 * Description: This class shows the basic palindrome validation using a hardcode string value
 *
 * At this stage, the application consists of:
 *  - It stores predefined value
 *  - Compares original and reversed strings
 *  - Displays the result
 *
 *
 *
 * @author Ryan John Mathew
 * @version 3.0
 *
 * */

public class PalindromeCheckerApp {
    /**
     *Palindrome
     * */
        public static void main(String[] args){

            String word = "madam";
            boolean isPalindrome = true;
            int n = word.length() - 1;
            int start = 0;
            for (int i = n; i > 0; i--){
                if (word.charAt(i) != word.charAt(start)){
                    isPalindrome = false;
                    break;
                }
                start++;
            }
            if (isPalindrome){
                System.out.println(word + " is a palindrome");
            }
            else{
                System.out.println(word + " is not a palindrome");
            }
        }
}

