/**
 * Created by kkwang on 8/18/2014.
 */
public class InsertionOrder {
    private int findIndex(int[] a, int target, int p, int q) {
        int mid = (q-p)/2 + p;
        if(a[mid] == target) return mid;
        else if(target < a[mid]) {
            if(mid == p) return p==0 ? 0 : p;
            else return findIndex(a, target, p, mid-1);
        } else {
            if(mid == q) return q+1;
            else return findIndex(a, target, mid+1, q);
        }
    }

    private int findIndex(int[] a, int target) {
        return findIndex(a, target, 0, a.length-1);
    }

    public static void main(String[] args) {
        InsertionOrder insertionOrder = new InsertionOrder();
        int[] a = {1, 3, 5, 6};
        int i = insertionOrder.findIndex(a, 0);
        System.out.println(i);
    }
}
