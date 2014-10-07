/**
 * Created by kkwang on 9/10/2014.
 */
public class RotatedArray {
    public static boolean search(int[] A, int x) {
        int start = 0, end = A.length-1;
        while(start < end && A[start]==A[end]) {
            if(A[start]==x) return true;
            start++;
            end--;
        }
        while(start <= end) {
            int mid = (end-start)/2 + start;
            if(A[mid] == x) return true;
            else if(A[start] <= A[mid]) {
                if(A[start] < x && x <= A[mid]) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            } else {
                if(A[mid] <= x && x <= A[end]) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1};
        boolean r = search(a, 1);
        System.out.println(r);
    }
}
