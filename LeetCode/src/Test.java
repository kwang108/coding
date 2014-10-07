/**
 * Created by kkwang on 9/8/2014.
 */
public class Test {
    public static int[] plusOne(int[] digits) {
        int carry = 0;
        digits[digits.length-1] += 1;
        for(int i = digits.length-1; i >= 0; i--) {
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] = digits[i] % 10;
        }

        if(carry == 1) {
            int[] result = new int[digits.length+1];
            result[0] = 1;
            for(int i = 1; i < result.length; i++) {
                result[i] = digits[i-1];
            }
            return result;
        }
        return digits;
    }
    public static void main(String[] args) {
        int[] result = plusOne(new int[]{9});
    }
}
