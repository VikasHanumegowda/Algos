/**
 * Created by sridharyadav on 1/29/16.
 */
public class StackLink {
        Node head;  // head of list

        /* Linked list Node*/
        class Node
        {
            int data;
            Node next;
            Node(int d)  { data = d; next = null; }
        }

        int pop() {
            int val = -1;
            if(head !=null) {
                val = head.data;
                head = head.next;
                return val;
            }
            return val;
        }
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

        /* Function to reverse the linked list */
        int peek() {
            return head.data;
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
            StackLink llist = new StackLink();

        /* Constructed Linked List is 12->15->10->11->
           5->6->2->3 */
            llist.push(3);
            llist.push(2);
            llist.push(6);
            llist.push(5);
            llist.push(11);


            System.out.println(llist.pop());
            System.out.println(llist.pop());
            System.out.println(llist.pop());
            System.out.println(llist.pop());

            System.out.println(llist.peek());

        }
    }
