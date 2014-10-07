/**
 * Created by kkwang on 8/24/2014.
 */
public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
        int[] m1 = new int[num1.length()];
        int[] m2 = new int[num2.length()];
        int[] res = new int[m1.length+m2.length];
        for(int i = 0; i < num1.length(); i++)
            m1[i] = num1.charAt(i) - '0';
        for(int i = 0; i < num2.length(); i++)
            m2[i] = num2.charAt(i) - '0';

        for(int i = m1.length - 1; i >= 0; i--) {
            for(int j = m2.length - 1; j >= 0; j--) {
                res[i+j+1] += m1[i] * m2[j];
                res[i+j] += res[i+j+1] / 10;
                res[i+j+1] = res[i+j+1] % 10;
            }
        }

        StringBuilder buffer = new StringBuilder();
        for(int i = 0; i < res.length; i++) {
            if(res[i] == 0 && buffer.length() > 0 || res[i] != 0) {
                buffer.append(res[i]);
            }
        }
        return buffer.length()>0? buffer.toString() : "0";
    }

    public static void main(String[] args) {
        String p = multiply("100", "4");
        System.out.println(p);
    }
}
