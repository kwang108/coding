import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by kkwang on 8/26/2014.
 */
public class Anagrams {
    public static List<String> anagrams(String[] strs) {
        List<String> res = new LinkedList<String>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(int i = 0; i < strs.length; i++) {
            String key = generateKey(strs[i]);
            if(map.containsKey(key)) {
                map.get(key).add(strs[i]);
            } else {
                List<String> anagrams = new LinkedList<String>();
                anagrams.add(strs[i]);
                map.put(key, anagrams);
            }
        }
        for(List values : map.values()) {
            if(values.size() > 1) {
                res.addAll(values);
            }
        }
        return res;
    }
    //Generate a key such as "aabc" -> "a2b1c1"
    public static String generateKey(String s) {
        int[] map = new int[26];
        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            map[index]++;
        }
        StringBuilder br = new StringBuilder();
        for(int i = 0; i < map.length; i++) {
            if(map[i] > 0)
                br.append((char)('a'+i)).append(map[i]);
        }
        return br.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"cat", "tot", "bag"};
        List<String> anagrams = anagrams(strs);
    }
}
