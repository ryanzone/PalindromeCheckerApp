/**
 * MAIN CLASS: PalindromeCheckerApp
 * Use Case 2: Hardcoded palindrome message
 *
 * Description: This class shows the basic palindrome validation using a hardcode string value
 *
 * At this stage, the application consists of:
 *  - It stores predefined value
 *  - Compares characters from both ends of the string
 *  - Checks if the result is a palindrome or not. Finally displays the result
 *
 *  palindrome logic has been implemented
 *
 *
 * @author Ryan John Mathew
 * @version 1.5
 *
 * */

public class PalindromeCheckerApp {
    /**
     *Palindrome
     * */
        public static void main(String[] args){

            String word = "madam";
            boolean isPalindrome = true;
            int n=word.length() - 1;
            int start = 0;
            for (int i = 0; i < word.length()/2; i++){
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

