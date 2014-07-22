/**
 * Created by kkwang on 7/20/2014.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        int index = 0, minLength = Integer.MAX_VALUE;
        StringBuilder prefix = new StringBuilder();
        for(int i = 0; i < strs.length; i++) {
            if(strs[i].length() < minLength) minLength = strs[i].length();
        }
        while(index < minLength) {
            char c = strs[0].charAt(index);
            for(int i = 0; i < strs.length; i++) {
                if(c != strs[i].charAt(index)) {
                    return prefix.toString();
                }
            }
            prefix.append(c);
            index++;
        }
        return prefix.toString();
    }
}
