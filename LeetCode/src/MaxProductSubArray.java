/**
 * Created by kkwang on 9/25/2014.
 */
public class MaxProductSubArray {
    public static int maxProduct(int[] A) {
        if (A.length==0) return 0;

        int maxi = 1, mini = 1;
        int out = Integer.MIN_VALUE;

        for(int i=0; i < A.length; i++) {
            int oldmaxi = Math.max(maxi, 1);
            if(A[i] > 0) {
                maxi = oldmaxi * A[i];
                mini *= A[i];
            } else {
                maxi = mini * A[i];
                mini = oldmaxi * A[i];
            }
            out = Math.max(out, maxi);
        }

        return out;
    }

    public static void main(String[] args) {
        int[] a = {-2};
        int p = maxProduct(a);
        System.out.println(p);
    }
}
