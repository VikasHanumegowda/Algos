public class BSTDigit {

    /**
     * Given a binary search tree whose nodes are integers, find the frequency
     * of occurrence of each digit in the tree.
     *
     * */

    public static TreeNode minBST(int arr[], int start, int end) {
        if (end < start)
            return null;

        int mid = (start+end)/2;

        TreeNode root = new TreeNode(arr[mid]);
        root.left = minBST(arr, start, mid - 1);
        root.right = minBST(arr, mid + 1, end);
        return root;
    }

    public static int [] frequency(TreeNode root) {
        int [] digits = new int[10];
        traverseTree(root, digits);
        return digits;
    }
    private static void traverseTree(TreeNode root, int [] digits) {
        if (root == null) return;
        int v = Math.abs(root.val);
        while (v != 0) {
            int d = v % 10;
            digits[d]++;
            v /= 10;
        }
        traverseTree(root.left, digits);
        traverseTree(root.right, digits);
    }

    public static void main(String[] args) {
        int [] vs = {-1, 27, 11, 141, 5, 18, 90, 368};
        TreeNode root = minBST(vs, 0, vs.length -1);
        int [] digits = frequency(root);
        for (int i = 0; i < digits.length; i++) {
            System.out.println(i + " - " + digits[i]);
        }
    }
}