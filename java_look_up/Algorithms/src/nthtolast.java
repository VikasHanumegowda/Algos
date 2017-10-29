class nthtolast
{
    public int kthNode(Node head, int k)
    {
        if(head == null){
            return 0;
        }
        int i = kthNode(head.next, k) + 1;
        if(i == k) {
            System.out.println(k + "thtolastelement = " + head.data);
        }
        return i;
    }

    public void kthNodeIterative(Node head, int k){
        Node h1 = head;
        Node h2 = head;
        for(int i = 1; i < k; i++){
            if(h2 == null)
                return;
            h2 = h2.next;
        }
        if(h2==null)
            return;
        while(h2.next != null){
            h2 = h2.next;
            h1 = h1.next;
        }
        System.out.println(k + "thtolastelement = " + h1.data);
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
        nthtolast llist = new nthtolast();

        /* The constructed linked list is:
            1->2->3->4->5->6->7 */
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("\nLinked list: ");
        llist.printList(head);
        System.out.println("\n\nRecursive:");

        llist.kthNode(head, 3);
        System.out.println("\nIterative:");
        llist.kthNodeIterative(head, 3);

    }
}