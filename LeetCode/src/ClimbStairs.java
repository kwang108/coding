/**
 * Created by kkwang on 9/8/2014.
 *
 * You are climbing a stair case. It takes n steps to reach to the top. Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 */
public class ClimbStairs {
    private static void climb(int n, int[] r) {
        if(n == 0) {
            r[0]++;
            return;
        }
        if(n >= 2) climb(n-2, r);
        climb(n-1, r);
    }

    public static int climbStairs(int n) {
        int[] result = new int[1];
        climb(n, result);
        return result[0];
    }

    public int climbStairsIterative(int n) {
        if (n <= 0) return 0;
        if (n == 1 || n == 2) return n;
        int[] steps = new int[n];
        steps[0] = 1;
        steps[1] = 2;
        for(int i = 2; i < n; i++) {
            steps[i] = steps[i-1] + steps[i-2];
        }
        return steps[n-1];
    }

    public static void main(String[] args) {
        int r = climbStairs(4);
        System.out.println(r);
    }
}
