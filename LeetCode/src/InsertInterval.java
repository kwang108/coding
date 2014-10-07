import java.util.LinkedList;
import java.util.List;

/**
 * Created by kkwang on 9/2/2014.
 */
public class InsertInterval {
    static class Interval {
        int start, end;
        Interval(int a, int b) {
            start = a;
            end = b;
        }
    }

    private static int findInsertPos(List<Interval> intervals, Interval newInterval) {
        int start = 0, end = intervals.size()-1;
        int mid = 0;
        while(start <= end) {
            mid = (end - start)/2 + start;
            Interval it = intervals.get(mid);
            if(it.end == newInterval.start) return mid;
            else if(it.end < newInterval.start) start = mid+1;
            else end = mid-1;
        }
        return start;
    }
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int pos = findInsertPos(intervals, newInterval);
        if(pos >= intervals.size()) {
            intervals.add(newInterval); //clean append
        } else if(intervals.get(pos).start > newInterval.end) {
            intervals.add(pos, newInterval); //clean insert
        } else {
            intervals.add(pos, newInterval);
            while(pos < intervals.size()-1 && intervals.get(pos).end >= intervals.get(pos+1).start) {
                intervals.get(pos).start = Math.min(intervals.get(pos).start, intervals.get(pos+1).start);
                intervals.get(pos).end = Math.max(intervals.get(pos).end, intervals.get(pos+1).end);
                intervals.remove(pos+1);
            }
        }
        return intervals;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new LinkedList<>();
        intervals.add(new Interval(2,4));
        intervals.add(new Interval(5,7));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(11,13));

        insert(intervals, new Interval(3, 8));
    }
}
