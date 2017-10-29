public class isBST {

    public static boolean checkBst(TreeNode root, int min, int max) {
        if (root == null)
            return true;

        if ((root.val <= min) || (root.val > max))
            return false;

        if (!checkBst(root.left, min, root.val) || !checkBst(root.right, root.val, max))
            return false;
        return true;
    }

    public static void main(String[] args)
    {
        isBST tree = new isBST();

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.left.right.right = new TreeNode(17);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(7);
        if(tree.checkBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }
}