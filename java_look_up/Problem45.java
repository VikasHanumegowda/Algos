/**
 * Created by sridharyadav on 10/12/17.
 * Detect and remove cycle
 */
public class Problem45 {
    Node head;

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public void pushNode(int val) {
        Node new_node = new Node(val);
        new_node.next = head;
        head = new_node;
    }

    public void printNodeList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

//    Delete N nodes after M nodes of a linked list
//    Given a linked list and two integers M and N.
//    Traverse the linked list such that you retain M nodes
//    then delete next N nodes, continue the same till end of the linked list.

    public void deleteNodes(int m, int n) {
        Node curr = head;
        while (curr != null) {
            for (int i = 1; i < m && curr != null; i++) {
                curr = curr.next;
            }
            if (curr == null) {
                return;
            }
            Node temp = curr.next;
            for (int i = 0; i < n && temp != null; i++) {
                temp = temp.next;
            }
            curr.next = temp;
            curr = temp;
        }
    }

    public void detectAndRemoveCycle() {
        head.next.next.next.next.next = head.next.next;
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow == fast) {
            slow = head;
            while (slow != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = null;
        }
    }

    public static void main(String args[]) {
        Problem45 obj = new Problem45();
        obj.pushNode(10);
        obj.pushNode(4);
        obj.pushNode(20);
        obj.pushNode(40);
        obj.pushNode(50);
        obj.detectAndRemoveCycle();
        obj.printNodeList();
        obj.deleteNodes(2, 1);
        System.out.println();
        obj.printNodeList();
    }
}
