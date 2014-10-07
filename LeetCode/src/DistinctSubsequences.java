import java.util.*;

/**
 * Created by kkwang on 9/28/2014.
 *
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of
 * the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * Here is an example: S = "rabbbit", T = "rabbit" Return 3.
 */
public class DistinctSubsequences {
    private static int subsequence(String t, int index, int prev, Map<Character, List<Integer>> map) {
        if(index == t.length()) return 1;

        char c = t.charAt(index);
        List<Integer> positions = map.get(c);
        if(positions == null || positions.isEmpty()) {
            return 0;
        } else {
            int count = 0;
            for(int i = 0; i < positions.size(); i++) {
                if(positions.get(i) > prev) { //In case of duplicates, we can't use a char before the last used char
                                              //For example, if the first b from "rabbit" is matched to the last b in S (index of 4),
                                              //then prev = 4, and the second b from T cannot use any of the previous indexes(2, 3)
                    int temp = positions.remove(i);
                    count += subsequence(t, index + 1, temp, map);
                    positions.add(i, temp);
                }
            }
            return count;
        }
    }

    private static int distinctSubsequences(String s, String t) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                List<Integer> list = map.get(c);
                list.add(i);
            } else {
                List<Integer> list = new LinkedList<>();
                list.add(i);
                map.put(c, list);
            }
        }
        int count = subsequence(t, 0, -1, map);
        return count;
    }

    private static int distinctSubseqDP(String s, String t) {
        int[][] m = new int[t.length()+1][s.length()+1];
        for(int i = 0; i < t.length(); i++) m[0][i] = 1;
        for(int j = 1; j <= t.length(); j++) {
            for(int i = 1; i <= s.length(); i++) {
                int d = s.charAt(i) == t.charAt(j) ? 1 : 0;
                m[i][j] = m[i][j-1] + (d > 0 ? m[i-1][j-1] : 0);
            }
        }
        return m[t.length()][s.length()];
    }
    public static void main(String[] args) {
        int count = distinctSubsequences("rabbbit", "rabbit");
        System.out.println(count);
    }
}
