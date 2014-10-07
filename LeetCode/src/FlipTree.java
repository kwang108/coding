/**
 * Created by kkwang on 8/26/2014.
 */
public class FlipTree {
    static class Node {
        int data;
        Node left, right;
        public Node(int a) {
            data = a;
        }
    }

    public static void flip(Node node) {
        if(node == null) return;
        if(node.left != null) {
            flip(node.left);
            node.left.left = node.right;
            node.right = null;
            node.left.right = node;
            node.left = null;
        }
    }

    public static int maxSubArray(int[] A) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < A.length; i++) {
            sum += A[i];
            if(sum > max) max = sum;
            if(sum < 0) sum = 0;
        }
        return max;
    }
    public static void main(String[] args) {
        int[] A = {-2,1,-3,4,-1,2,1,-5,4};
        int r = maxSubArray(A);

        Node root = new Node(1);
        root.right = new Node(3);
        Node node2 = new Node(2);
        root.left = node2;
        Node node4 = new Node(4);
        node2.left = node4;
        node2.right = new Node(5);

        flip(root);
        System.out.println(node4.left.data);
    }
}
