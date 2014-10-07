import java.util.*;

/**
 * Created by kkwang on 9/13/2014.
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 */
public class Combinations {
    public List<List<Integer>> combineRecursive(int n, int k) {
        List<Integer> combo = new LinkedList<Integer>();
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        combineHelper(n, k, 0, combo, res);
        return res;
    }
    private void combineHelper(int n, int k, int start, List<Integer> combo, List<List<Integer>> res) {
        if(n==0) return;
        if(k == 0) {
            List<Integer> c = new ArrayList<Integer>(combo);
            res.add(c);
            return;
        }
        for(int i = start; i <= n-k+1; i++) {
            combo.add(i);
            combineHelper(n, k-1, start+1, combo, res);
            combo.remove(combo.size()-1);
        }
    }

    public static List<List<Integer>> combineIterative(int n, int k) {
        Deque<List<Integer>> queue = new LinkedList<List<Integer>>();
        List<List<Integer>> summary = new LinkedList<List<Integer>>();
        //Add first element
        for (int i = 1; i <= n; i++) {
            List<Integer> list = new LinkedList<Integer>();
            list.add(i);
            queue.add(list);
        }

        while (!queue.isEmpty()) {
            List<Integer> list = queue.pollFirst();
            if (list.size() == k) //Got k numbers
                summary.add(list);
            else {
                for (int i = list.get(list.size() - 1) + 1; i <= n; i++) { //Start from the next number
                    List<Integer> next_list = new LinkedList<Integer>();
                    next_list.addAll(list);
                    next_list.add(i);
                    queue.addLast(next_list);
                }
            }
        }

        return summary;
    }

    public static void main(String[] args) {
        List<List<Integer>> sets = subsetsWithDup(new int[]{1,1});
        for(List<Integer> c : sets) {
            c.forEach(n -> System.out.print(n+ " "));
            System.out.println();
        }

//        List<List<Integer>> results = combineIterative(4, 3);
//        for(List<Integer> c : results) {
//            c.forEach(n -> System.out.print(n+ " "));
//            System.out.println();
//        }
    }

    private static List<List<Integer>> subsets(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        int count = (1 << num.length);
        for(int i = 0; i < count; i++) {
            List<Integer> subset = new LinkedList<Integer>();
            int n = i;
            int t = 0;
            while(n > 0) {

                if((n & 1) == 1) {
                    subset.add(num[t]);
                }
                n = n >> 1;
                t++;
            }
            results.add(subset);
        }
        return results;
    }

    public static List<List<Integer>> subsetsWithDup(int[] num) { //1, 2, 2
        Arrays.sort(num);
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        subsetHelper(num, 0, new LinkedList(), results);
        return results;
    }
    private static void subsetHelper(int[] num, int start, List<Integer> subset, List<List<Integer>> results) {
        results.add(subset);
        for(int i = start; i < num.length; i++) {
            if(i > start && num[i]==num[i-1]) { //skip duplicates
                continue;
            }
            List newset = new LinkedList(subset);
            newset.add(num[i]);
            subsetHelper(num, i+1, newset, results);
        }
    }
}
