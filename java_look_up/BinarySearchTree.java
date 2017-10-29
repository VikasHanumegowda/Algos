/**
 * Created by sridharyadav on 10/8/17.
 */

//http://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/

// Java program to demonstrate insert operation in binary search tree
class BinarySearchTree {

    /* Class containing left and right child of current node and value value*/
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
    BinarySearchTree() {
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

    // This method mainly calls InorderRec()
    void inorder() {
        inorderRec(root);
    }

    // A utility function to do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.value);
            inorderRec(root.right);
        }
    }

    void deleteKey(int value) {
        root = deleteKeyRecursively(root, value);
    }

    Node deleteKeyRecursively(Node root, int value) {
        if (root == null) {
            return null;
        }

        if (value < root.value) {
            deleteKeyRecursively(root.left, value);
        } else if (value > root.value) {
            deleteKeyRecursively(root.right, value);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                root.value = minValue(root.right);
                root.right = deleteKeyRecursively(root.right, root.value);
            }
        }
        return root;
    }

    int minValue(Node root){
        int minKey = root.value;
        while (root.left != null){
            root = root.left;
            minKey = root.value;
        }
        return minKey;
    }

    // Driver Program to test above functions
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // print inorder traversal of the BST
        tree.inorder();

        System.out.println();

        tree.deleteKey(30);
        tree.inorder();
    }
}
