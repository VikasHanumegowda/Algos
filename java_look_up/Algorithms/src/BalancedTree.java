
public class BalancedTree {

    public static boolean isBalanced(TreeNode root) {
        if (checkHeight(root) == -1)
            return false;
        else
            return true;
    }

    public static int checkHeight(TreeNode root) {
        if (root == null)
            return 0;

        int left = checkHeight(root.left);
        int right = checkHeight(root.right);

        if (left == -1 || right == -1)
            return -1;

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;

    }

    public static int findHeight(TreeNode root){
        if(root == null)
            return 0;
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args)
    {
        BalancedTree tree = new BalancedTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(8);
        System.out.println("Height of the tree is " + findHeight(root));
        if(tree.isBalanced(root))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }
}