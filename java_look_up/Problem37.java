/**
 * Created by sridharyadav on 10/11/17.
 * Source: https://oj.leetcode.com/problems/add-two-numbers/
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Solution: dummy head...
 */
public class Problem37 {
    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static void printNode(Node root) {
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.next;
        }
    }

    public static Node addTwoNumbers(Node firstNum, Node secondNum) {
        if (firstNum == null && secondNum == null) {
            return null;
        }
        if (firstNum == null) {
            return secondNum;
        }
        if (secondNum == null) {
            return firstNum;
        }
        int sum, carry = 0;
        Node output = new Node(0);
        Node head = output;
        while (firstNum != null || secondNum != null || carry != 0) {
            sum = carry;
            if (firstNum != null) {
                sum += firstNum.val;
                firstNum = firstNum.next;
            }
            if (secondNum != null) {
                sum += secondNum.val;
                secondNum = secondNum.next;
            }
            carry = sum / 10;
            output.next = new Node(sum % 10);
            output = output.next;
        }
        return head.next;
    }

    public static void main(String args[]) {
        Node firstNum = new Node(2);
        firstNum.next = new Node(4);
        firstNum.next.next = new Node(3);
        Node secondNum = new Node(5);
        secondNum.next = new Node(6);
        secondNum.next.next = new Node(4);
        printNode(addTwoNumbers(firstNum, secondNum));
    }
}
