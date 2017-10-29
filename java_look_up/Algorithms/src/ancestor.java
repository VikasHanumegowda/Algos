/**
 * Created by sridharyadav on 12/19/15.
 */
class Result{
    TreeNode node;
    boolean isAncestor;
    Result(TreeNode n, boolean isAnc){
        node = n;
        isAncestor = isAnc;
    }
}
public class ancestor {

    public static Result commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return new Result(null, false);

        if ((root == p) && (root == q))
            return new Result(root, true);

        Result rx = commonAncestor(root.left, p, q);
        if(rx.isAncestor)
            return rx;
        Result ry = commonAncestor(root.right, p, q);
        if(ry.isAncestor)
            return ry;
        if(rx.node != null && ry.node !=null)
            return new Result(root, true);
        if(root ==p || root == q){
            boolean isAnc = rx.node !=null || ry.node != null ? true : false;
            return new Result(root,isAnc);
        }
        return new Result(rx.node !=null ? rx.node : ry.node, false);
    }

    public static void main(String[] args)
    {
        ancestor tree = new ancestor();

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.left.right.right = new TreeNode(17);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(7);
        Result r = tree.commonAncestor(root, root.left.left.left, root.left.right.right);
        if(r.isAncestor)
            System.out.println(r.node.val);
        else
            System.out.println("No ancestor");
    }
}