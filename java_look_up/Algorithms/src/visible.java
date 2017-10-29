// Java program to print left view of binary tree

/* Class containing left and right child of current
 TreeNode and key value*/
// a level object has been taken to tackle the pass by value

/* Class to print the left view */
class visible
{
    // recursive function to print left view
    void visibleView(TreeNode root, int max)
    {
        // Base Case
        if (root == null)  return;
        // If this is the first TreeNode of its level
        if (max < root.val)
        {
            System.out.print(" " + root.val);
            max = root.val;
        }

        // Recur for left and right subtrees
        visibleView(root.left, max);
        visibleView(root.right, max);
    }


    public static void main(String args[])
    {
        /* creating a binary tree and entering the nodes */
        visible tree = new visible();
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.right.left = new TreeNode(60);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(40);
        root.right.left.left = new TreeNode(50);

        tree.visibleView(root, Integer.MIN_VALUE);
    }
}