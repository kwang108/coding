import java.util.Stack;

/**
 * Created by kkwang on 8/22/2014.
 *
 * See http://n00tc0d3r.blogspot.com/2013/03/largest-rectangle-in-histogram.html
 */
public class Histogram {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> left = new Stack<Integer>();
        int cur = 0, area = 0;
        while (cur < height.length) {
            if (left.isEmpty() || height[cur] >= height[left.peek()]) {
                // push to stack if we hit a greater or equal height
                left.push(cur++);
            } else {
                int top = left.pop();
                // the height at left.peek() must be smaller than the current one
                // so, the width of the rectangle is [left.peek()+1, cur)
                area = Math.max(area, height[top]*(left.isEmpty() ? cur : (cur-left.peek()-1)));
            }
        }
        while (!left.isEmpty()) {
            int top = left.pop();
            area = Math.max(area, height[top]*(left.isEmpty() ? cur : (cur-left.peek()-1)));
        }
        return area;
    }

    public static int largestRectangleArea2(int[] height) {
        if(height == null || height.length==0) return 0;
        int[] area = new int[height.length];
        Stack<Integer> st = new Stack<Integer>();
        for(int i = 0; i < height.length; i++) {
            while(!st.isEmpty() && height[i] <= height[st.peek()]) {
                st.pop();
            }
            int t = -1;
            if(!st.isEmpty()) t = st.peek();
            area[i] = i - (t + 1);
            st.push(i);
        }
        st.clear();

        for(int i = height.length-1; i >= 0; i--) {
            while(!st.isEmpty() && height[i] <= height[st.peek()]) {
                st.pop();
            }
            int t = height.length;
            if(!st.isEmpty()) t = st.peek();
            area[i] += (t - (i + 1));
            st.push(i);
        }
        int max = 0;
        for(int i = 0; i < area.length; i++) {
            max = Math.max(max, (area[i]+1)*height[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        Histogram hist = new Histogram();
        int[] height = {2,1,5,6,2,3};
        int area = hist.largestRectangleArea(height);
        System.out.println(area);
        height = new int[]{2,4};
        area = hist.largestRectangleArea2(height);
        System.out.println(area);
    }
}
