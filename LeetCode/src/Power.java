/**
 * Created by kkwang on 8/27/2014.
 */
public class Power {
    public static double pow(double x, int n) {
        double result = 1.0;
        int m = Math.abs(n);
        for(; m > 0; m = m >> 1) {
            if((m & 1) == 1) result *= x;
            x *= x;
        }
        if(n < 0) result = 1.0 / result;
        return result;
    }

    public static double pow2(double x, int n) {
        double result = 1;
        for (int m = Math.abs(n); m > 0; x *= x, m >>= 1) {
            if ((m & 1) == 1) result *= x;
        }
        return (n >= 0) ? result : 1.0 / (result);
    }

    public static void main(String[] args) {
        double result = pow(8.8, 3);
    }
}
