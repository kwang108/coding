/**
 * Created by kkwang on 9/13/2014.
 * Return the smallest character that is strictly larger than the search character,
 * If no such character exists, return the smallest character in the array.
 * If last character in the array, wrap around and return the first char in the array.
 * ['c', 'f', 'j', 'p', 'v'], 'a' => 'c'
 * ['c', 'f', 'j', 'p', 'v'], 'c' => 'f'
 * ['c', 'f', 'j', 'p', 'v'], 'k' => 'p'
 * ['c', 'f', 'j', 'p', 'v'], 'z' => 'c' // The wrap around case
 * ['c', 'f', 'k'], 'f' => 'k'
 * ['c', 'f', 'k'], 'c' => 'f'
 * ['c', 'f', 'k'], 'd' => 'f'
 */
public class NextLargerChar {
    static char findNextChar(char[] ca, char c) {
        int start = 0, end = ca.length - 1;
        while(start <= end) {
            int middle = (end - start)/2 + start;
            if(ca[middle] == c) {
                return middle == ca.length-1 ? ca[0] : ca[middle+1];
            } else if(ca[middle] < c) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return start==ca.length-1 ? ca[0] : ca[start];
    }

    public static void main(String[] args) {
        String input = "cfjpv";
        char c = findNextChar(input.toCharArray(), 'd');
        System.out.println(c);
    }
}
