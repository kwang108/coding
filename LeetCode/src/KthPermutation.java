import java.util.ArrayList;
import java.util.List;

/**
 * http://smartlhc.blogspot.com/2012/08/find-kth-permutation-sequence.html
 *
 * Created by kkwang on 9/13/2014.
 */
public class KthPermutation {
    public static String getPermutation(int n, int k) {
        if(n == 1) return "1";
        List<Integer> ll = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++) ll.add(i);
        StringBuilder buffer = new StringBuilder();
        permuteHelper(n, k-1, buffer, ll);
        return buffer.toString();
    }
    static int factorial(int x) {
        if(x < 1) return 1;
        int f = x;
        while(--x > 1) {
            f *= x;
        }
        return f;
    }
    private static void permuteHelper(int n, int k, StringBuilder buffer, List<Integer> ll) {
        int numGroup, pos;
        while(n > 0) {
            numGroup = factorial(n-1); //For every different number at position 1, there are (n-1)! permutations
            pos = k/numGroup; //This will tell us how many different numbers at position 1 are covered by k permutations.
            buffer.append(ll.get(pos));
            ll.remove(pos);
            k = k % numGroup; //After pos number of (n-1)! permutations, what's left of k
            n--;
        }
    }

    public static void main(String[] args) {
        String s = getPermutation(3, 5);
        System.out.println(s);

        s = getPermutation2(3, 5);
        System.out.println(s);
    }

    public static String getPermutation2(int n, int k) {
        if (n <= 0 || k <= 0) return "";

        // factorials of n
        int[] fact = new int[n];
        // an array of n numbers
        StringBuilder nums = new StringBuilder();
        // pre-compute factorials
        for (int i=1; i<=n; ++i) {
            nums.append(i);
            if (i == 1)
                fact[i-1] = 1;
            else
                fact[i-1] = fact[i-2] * i;
        }

        // normalize k so that it is within range [0 .. n!]
        while (k > fact[n-1]) k -= fact[n-1];
        k -= 1; // convert to 0-based

        // compute the permutation
        for (int i=0; i<n-1; ++i) {
            int factorial = fact[n-2-i]; // (n-1-i)!
            int id = k / factorial + i;
            // shift the numbers
            char num = nums.charAt(id);
            for (int j=id; j>i; --j) nums.setCharAt(j, nums.charAt(j-1));
            nums.setCharAt(i, num);
            while (k >= factorial) k -= factorial;
        }

        // convert to string
        return nums.toString();
    }
}
