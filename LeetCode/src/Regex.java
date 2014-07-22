/**
 * Created by kkwang on 7/14/14.
 */
public class Regex {
    public static boolean isMatch(String s, int si, String p, int pi) {
        if(s == null) return false;
        if(p == null) return false;
        else if(s.equals(p)) return true;

        if(pi > p.length()-1) return si > s.length()-1; //we have traversed the entire pattern string

        if(pi == p.length()-1 || p.charAt(pi+1) != '*') { //Next character is not *
            return si < s.length() && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.') && isMatch(s, si+1, p, pi+1);
        } else {
            //Next char in the pattern is *, we need to exhaustively match the preceding char
            //E.g., abbc : ab*c, we have to keep looking for 'b' in s until we don't find a match,
            //      which means that we are looking at 'c', and need to match it against the next char in the pattern.
            while(si < s.length() && pi < p.length()) {
                if(s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.') {
                    if(isMatch(s, si, p, pi+2)) return true; //If the chars after * match pattern, then stop matching *
                                                             //E.g., aaa->a*a, the last a matches pattern, so stop matching *
                } else break;
                si++;
            }
            return isMatch(s, si, p, pi+2);
        }
    }

    public static boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }
    public static void main(String[] args) {
        boolean result = isMatch("a", "");
        System.out.println(result);

        result = isMatch("", "a*");
        System.out.println(result);

        result = isMatch("bb", ".bab");
        System.out.println(result);

        result = isMatch("", "bab");
        System.out.println(result);

        result = isMatch("", ".");
        System.out.println(result);

        result = isMatch("a", "a");
        System.out.println(result);

        result = isMatch("abc", "ab*c");
        System.out.println(result);

        result = isMatch("ac", "ab*c");
        System.out.println(result);

        result = isMatch("aa", "a*");
        System.out.println(result);

        result = isMatch("ab", ".*");
        System.out.println(result);

        result = isMatch("aab", "c*a*b*");
        System.out.println(result);

        result = isMatch("aa", "a");
        System.out.println(result);

        result = isMatch("ab", ".*c");
        System.out.println(result);

        result = isMatch("aaa", "a*a");
        System.out.println(result);

        result = isMatch("aab", "aa*ab");
        System.out.println(result);
    }
}
