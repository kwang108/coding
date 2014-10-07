import java.util.HashSet;
import java.util.Set;

/**
 * Created by kkwang on 9/23/2014.
 *
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 */
public class LongestConsectuiveSeq {
    public int longestConsecutive(int[] num) {
        int max_len = 0;
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < num.length; i++) {
            set.add(num[i]);
        }
        for(int i = 0; i < num.length; i++) {
            if(set.contains(num[i])) {
                set.remove(num[i]);
                int len = 1 + findConsecutiveLength(set, num[i]+1, 1);
                len += findConsecutiveLength(set, num[i]-1, -1);
                max_len = Math.max(max_len, len);
            }
        }
        return max_len;
    }

    private int findConsecutiveLength(Set<Integer> set, int num, int step) {
        int len = 0;
        while(set.contains(num)) {
            len++;
            set.remove(num);
            num += step;
        }
        return len;
    }
}
