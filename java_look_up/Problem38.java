/**
 * Source:https://oj.leetcode.com/problems/balanced-binary-tree/
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which
 * the depth of the two subtrees of every node never differ by more than 1.
 * Solution: DFS.
 */
public class Problem38 {
    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalancedRe(root) > -1;
    }

    public static int isBalancedRe(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = isBalancedRe(root.left);
        int right = isBalancedRe(root.right);
        if(left == -1 || right == -1){
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    public static void main(String args[]) {
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(6);
        tree.left.left = new TreeNode(9);
        //tree.left.left.left = new TreeNode(9);
        tree.right = new TreeNode(7);
        System.out.println(isBalanced(tree));
    }
}
