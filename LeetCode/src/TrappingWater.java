import java.util.Stack;

/**
 * Created by kkwang on 8/22/2014.
 */
public class TrappingWater {
    public static int trap(int[] A) {
        int curr = 0, vol = 0;
        Stack<Integer> bars = new Stack<Integer>();
        while(curr < A.length && A[curr]==0) { //Skip leading 0's
            curr++;
        }
        while(curr < A.length) {
            while(!bars.isEmpty() && A[curr] >= A[bars.peek()]) {
                int bar = bars.pop();
                if(bars.isEmpty()) break;
                vol += ((curr - bars.peek() - 1) * (Math.min(A[curr], A[bars.peek()])-A[bar])); //width * height
            }
            bars.push(curr);
            curr++;
        }
        return vol;
    }

    public static void main(String[] args) {
        int[] heights = {2, 0, 2};
        int v = trap(heights);
        System.out.println(v);
    }
}
