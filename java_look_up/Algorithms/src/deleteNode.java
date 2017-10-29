class deleteNode
{
    Node head;  // head of list

    /* Linked list Node*/
    class Node
    {
        int data;
        Node next;
        Node(int d)  { data = d; next = null; }
    }

    /* Deletes nodes which have a node with greater
       value node on left side */
    void deleteNodes(Node n)
    {
        if(n == head){
            if(head.next == null){
                System.out.println("There's only one node and the linked list can't be made empty.");
                return;
            }
            head.data = head.next.data;
            head.next = head.next.next;
        }
        else{
            Node prev = head;
            while(prev.next != null && prev.next != n){
                prev = prev.next;
            }
            if(prev.next == null){
                System.out.println("The given node is not in the linked list.");
                return;
            }
            prev.next = prev.next.next;
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
        deleteNode llist = new deleteNode();

        /* Constructed Linked List is 12->15->10->11->
           5->6->2->3 */
        llist.push(3);
        llist.push(2);
        llist.push(6);
        llist.push(5);
        llist.push(11);
        llist.push(10);
        llist.push(15);
        llist.push(12);

        System.out.println("Given Linked List");
        llist.printList();

        llist.deleteNodes(llist.head.next.next.next);

        System.out.println("Modified Linked List");
        llist.printList();
    }
}
