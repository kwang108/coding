import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by kkwang on 7/9/14.
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < numbers.length; i++) {
            if(map.containsKey(numbers[i])) {
                List<Integer> indices = map.get(numbers[i]);
                indices.add(i+1);
            } else {
                List<Integer> indices = new LinkedList<Integer>();
                indices.add(i+1);
                map.put(numbers[i], indices);
            }
        }
        for(int i = 0; i < numbers.length; i++) {
            int other = target - numbers[i];
            List<Integer> indices = map.get(numbers[i]);
            result[0] = indices.get(0);
            if(numbers[i] == other) {
                if(indices.size() > 1) {
                    result[1] = indices.get(1);
                    return result;
                }
            } else if(map.containsKey(other)) {
                //Found a match
                result[1] = map.get(other).get(0);
                return result;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] input = {4,6,11,15};
        TwoSum twoSum = new TwoSum();
        int[] results = twoSum.twoSum(input, 8);
        if(results != null) {
            System.out.println(results[0] + ", " + results[1]);
        } else {
            System.out.println("No match found");
        }
    }
}
