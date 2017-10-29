import java.util.*;
/*
 *  Remove duplicates from an unsorted linked list
 */

public class RemoveDuplicates {
    private static class LinkedListNode {
        public int data;
        public LinkedListNode next;

        public LinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedListNode removeDup(LinkedListNode head){
        HashSet<Integer> set = new HashSet<Integer>();
        if(head == null){
            return null;
        }
        LinkedListNode currNode = head;
        LinkedListNode prevNode = null;
        while(currNode != null){
            int data = currNode.data;
            if(set.contains(data)){
                prevNode.next = currNode.next;
            }else{
                set.add(data);
                prevNode = currNode;
            }
            currNode = currNode.next;
        }
        return head;
    }

    public void display(LinkedListNode head){
        LinkedListNode n = head;
        while(n!=null){
            System.out.print("->" + n.data);
            n = n.next;
        }
    }

    public static void main (String args[]){
        LinkedListNode n = new LinkedListNode(1);
        n.next = new LinkedListNode(2);
        n.next.next = new LinkedListNode(2);
        n.next.next.next = new LinkedListNode(3);
        n.next.next.next.next = new LinkedListNode(4);
        n.next.next.next.next.next = new LinkedListNode(4);
        n.next.next.next.next.next.next = new LinkedListNode(1);
        System.out.print("Original List : ");
        RemoveDuplicates rm = new RemoveDuplicates();
        rm.display(n);
        System.out.println();
        System.out.print("Updated List: ");
        LinkedListNode x = rm.removeDup(n);
        rm.display(x);
    }
}