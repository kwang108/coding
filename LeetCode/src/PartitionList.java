/**
 * Created by kkwang on 9/28/2014.
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 You should preserve the original relative order of the nodes in each of the two partitions.

 Note that this is different from "moving all <x nodes before x and all >=x nodes after x".

 For example,
 given 1 -> 4 -> 3 -> 2 -> 5 -> 2 and x = 3, return 1 -> 2 -> 2 -> 4 -> 3 -> 5.
 given 1 -> 3 -> -1 -> 5 -> 2 -> 1 and x = 3, return 1 -> -1 -> 2 -> 1 -> 3 -> 5.
 */
public class PartitionList {
    public static ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode last = dummy;
        while(last.next != null && last.next.val < x) {
            last = last.next; //last node smaller than x
        }

        ListNode nt = last;
        while(nt.next != null) {
            if(nt.next.val >= x) {
                nt = nt.next; //last node larger than x
            } else {
                ListNode tmp = nt.next; //tmp is smaller than x
                nt.next = tmp.next;
                tmp.next = last.next;
                last.next = tmp;
                last = tmp;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        partition(head, 1);
    }
}
