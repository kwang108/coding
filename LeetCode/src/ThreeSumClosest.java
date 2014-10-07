import java.util.Arrays;

/**
 * Created by kkwang on 7/21/2014.
 */
public class ThreeSumClosest {
    public static int threeSumClosest(int[] num, int target) {
        if(num == null || num.length < 3) return 0;
        int j, k;
        int min = Integer.MAX_VALUE;
        Arrays.sort(num);
        int result = 0;
        for(int i = 0; i < num.length - 2; i++) {
            j = i+1;
            k = num.length - 1;
            while(j < k) {
                int sum = num[i] + num[j] + num[k];
                if(sum == target) return sum;
                int diff = Math.abs(sum - target);
                if(diff < min) {
                    min = diff;
                    result = num[i] + num[j] + num[k];
                }// else break;
                if(sum < target) {
                    j++;
                    while(j > 0 && j < num.length && num[j-1]==num[j]) j++;
                } else {
                    k--;
                    while(k < num.length-1 && k >= 0 && num[k+1]==num[k]) k--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = {-1, 2, 1, -4};
        int x = threeSumClosest(num, 2);
        System.out.println(x);

        num = new int[]{0, 0, 0};
        x = threeSumClosest(num, 1);
        System.out.println(x);

        num = new int[]{1,2,4,8,16,32,64,128};
        x = threeSumClosest(num, 82);
        System.out.println(x);
    }
}
