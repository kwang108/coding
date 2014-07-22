/**
 * Created by kkwang on 7/13/14.
 */
public class ReverseInt {
    public static int reverse(int x) {
        long r = 0;
        boolean isNeg = x < 0;
        if(isNeg) x *= -1;
        while(x != 0) {
            r = r * 10 + (x % 10);
            x = x / 10;
        }
        r = isNeg ? r*-1 : r;
        if(r > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else if(r < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else return (int)r;
    }

    public static void main(String[] args) {
        int result = reverse(123);
        System.out.println(result);

        result = reverse(-123);
        System.out.println(result);

        result = reverse(0);
        System.out.println(result);

        result = reverse(1234);
        System.out.println(result);

        result = reverse(-1234);
        System.out.println(result);
    }
}
