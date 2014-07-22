/**
 * Created by kkwang on 7/9/14.
 */
public class LongestPalindrome {
    private static String expandCenter(String str, int c1, int c2) {
        while(c1 >= 0 && c2 < str.length() &&
                str.charAt(c1) == str.charAt(c2)) {
            c1--;
            c2++;
        }
        if(c2-c1 > 1)
            return str.substring(c1+1, c2);
        else return "";
    }

    public static String findLongestPalindrome(String input) {
        if(input == null || input.isEmpty()) return input;
        String max = "";
        for(int i = 0; i < input.length(); i++) {
            System.out.println("i=" + i);
            String sub1 = expandCenter(input, i, i);
            System.out.println(sub1);
            String sub2 = expandCenter(input, i, i+1);
            System.out.println(sub2);
            if(sub1.length() > max.length()) {
                max = sub1;
            }
            if(sub2.length() > max.length()) {
                max = sub2;
            }
        }
        return max;
    }

    /**
     * Define P[ i, j ] ← true iff the substring Si … Sj is a palindrome, otherwise false.
     * Therefore, P[ i, j ] ← ( P[ i+1, j-1 ] and Si = Sj )
     * The base cases:
     *      P[ i, i ] ← true
     *      P[ i, i+1 ] ← ( Si = Si+1 )
     * @param s
     * @return
     */
    private static String findLongestPalindromeDP(String s) {
        boolean[][] table = new boolean[s.length()][s.length()];
        int begin = 0, end = 0;
        //Compute the base cases
        for(int i = 0; i < s.length(); i++) {
            table[i][i] = true;
            if(i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
                table[i][i+1] = true;
                begin = i;
                end = i+1;
            }
        }
        int j;
        //Start from computing the shortest length, 3 characters, then 4, 5, 6...
        for(int len = 3; len < s.length(); len++) {
            for(int i = 0; i < s.length() - len + 1; i++) {
                j = i+len-1;
                if(table[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
                    table[i][j] = true;
                    begin = i;
                    end = j;
                }
            }
        }
        return s.substring(begin, end+1);
    }

    public static void main(String[] args) {
        String input = "1abba23456765432a";
        String p = findLongestPalindrome(input);
        System.out.println(p);

        p = findLongestPalindromeDP("1abba2");
        System.out.println(p);

        p = findLongestPalindromeDP("abc");
        System.out.println(p);

        p = findLongestPalindromeDP("1abba23456765432a");
        System.out.println(p);
    }
}
