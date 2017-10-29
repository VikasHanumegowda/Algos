import apple.laf.JRSUIUtils;

import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BST {

    public static TreeNode minBST(int arr[], int start, int end) {
        if (end < start)
            return null;

        int mid = (start+end)/2;

        TreeNode root = new TreeNode(arr[mid]);
        root.left = minBST(arr, start, mid - 1);
        root.right = minBST(arr, mid + 1, end);
        return root;
    }

        public static void printIndex(TreeNode root, int index){
            String b = Integer.toBinaryString(index);
            for(int i = 1; i < b.length(); i++){
                if(b.charAt(i) == '0')
                    root = root.left;
                else
                    root = root.right;
            }
            System.out.println(root.val);

        }

        public static boolean isBST(TreeNode root,int min, int max){
            if(root == null)
                return true;
            if(root.val < min || root.val > max)
                return false;
            return isBST(root.left, min, root.val) && isBST(root.right,root.val,max);
        }



        public static void printTree (TreeNode root){

            Queue<TreeNode> firstQ = new LinkedList<>();
            firstQ.add(root);

            Queue<Queue<TreeNode>> mainQ = new LinkedList<>();
            mainQ.add(firstQ);

            while (!mainQ.isEmpty()) {
                Queue<TreeNode> levelQ = mainQ.poll();
                Queue<TreeNode> nextLevelQ = new LinkedList<>();
                for (TreeNode x : levelQ) {
                    System.out.print(x.val + " ");
                    if (x.left != null) nextLevelQ.add(x.left);
                    if (x.right != null) nextLevelQ.add(x.right);
                }
                if (!nextLevelQ.isEmpty()) mainQ.add(nextLevelQ);
                System.out.println();
            }
        }
    public static void secondPrint(TreeNode root){
        while(root.right.right != null){
            root = root.right;
        }
        System.out.println("The second largest number is:" + root.val);
    }
    public double median(TreeNode root, int size ) {
        int count = 0;
        int median = 0;
        boolean even = size % 2 == 0 ? true : false;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>( );
        while( ! stack.isEmpty( ) || node != null ) {
            if( node != null ) {
              stack.push( node );
               node = node.left;
               } else {
               node = stack.pop( );
               if( even && count == ( size / 2 ) - 1 ) {
                  median = node.val;
                  } else if( count == size / 2 ) {
                    median += node.val;
                    break;
                   }
               count++;
               node = node.right;
             }
        }
     return even ? median / 2.0 : median;
      }

    public static void main(String[] args)
    {
        BST tree = new BST();

        int arr[] = {1, 2, 3, 4, 5, 6, 7,8};
        TreeNode TreeNode = minBST(arr, 0, arr.length-1);
        printTree(TreeNode);
        System.out.println();
        printIndex(TreeNode, 3);
        System.out.println(isBST(TreeNode, Integer.MIN_VALUE, Integer.MAX_VALUE));

        secondPrint(TreeNode);

        System.out.println("The median is "+ tree.median(TreeNode, arr.length));


    }
}