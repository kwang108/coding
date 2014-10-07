/**
 * Created by kkwang on 7/27/2014.
 */
public class RemoveDuplicates {
    private static int removeDuplicates(int[] A) {
        if(A == null || A.length == 0) return 0;
        int i = 0, k = 1;
        while(i < A.length && k < A.length) {
            if(A[i] == A[k]) {
                k++;
            } else {
                A[i+1] = A[k];
                i++;
                k++;
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 1, 2, 3, 3, 4};
        int l = removeDuplicates(A);
        System.out.println(l);
        for(int i = 0; i < A.length; i++) {
            System.out.print(A[i]);
            System.out.print(" ");
        }
    }
}
