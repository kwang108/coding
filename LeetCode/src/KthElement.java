/**
 * Created by kkwang on 7/15/14.
 */
public class KthElement {
    /**
     * Find the k-th Smallest Element in the Union of Two Sorted Arrays A and B.
     *
     * At index i, there are i elements smaller than A[i]. For example, {1, 3, 5, 7} and i=2, there are two numbers smaller
     * than A[2]=5. Similarly, at index j, there are j elements smaller than B[j].
     * If A[i] is the kth element in the union of A and B, there must be a total of k-1 elements smaller than A[i].
     * And IF B[j-1] < A[i] < B[j], A[i] would be inserted at index j in B and there are j elements in B[j] that are smaller than A[i].
     * Therefore, in total there are i+j elements in the union smaller than A[i]. This implies that i+j = k-1
     *
     * @param A sorted int array
     * @param m1 first index of array A
     * @param m2 last index of array A
     * @param B sorted int array
     * @param n1 first index of array B
     * @param n2 last index of array B
     * @param k
     * @return
     */
    static int findKthSmallest(int A[], int m1, int m2, int B[], int n1, int n2, int k) {
        int i = (m2-m1) / 2; //offset for the middle element
        int j = (k-1) - i; // (i + j + 1 = k)
        i = i + m1; // array index of the middle element
        j = n1 + j; // array index of the middle element
        // invariant: i + j = k-1
        // Note: A[-1] = -INF and A[m] = +INF to maintain invariant
        int Ai_1 = ((i == 0) ? Integer.MIN_VALUE : A[i-1]);
        int Bj_1 = ((j == 0) ? Integer.MIN_VALUE : B[j-1]);
        int Ai   = ((i > m2) ? Integer.MAX_VALUE : A[i]);
        int Bj   = ((j > n2) ? Integer.MAX_VALUE : B[j]);

        if (Bj_1 < Ai && Ai < Bj)
            return Ai;
        else if (Ai_1 < Bj && Bj < Ai)
            return Bj;

        // if none of the cases above, then it is either:
        if (Ai < Bj)
            // exclude Ai and below portion
            // exclude Bj and above portion
            return findKthSmallest(A, m1+i+1, m2, B, n1, j-1, k-i-1); //Since we are ignoring some elements, k needs to be reduced accordingly.
        else /* Bj < Ai */
            // exclude Ai and above portion
            // exclude Bj and below portion
            return findKthSmallest(A, m1, i-1, B, n1+j+1, n2, k-j-1);
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5};
        int[] b = {2, 4, 6, 8};
        int result = findKthSmallest(a, 0, a.length-1, b, 0, b.length-1, 5);
        System.out.println(result);
    }
}
