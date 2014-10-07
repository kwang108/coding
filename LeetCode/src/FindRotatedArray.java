/**
 * Created by kkwang on 8/5/2014.
 */
public class FindRotatedArray {
    private static int search(int[] A, int target, int start, int end) {
        if(A == null || A.length==0) return -1;
        int mid = (end - start) / 2 + start;
        if(A[mid] == target) return mid;
        if(start >= end && A[start] != target) return -1;

        if(A[start] <= A[mid]) {
            if(A[start] <= target && target <= A[mid]) {
                return search(A, target, start, mid-1);
            } else {
                return search(A, target, mid+1, end);
            }
        } else {
            if(A[mid] <= target && target <= A[end]) {
                return search(A, target, mid+1, end);
            } else {
                return search(A, target, start, mid-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {4, 5, 6, 7, 0, 1, 2};
        int index = search(A, 3, 0, A.length-1);
        System.out.println(index);

        A = new int[] {3, 1};
        index = search(A, 1, 0, A.length-1);
        System.out.println(index);
    }
}
