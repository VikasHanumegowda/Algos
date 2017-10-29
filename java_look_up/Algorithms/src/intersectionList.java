/**
 * Created by sridharyadav on 12/27/15.
 */
public class intersectionList {
    /* Linked list Node*/
    int FindMergeNode(Node headA, Node headB) {
        // Complete this function
        // Do not write the main method.
        int c1 = count(headA);
        int c2 = count(headB);
        if(c1> c2){
            return FindMerge(c1 - c2, headA, headB);
        }
        return FindMerge(c2 - c1, headB, headA);
    }

    int FindMerge(int d, Node headA, Node headB) {
        // Complete this function
        // Do not write the main method.

        for(int i =0; i< d; i++){
            headA = headA.next;
        }
        while(headA != null && headB!= null){
            if(headA == headB)
                return headA.data;
            headA = headA.next;
            headB = headB.next;
        }
        return -1;
    }

    int count(Node head) {
        Node current = head;
        int count = 0;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    public static void main(String args[]) {
        intersectionList llist = new intersectionList();

        /* head1 is 3->6->9->15->30
         head2 is 10->15->30 */
        Node head1 = new Node(3);
        head1.next = new Node(6);
        head1.next.next = new Node(9);
        Node head2 = new Node(10);
        head2.next = head1.next.next.next = new Node(15);
        head2.next.next = head1.next.next.next.next = new Node(30);
        System.out.print(llist.FindMergeNode(head1, head2));
    }
}
