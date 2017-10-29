import java.util.HashSet;

/**
 * Given a Binary Search Tree and a target number,
 * return true if there exist two elements in the BST such that their sum is equal to the given target.
 */
public class Problem97 {
    class Node {
        int value;
        Node left, right;

        public Node(int item) {
            value = item;
            left = right = null;
        }
    }

    // Root of BST
    Node root;

    // Constructor
    Problem97() {
        root = null;
    }

    // This method mainly calls insertRec()
    void insert(int value) {
        root = insertRec(root, value);
    }

    /* A recursive function to insert a new value in BST */
    Node insertRec(Node root, int value) {

        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(value);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (value < root.value)
            root.left = insertRec(root.left, value);
        else if (value > root.value)
            root.right = insertRec(root.right, value);

        /* return the (unchanged) node pointer */
        return root;
    }

    public boolean findTarget(int k) {
        HashSet<Integer> set = new HashSet<>();
        return findTarget(root, set, k);
    }

    public boolean findTarget(Node root, HashSet<Integer> set, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.value)) {
            return true;
        }
        set.add(root.value);
        return findTarget(root.left, set, k) || findTarget(root.right, set, k);
    }

    public static void main(String[] args) {
        Problem97 tree = new Problem97();

        tree.insert(5);
        tree.insert(3);
        tree.insert(6);
        tree.insert(2);
        tree.insert(4);
        tree.insert(7);
        System.out.println(tree.findTarget(13));
    }
}
