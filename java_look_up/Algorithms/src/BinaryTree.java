// Java program to print left view of binary tree

/* Class containing left and right child of current
 TreeNode and key value*/
// a level object has been taken to tackle the pass by value

/* Class to print the left view */
class BinaryTree
{
    int max_level;
    // recursive function to print left view
    void leftViewUtil(TreeNode root, int level)
    {
        // Base Case
        if (root == null)  return;
        // If this is the first TreeNode of its level
        if (max_level < level)
        {
            System.out.print(" " + root.val);
            max_level = level;
        }

        // Recur for left and right subtrees
        leftViewUtil(root.left, level+1);
        leftViewUtil(root.right, level+1);
    }

    // A wrapper over leftViewUtil()
    void leftView(TreeNode root)
    {
        max_level=0;
        leftViewUtil(root, 1);
    }

    /* testing for example nodes */

    public static void main(String args[])
    {
        /* creating a binary tree and entering the nodes */
        BinaryTree tree = new BinaryTree();
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.right.left = new TreeNode(60);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(40);
        root.right.left.left = new TreeNode(50);

        tree.leftView(root);
    }
}