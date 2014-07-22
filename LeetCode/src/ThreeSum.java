import java.util.*;

/**
 * Created by kkwang on 7/20/2014.
 *
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
 *    (-1, 0, 1)
 *    (-1, -1, 2)
 */
public class ThreeSum {
    private static List addResult(List list, int x, int y, int z) {
        System.out.println(x +", " + y + ", " +z);
        List<Integer> result = new LinkedList<Integer>();
        result.add(x);
        result.add(y);
        result.add(z);
        result.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        list.add(result);
        return result;
    }
    private static void threeSum(int[] num) {
        List result = new LinkedList();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < num.length; i++) {
            if(map.containsKey(num[i])) {
                map.put(num[i], map.get(num[i])+1);
            } else {
                map.put(num[i], 1);
            }
        }
        for(int i = 0; i < num.length; i++) {
            int x = num[i];
            for(int j = i+1; j < num.length; j++) {
                int y = num[j];
                int z = 0 - x - y;
                if(!map.containsKey(z)) continue;
                int countZ = map.get(z);
                if(countZ > 0) { //Found a potential triplet x, y, z
                    if(x == z && y == z && countZ >= 3) {
                        map.put(z, countZ-3);
                        addResult(result, x, y, z);
                    } else if(x == z && y != z && countZ >= 2) {
                        map.put(z, countZ-2);
                        map.put(y, map.get(y)-1);
                        addResult(result, x, y, z);
                    } else if(x != z && y == z && countZ >= 2) {
                        map.put(z, countZ-2);
                        map.put(x, map.get(x)-1);
                        addResult(result, x, y, z);
                    } else if(x != z && x != y && y != z && countZ > 0 && map.get(x) > 0 && map.get(y) > 0) {
                        map.put(x, map.get(x)-1);
                        map.put(y, map.get(y)-1);
                        map.put(z, map.get(z)-1);
                        addResult(result, x, y, z);
                    }
                }
            }
        }
    }

    private static void addResult(Set<String> set, List list, int x, int y, int z) {
        List<Integer> result = new LinkedList<Integer>();
        if(x < y) {
            result.add(x);
            result.add(y);
        } else {
            result.add(y);
            result.add(x);
        }
        if(z < result.get(0)) {
            result.add(0, z);
        } else if(z < result.get(1)) {
            result.add(1, z);
        } else result.add(z);
        String key = result.get(0)+""+result.get(1)+""+result.get(2);
        if(set.contains(key)) return;
        set.add(key);
        list.add(result);
        //System.out.println(x +", " + y + ", " +z);
    }
    private static List<List<Integer>> threeSum2(int[] num) {
        List result = new LinkedList();
        //Arrays.sort(num);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < num.length; i++) {
            if(map.containsKey(num[i])) {
                map.put(num[i], map.get(num[i])+1);
            } else {
                map.put(num[i], 1);
            }
        }
        Set<String> set = new HashSet<String>();
        for(int i = 0; i < num.length; i++) {
            int x = num[i];
            for (int j = i + 1; j < num.length; j++) {
                int y = num[j];
                int z = 0 - x - y;
                if(map.containsKey(z) && map.get(z) > 0) {
                    if(z != x && z != y) {
                        addResult(set, result, x, y, z);
                    } else if(map.get(z) >= 2) {
                        addResult(set, result, x, y, z);
                    } else if(x == 0 && y == 0 && z ==0 && map.get(z) >= 3) {
                        addResult(set, result, x, y, z);
                    }
                }
            }
        }
        return result;
    }

    private static List<List<Integer>> threeSumOptimal(int[] num) {
        if(num == null || num.length < 3) return new ArrayList<>();
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(num);
        int j, k, sum;
        for(int i = 0; i < num.length-2; i++) {
            if(i > 0 && num[i] == num[i-1]) continue;
            j = i+1;
            k = num.length-1;
            while(j < k) {
                sum = num[i] + num[j] + num[k];
                if (sum < 0) {
                    j++;
                    while (j < num.length - 1 && num[j - 1] == num[j]) j++;
                } else if (sum > 0) {
                    k--;
                    while (k > 0 && num[k + 1] == num[k]) k--;
                } else {
                    List<Integer> triplet = new ArrayList<>(3);
                    triplet.add(num[i]);
                    triplet.add(num[j]);
                    triplet.add(num[k]);
                    result.add(triplet);
                    j++;
                    while (j < num.length - 1 && num[j - 1] == num[j]) j++;
                    k--;
                    while (k > 0 && num[k + 1] == num[k]) k--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = {-1, 0, 1, 2, -1, -4};
        //threeSum(num);
        List<List<Integer>> result = threeSumOptimal(num);
        for(List<Integer> list : result) {
            System.out.println(list.get(0) + " " + list.get(1) + " " + list.get(2));
        }
        System.out.println();
        num = new int[]{-2, 0, 1, 1, 2};
        result = threeSumOptimal(num);
        for(List<Integer> list : result) {
            System.out.println(list.get(0) + " " + list.get(1) + " " + list.get(2));
        }
        System.out.println();

        num = new int[]{1, 1, 1};
        result = threeSumOptimal(num);

        num = new int[]{-2, 0, 0, 2, 2};
        result = threeSumOptimal(num);
        for(List<Integer> list : result) {
            System.out.println(list.get(0) + " " + list.get(1) + " " + list.get(2));
        }
    }
}
