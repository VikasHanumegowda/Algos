
class Node
{
    int data;
    Node next;
    Node(int d)
    {
        data = d;
        next = null;
    }
}

class mergeSort
{
    public static Node merge(Node headA, Node headB) {
        // This is a "method-only" submission.
        // You only need to complete this method
        Node result;
        if(headA.data <= headB.data){
            result = headA;
            headA = headA.next;
        }
        else{
            result = headB;
            headB = headB.next;
        }
            Node head = result;
        while(headA!=null && headB!=null){
            if(headA.data <= headB.data){
                result.next = headA;
                headA = headA.next;
            }
            else{
                result.next = headB;
                headB = headB.next;
            }
            result = result.next;
        }
        while(headA!=null){
            result.next = headA;
            headA = headA.next;
            result = result.next;
        }
        while(headB!=null){
            result.next = headB;
            headB = headB.next;
            result = result.next;
        }
        return head;
    }


    /* This function prints contents of linked list starting
       from the given Node */
    public void printList(Node head)
    {
        Node tNode = head;
        while (tNode != null)
        {
            System.out.print(tNode.data+" ");
            tNode = tNode.next;
        }
    }

    /* Druver program to test above function */
    public static void main(String[] args)
    {
        mergeSort llist = new mergeSort();

        /* The constructed linked list is:
            1->2->3->4->5->6->7 */
        Node head = new Node(1);
        head.next = new Node(15);
        head.next.next = new Node(22);
        head.next.next.next = new Node(27);
        head.next.next.next.next = new Node(35);

        Node head2 = new Node(11);
        head2.next = new Node(12);
        head2.next.next = new Node(23);
        head2.next.next.next = new Node(24);
        head2.next.next.next.next = new Node(45);

        System.out.println("\nLinked list1: ");
        llist.printList(head);
        System.out.println("\nLinked list2: ");
        llist.printList(head2);
        System.out.println("\nMerged Sorted Linked List:");
        llist.printList(merge(head,head2));
    }
}