/**
 * Created by kkwang on 8/7/2014.
 */
public class StringCombination {
    private static void print(char[] chars, int len) {
        for(int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
        System.out.println();
    }
    private static void combine(char[] in, char[] out, int index, int len, boolean[] used) {
        if(index == len) print(out, len);
        else {
            for(int i = 0; i < in.length; i++) {
                if(used[i]) continue;
                out[index] = in[i];
                used[i] = true;
                combine(in, out, index+1, len, used);
                //used[i] = false;
                out[index] = '\0';
            }
        }
    }

    private static void findCombos(char[] in) {
        char[] out = new char[in.length];
        boolean[] used = new boolean[in.length];
        for(int len = 1; len <= in.length; len++) {
            combine(in, out, 0, len, used);
            for(int i = 0; i < used.length; i++) {
                used[i] = false;
            }
        }
    }

    private static void combine2(char[] in, char[] out, int index, int start, int len) {
        for(int i = start; i < in.length; i++) {
            out[index] = in[i];
            print(out, index+1);

            //if(index < len) {
                combine2(in, out, index+1, i+1, len+1);
            //}
            out[index] = '\0';
        }
    }
    private static void findCombos2(char[] in) {
        char[] out = new char[in.length];
        combine2(in, out, 0, 0, 1);
    }

    public static void main(String[] args) {
        String s = "abc";
        findCombos2(s.toCharArray());
    }
}
