/**
 * Created by kkwang on 8/3/2014.
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 * The replacement must be in-place, do not allocate extra memory.

 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2 → 2,1,3 → 2,3,1 → 3,1,2 → 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1 → 5,1,1 → 1,1,5
 * 2,2,7,5,4,3,2,2,1 → 2,3,1,2,2,2,4,5,7
 */
public class NextPermutation {
    private void swap(int[] num, int a, int b) {
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }

    private void reverse(int[] num, int a, int b) {
        int start = a, end = b;
        while(start < end) {
            int temp = num[start];
            num[start++] = num[end];
            num[end--] = temp;

        }
    }

    public void nextPermutation(int[] num) {
        if (num == null || num.length < 2) return;
        int curr = num.length-1;
        //Find the longest descending tail 2,2,7,5,4,3,2,2,1 -> 7543221
        while(curr > 0 && num[curr] <= num[curr-1]) curr--;
        //Reverse the descending tail
        reverse(num, curr, num.length-1);
        if(curr > 0) {
            int next = curr;
            curr -= 1;
            //Find the first number in the tail that's greater than the number just before the tail
            //1 2 4 3 1 (tail is 4 3 1) -> 1 2 1 3 4 -> 1 3 1 2 4 (2 is before the tail, and it's smaller than 3, swap 2 and 3)
            while(num[next] <= num[curr]) {
                next++;
            }
            swap(num, curr, next);
        }
    }

    public static void main(String[] args) {
        NextPermutation permutation = new NextPermutation();
        int[] num = {1,1};
        permutation.nextPermutation(num);
        for(int i = 0; i < num.length; i++) {
            System.out.print(num[i]);
            System.out.print(" ");
        }
    }
}
