/**
 * Created by kkwang on 7/19/14.
 */
public class MaxContainer {
    private static int findMaxArea(int[] height) {
        if(height == null || height.length == 1) return 0;

        int max = 0, start = 0, h1 = height[0];
        for(int i = 1; i < height.length; i++) {
            int width = i - start;
            int area = width * Math.min(h1, height[i]);
            if(area > max) {
                max = area;
            } else {
                start = i;
                h1 = height[i];
            }
        }
        return max;
    }
}
