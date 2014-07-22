/**
 * Created by kkwang on 7/19/14.
 */
public class Int2Roman {
    static void gen_str(StringBuilder s, int num, char one, char five, char ten)
    {
        switch (num)
        {
            case 1:
                s.append(one);
                break;
            case 2:
                s.append(one).append(one);
                break;
            case 3:
                s.append(one).append(one).append(one);
                break;
            case 4:
                s.append(one).append(five);
                break;
            case 5:
                s.append(five);
                break;
            case 6:
                s.append(five).append(one);
                break;
            case 7:
                s.append(five).append(one).append(one);
                break;
            case 8:
                s.append(five).append(one).append(one).append(one);
                break;
            case 9:
                s.append(one).append(ten);
                break;
        }
    }
    static String intToRoman(int num) {
        int th = num / 1000 % 10;
        int hu = num / 100 % 10;
        int te = num / 10 % 10;
        int on = num % 10;
        StringBuilder ret = new StringBuilder();
        gen_str(ret, th, 'M', 'V', 'X');
        gen_str(ret, hu, 'C', 'D', 'M');
        gen_str(ret, te, 'X', 'L', 'C');
        gen_str(ret, on, 'I', 'V', 'X');
        return ret.toString();
    }

    public static void main(String[] args) {
        String result = intToRoman(8);
        System.out.println(result);
    }
}
