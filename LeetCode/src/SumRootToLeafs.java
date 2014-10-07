/**
 * Created by kkwang on 9/23/2014.
 */
public class SumRootToLeafs {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
        }
    }
    private static int sumHelper(TreeNode node, StringBuilder buffer) {
        if(node == null) return 0;
        buffer.append(node.val);
        if(node.left == null && node.right == null) {
            int num = Integer.parseInt(buffer.toString());
            //System.out.println(num);
            return num;
        }

        int res = 0;
        if(node.left != null) res = sumHelper(node.left, new StringBuilder(buffer));
        if(node.right != null) res += sumHelper(node.right, new StringBuilder(buffer));
        return res;
    }

    public static int sumNumbers(TreeNode root) {
        StringBuilder buffer = new StringBuilder();
        int res = sumHelper(root, buffer);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root=  new TreeNode(9);
        //root.left = new TreeNode(2);
        //root.right = new TreeNode(3);

        int res = sumNumbers(root);
        System.out.println(res);
    }
}
