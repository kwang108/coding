import java.util.ArrayList;

/**
 * Created by kkwang on 9/6/2014.
 */
public class DivideInteger {
    public static int divide(int dividend, int divisor) {
        if (dividend == 0 || divisor == 1) return dividend;
        if (divisor == -1) return 0-dividend;

        long divd = Math.abs((long)dividend), divs = Math.abs((long)divisor);

        ArrayList<Long> divisors = new ArrayList<Long>();
        while (divs <= divd) {
            divisors.add(divs);
            divs = divs << 1;
        }

        int result = 0, cur = divisors.size() - 1;
        while (divd > 0 && cur >= 0) {
            while (divd >= divisors.get(cur)) {
                divd -= divisors.get(cur);
                result += 1 << cur;
            }
            --cur;
        }

        return (dividend>0)^(divisor>0) ? (-result) : result;
    }

    public static void main(String[] args) {
        divide(9, 2);
    }
}
