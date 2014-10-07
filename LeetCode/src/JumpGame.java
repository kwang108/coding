/**
 * Created by kkwang on 9/5/2014.
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 *   A = [2,3,1,1,4], return true.
 *   A = [3,2,1,0,4], return false.
 */
public class JumpGame {
    public static boolean canJump(int[] A) {
        if(A == null || A.length==1) return true;

        boolean[] canReach = new boolean[A.length];
        for(int i = A.length-2; i >= 0; i--) {
            if(A[i] >= A.length-1-i) canReach[i] = true;
            else {
                for(int j = 1; j <= A[i]; j++) {
                    if(canReach[i+j]) {
                        canReach[i] = true;
                        break;
                    }
                }
            }
        }
        return canReach[0];
    }
    /*
        all we want to know whether the next can-reach-end element is within my range.
        So, during the iteration, we can store the position of the next can-reach-end element and
        then for each successor element, we only need to check whether that node is reachable.
     */
    public boolean canJumpImproved(int[] A) {
        if(A == null || A.length==1) return true;

        int next = A.length-1; //start from destination
        for(int i = A.length-2; i >= 0; i--) {
            if(A[i] >= next-i) next = i; //Check if position next is within reach from position i, given A[i] steps at position i
        }
        return next == 0;
    }

    /**
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.
     * Each element in the array represents your maximum jump length at that position.
     * Your goal is to reach the last index in the minimum number of jumps.
     *
     * Compute the minimum steps for the current element by checking each element within its range to
     * find the next one with smallest number of steps.
     */
    public int jump(int[] A) {
        if (A.length <= 1) return 0;
        int[] steps = new int[A.length-1];
        for (int i=A.length-2; i>=0; --i) {
            if (A[i] >= (A.length - 1 - i)) { //Can reach last index from position i given A[i] jump distance
                steps[i] = 1;  //Update steps[i] to 1 since it takes 1 jump from i
            } else {
                int min = A.length;
                for (int j=1; j<=A[i]; ++j) {
                    min = Math.min(min, steps[i+j]);
                }
                steps[i] = min + 1; //takes 1 jum from i to position that has min jump distance
            }
        }
        return steps[0];
    }

    public static void main(String[] args) {
        int[] steps = {2,1,1,0,4};
        boolean can = canJump(steps);
        System.out.println(can);
    }
}
