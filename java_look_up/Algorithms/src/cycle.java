class cycle
{
    Node head; // head of list

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

    /* Function to swap Nodes x and y in linked list by
       changing links */
    public void detectAndRemoveLoop()
    {
        head.next.next.next.next.next = head.next.next;
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            if(slow == fast)
                break;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slow == fast){
            slow = head;
            while(slow != fast.next){
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = null;
        }
    }

    /* Function to add Node at beginning of list. */
    public void push(int new_data)
    {
        /* 1. alloc the Node and put the data */
        Node new_Node = new Node(new_data);

        /* 2. Make next of new Node as head */
        new_Node.next = head;

        /* 3. Move the head to point to new Node */
        head = new_Node;
    }

    /* This function prints contents of linked list starting
       from the given Node */
    public void printList()
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
        cycle llist = new cycle();

        /* The constructed linked list is:
            1->2->3->4->5->6->7 */
        llist.push(10);
        llist.push(4);
        llist.push(15);
        llist.push(20);
        llist.push(50);

        System.out.print("\n Linked list before calling detectAndRemoveLoop() ");
        llist.printList();

        llist.detectAndRemoveLoop();

        System.out.print("\n Linked list after calling detectAndRemoveLoop() ");
        llist.printList();
    }
}