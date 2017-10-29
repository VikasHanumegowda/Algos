class sort102
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

    public void sortNodes(){
        int count[] = new int[3];
        Node current = head;
        while(current != null){
            count[current.data]++;
            current = current.next;
        }
        current = head;
        int i = 0;
        while(current != null){
            if(count[i] == 0)
                ++i;
            current.data = i;
            --count[i];
            current = current.next;
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
        sort102 llist = new sort102();

        /* The constructed linked list is:
            1->2->3->4->5->6->7 */
        llist.push(0);
        llist.push(1);
        llist.push(0);
        llist.push(2);
        llist.push(1);
        llist.push(1);
        llist.push(2);
        llist.push(1);
        llist.push(2);

        System.out.print("\n Linked list before calling sortNodes() ");
        llist.printList();

        llist.sortNodes();

        System.out.print("\n Linked list after calling sortNodes() ");
        llist.printList();
    }
}