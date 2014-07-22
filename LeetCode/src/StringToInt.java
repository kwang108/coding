/**
 * Created by kkwang on 7/12/14.
 */
public class StringToInt {
    public static int atoi(String str) {
        if(str == null || str.isEmpty()) return 0;
        int x = 0;
        boolean isNeg = str.charAt(0) == '-';
        int i = isNeg ? 1 : 0;
        for(; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c >= '0' && c <= '9') {
                int digit = c - '0';
                if(x < (Math.pow(2, 31) - 1 - digit)/10) {
                    x = x * 10 + digit;
                } else {
                    return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
            } else {
                throw new RuntimeException("invalid char: " + c);
            }
        }
        return isNeg ? -1*x : x;
    }

    public static void main(String[] args) {
        int x = atoi("12345");
        System.out.println(x);
        x = atoi("-1234");
        System.out.println(x);
        x = atoi("0");
        System.out.println(x);
        x = atoi("023431");
        System.out.println(x);
        x = atoi("12312312312312");
        System.out.println(x);
    }
}
