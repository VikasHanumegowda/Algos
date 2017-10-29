import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sridharyadav on 10/19/17.
 */
public class Problem87 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    public static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.max(left, right) + 1;
    }

    public static double[] findAverage(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("The tree has no nodes");
        }
        double array[] = new double[depth(root)];
        int index = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> temp = new LinkedList<>();
            double sum = 0, count = 0;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                sum += node.val;
                count++;
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }

            }
            array[index++] = sum / count;
            queue = temp;
        }
        return array;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        double array[] = findAverage(root);
        System.out.println("The average of Levels in Binary Tree is : ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
