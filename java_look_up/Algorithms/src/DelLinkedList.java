class DelLinkedList
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

    public void delNodes(int m, int n)
    {
        Node t, curr = head;
        int count ;
        while (curr != null) {
            for (count = 1; count < m && curr != null; count++)
                curr = curr.next;

            if (curr == null)
                return;
            t = curr.next;
            for (count = 1; count <=n && t != null; count++)
                t = t.next;
            curr.next = t;
            curr = t;
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
        DelLinkedList llist = new DelLinkedList();

        /* The constructed linked list is:
            1->2->3->4->5->6->7 */
        llist.push(8);
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.print("\n Linked list before calling delNodes() ");
        llist.printList();

        llist.delNodes(2, 1);

        System.out.print("\n Linked list after calling delNodes() ");
        llist.printList();
    }
}