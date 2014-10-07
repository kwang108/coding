import java.util.Stack;

/**
 * Created by kkwang on 10/1/2014.
 */
public class SymmetricTree {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }
    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        TreeNode left = root.left, right = root.right;
        if(left==null && right==null) return true;
        else if(left != null && right != null) {
            return isSame(left, right);
        } else {
            return false;
        }
    }

    private static boolean isSame(TreeNode r1, TreeNode r2) {
        Stack<TreeNode> st1 = new Stack(), st2 = new Stack();
        st1.push(r1);
        st2.push(r2);
        TreeNode c1, c2;
        while(!st1.isEmpty() && !st2.isEmpty()) {
            c1 = st1.pop();
            c2 = st2.pop();

            if(c1.right != null) {
                st1.push(c1.right);
            }
            if(c1.left != null) {
                st1.push(c1.left);
            }
            if(c2.left != null) {
                st2.push(c2.left);
            }
            if(c2.right != null) {
                st2.push(c2.right);
            }
            if(c1.val != c2.val) return false;
        }
        return st1.isEmpty() && st2.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);

        boolean r = isSymmetric(root);
        System.out.println(r);
    }
}
