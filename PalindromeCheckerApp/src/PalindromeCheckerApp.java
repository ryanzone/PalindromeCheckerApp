/**
 * MAIN CLASS: PalindromeCheckerApp
 * Use Case 8: Linked List Based Palindrome Checker
 *
 * Description:
 * Check palindrome using singly linked list.
 *
 * Key Concepts Used:
 * Singly Linked List – A dynamic data structure where elements are connected using node references.
 * Node Traversal – Sequential access to elements using next references.
 * Fast and Slow Pointer Technique – Used to find the middle of the linked list efficiently.
 * In-Place Reversal – Reverses the second half of the list without extra memory.
 *
 * @author Ryan John Mathew
 * @version 8.0
 */

import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeCheckerApp {

    // Definition of singly linked list node
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }

        public static void main(String[] args){

            // Input string
            String word = "madam";

            // Convert string to linked list
            Node head = createLinkedList(word);

            // Check if palindrome
            boolean isPalindrome = isPalindrome(head);

            // Print result
            if (isPalindrome) {
                System.out.println(word + " is a Palindrome");
            } else {
                System.out.println(word + " is NOT a Palindrome");
            }
        }

        // Create linked list from string
        private static Node createLinkedList(String word) {
            Node head = null;
            Node tail = null;

            for (int i = 0; i < word.length(); i++) {
                Node newNode = new Node(word.charAt(i));

                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    tail.next = newNode;
                    tail = newNode;
                }
            }
            return head;
        }

        // Palindrome check using linked list
        private static boolean isPalindrome(Node head) {
            if (head == null || head.next == null) {
                return true;
            }

            // Find middle using fast & slow pointers
            Node slow = head;
            Node fast = head;

            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // Reverse second half
            Node secondHalf = reverseList(slow.next);

            // Compare both halves
            Node firstHalf = head;
            Node tempSecond = secondHalf;

            boolean result = true;

            while (tempSecond != null) {
                if (firstHalf.data != tempSecond.data) {
                    result = false;
                    break;
                }
                firstHalf = firstHalf.next;
                tempSecond = tempSecond.next;
            }

            return result;
        }

        // Reverse linked list
        private static Node reverseList(Node head) {
            Node prev = null;
            Node current = head;

            while (current != null) {
                Node nextNode = current.next;
                current.next = prev;
                prev = current;
                current = nextNode;
            }
            return prev;
        }
    }
}