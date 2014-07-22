/**
 * Created by kkwang on 7/10/14.
 */
public class NumberPalindrome {
    public static boolean isPalindrome(int input) {
        if(input < 0) return false;

        long div = 1;
        long x = input;
        while(x/div > 0) {
            div *= 10;
        }
        div /= 10;
        while(input != 0) {
            int left = (int)(input / div);
            int right = input % 10;
            if(left != right) return false;
            input = (int)(input - (left*div) - right) / 10;
            div /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean result = isPalindrome(111);
        System.out.println(result);
        result = isPalindrome(1221);
        System.out.println(result);
        result = isPalindrome(11);
        System.out.println(result);
        result = isPalindrome(1234321);
        System.out.println(result);
        result = isPalindrome(12344321);
        System.out.println(result);
        result = isPalindrome(1000000001);
        System.out.println(result);
        result = isPalindrome(9);
        System.out.println(result);
        result = isPalindrome(10000021);
        System.out.println(result);
        result = isPalindrome(10);
        System.out.println(result);
        result = isPalindrome(12345);
        System.out.println(result);
    }
}
