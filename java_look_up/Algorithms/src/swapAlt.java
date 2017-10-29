class swapAlt
{
    Node head;  // head of list

    /* Linked list Node*/
    class Node
    {
        int data;
        Node next;
        Node(int d)  { data = d; next = null; }
    }

    void swap()
    {
        Node current = head;
        int data;
        while(current != null){
            data = current.data;
            current.data = current.next.data;
            current.next.data = data;
            current = current.next.next;
        }
    }

    /* Utility functions */

    /* Inserts a new Node at front of the list. */
    void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }


    /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String args[])
    {
        swapAlt llist = new swapAlt();

        /* Constructed Linked List is 12->15->10->11->
           5->6->2->3 */
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.println("Given Linked List");
        llist.printList();

        llist.swap();

        System.out.println("Modified Linked List");
        llist.printList();
    }
} /* This code is contributed by Rajat Mishra */
