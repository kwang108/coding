/**
 * Created by kkwang on 7/26/2014.
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 * For example:
 * Given 1 -> 2 -> 3 -> 4 -> 5 -> |, m = 2 and n = 4, return 1 -> 4 -> 3 -> 2 -> 5 -> |.
 *
 * Note: m and n are both 1-based and assume 1 <= m <= n <= list length.
 */
public class ReverseListRange {
    private static void reverseRange(ListNode head, int m, int n) {
        ListNode pt = null, curr = head;
        for(int i = 1; i < m; i++) {
            pt = curr;
            curr = curr.next;
        }
        ListNode ct = curr;
        ListNode prev = null, next = null;
        for(int i = m; i <= n; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        pt.next = prev;
        ct.next = curr;
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy, curr = head;
        int pos = 1;
        while(pos < m) {
            pre = curr;
            curr = curr.next;
            pos++;
        }
        while(pos < n && curr != null) {
            ListNode nt = curr.next.next;
            curr.next.next = pre.next;
            pre.next = curr.next;
            curr.next = nt;
            pos++;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode prev = head;
        for(int i = 2; i < 11; i++) {
            ListNode node = new ListNode(i);
            prev.next = node;
            prev = node;
        }
        reverseRange(head, 1, 2);
        while(head != null) {
            System.out.print(head.val+"->");
            head = head.next;
        }
        System.out.println();
    }
}
