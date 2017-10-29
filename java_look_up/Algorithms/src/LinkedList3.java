
class LinkedList3 {

    static Node head = null;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /* function to insert a new_node in a list in sorted way.
     Note that this function expects a pointer to head node
     as this can modify the head of the input linked list */
    void sortedInsert(Node new_node) {
        Node current = head;

        // Case 1 of the above algo
        if (current == null) {
            new_node.next = new_node;
            head = new_node;

        } // Case 2 of the above algo
        else if (current.data >= new_node.data) {

            /* If value is smaller than head's value then
             we need to change next of last node */
            while (current.next != head) {
                current = current.next;
            }
            current.next = new_node;
            new_node.next = head;
            head = new_node;
        } // Case 3 of the above algo
        else {

            /* Locate the node before the point of insertion */
            while (current.next != head && current.next.data < new_node.data) {
                current = current.next;
            }
            new_node.next = current.next;
            current.next = new_node;
        }
    }

    void printList(Node node) {
        Node temp = node;
        if (node != null) {
            temp = node;
            do {
                System.out.print(node.data + " ");
                node = node.next;
            } while (temp != node);
        }
    }

    public static void main(String[] args) {
        LinkedList3 list = new LinkedList3();

        // Creating the linkedlist
        int arr[] = new int[]{12, 56, 2, 11, 1, 90};
        int i;
        /* start with empty linked list */
        Node temp = null;

        /* Create linked list from the array arr[].
         Created linked list will be 1->2->11->56->90 */
        for (i = 0; i < 6; i++) {
            temp = new Node(arr[i]);
            list.sortedInsert(temp);
        }
        list.printList(head);

    }
}