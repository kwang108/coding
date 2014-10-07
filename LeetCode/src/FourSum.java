import java.util.*;

/**
 * Created by kkwang on 7/22/2014.
 */
public class FourSum {
    private static boolean checkDuplicate(int[] p, int i, int j){
        return (p[0] == i || p[1] == j || p[1] == i || p[1]==j);
    }

    public static List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Map<Integer, List<int[]>> map = new HashMap<>();
        Arrays.sort(num);
        int count = 0;
        for(int i = 0; i < num.length-1; i++) {
            for(int j = i+1; j < num.length; j++) {
                if(num[j] == num[i] && count < 4) {
                    count++;
                    if(count == 4 && num[j] * 4==target) {
                        List<Integer> quad = new ArrayList<>();
                        for(int k = 1; k <= 4; k++) quad.add(num[j]);
                        result.add(quad);
                    }
                }
                int s = num[i] + num[j];
                int[] indices = new int[]{i, j};
                if(map.containsKey(s)) {
                    List<int[]> list = map.get(s);
                    int[] lastIndices = list.get(list.size()-1);
                    if(num[i]!=num[lastIndices[0]] && num[j]!=num[lastIndices[1]]) {
                        map.get(s).add(indices);
                    }
                } else {
                    List<int[]> list = new LinkedList<>();
                    list.add(indices);
                    map.put(s, list);
                }
            }
        }

        for(int i = 0; i < num.length-3; i++) {
            //if(i > 0 && num[i] == num[i-1]) continue;

            for(int j = i+1; j < num.length-2; j++) {
                if(j > 0 && num[j] == num[j-1]) continue;
                int sum1 = num[i] + num[j];
                int sum2 = target - sum1;
                if(map.containsKey(sum2)) {
                    List<int[]> list = map.get(sum2);
                    for(int m = 0; m < list.size(); m++) {
                        int[] indices = list.get(m);
                        if(checkDuplicate(indices, i, j)) continue;
                        else {
                            List<Integer> quad = new ArrayList<>();
                            quad.add(num[i]);
                            quad.add(num[j]);
                            quad.add(num[indices[0]]);
                            quad.add(num[indices[1]]);
                            result.add(quad);
                        }
                    }
                }
            }
        }
        return result;
    }

    private static void printResult(List<List<Integer>> result) {
        for(int i = 0; i < result.size(); i++) {
            List<Integer> quad = result.get(i);
            System.out.println(quad.get(0) + ", " + quad.get(1) + ", " + quad.get(2) + ", " + quad.get(3));
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] num = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> result = fourSum(num, 0);
        printResult(result);

        num = new int[]{0, 0, 0, 0};
        result = fourSum(num, 1);
        printResult(result);

        num = new int[]{-3,-1,0,2,4,5};
        result = fourSum(num, 0);
        printResult(result);
    }
}
