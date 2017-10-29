import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Print Left View of a Binary Tree
 * Given a Binary Tree, print left view of it.
 * Left view of a Binary Tree is set of nodes visible when tree is visited from left side.
 */

public class Problem39 {
    public static class TreeNode {
        TreeNode left, right;
        int val;

        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    static int maxLevel = 0;

    public static void printLeftView(TreeNode root, int level) {
        if(root == null){
            return;
        }
        if(maxLevel < level){
            System.out.print(root.val + " ");
            maxLevel = level;
        }
        printLeftView(root.left, level+1);
        printLeftView(root.right, level+1);
    }

    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeRec(root, sb);
        return sb.toString();
    }

    public static void serializeRec(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("#").append(",");
        }
        else{
            sb.append(String.valueOf(root.val)).append(",");
            serializeRec(root.left, sb);
            serializeRec(root.right, sb);
        }
    }

    public static void deSerialize(String serializedTree){
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(serializedTree.split(",")));
        printLeftView(deSerializeRec(queue), 1);
    }
    public static TreeNode deSerializeRec(Queue<String> queue){
        String val = queue.poll();
        if(val.equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deSerializeRec(queue);
        root.right = deSerializeRec(queue);
        return root;
    }

    public static int TreeHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = TreeHeight(root.left);
        int right = TreeHeight(root.right);
        return Math.max(left, right) + 1;
    }


    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        printLeftView(root, 1);
        deSerialize(serialize(root));
        System.out.println(TreeHeight(root));
    }
}

