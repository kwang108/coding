/**
 * Created by kkwang on 7/26/2014.
 *
 * Given a linked list, reverse every k nodes of a linked list and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Note: You may not alter the values in the nodes, only nodes itself may be changed. Only constant memory is allowed.
 *
 * For example: given this linked list: 1->2->3->4->5,
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseListKGroups {
    /**
     * Reverse nodes in a range. Take the node ahead of the range and last node in the range.
     * @param pre
     * @param end
     * @return
     */
    private static ListNode reverseRange(ListNode pre, ListNode end) {
        ListNode curr = pre.next;
        ListNode ct = curr;
        ListNode prev = null, next = null;
        while(curr != end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode temp = curr.next; //For example, end is 3, now curr is 3, prev is 2, pre is dummy, ct is 1. List looks like 2->1 3->4->5
        curr.next = prev;          //we want the list to be 3->2->1->4->5
        pre.next = curr;
        ct.next = temp;
        return ct;
    }

    private static ListNode reverseKGroups(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int pos = 1;
        ListNode pre = dummy, curr = head;
        while(curr != null) {
            if(pos == k) {
                pos = 0;
                pre = reverseRange(pre, curr);
                curr = pre.next;
            } else {
                curr = curr.next;
            }
            pos++;
        }
        return dummy.next;
    }

    private static void print(ListNode head) {
        while(head != null) {
            System.out.print(head.val+"->");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode prev = head;
        for(int i = 2; i < 11; i++) {
            ListNode node = new ListNode(i);
            prev.next = node;
            prev = node;
        }
        head = reverseKGroups(head, 3);
        print(head);
    }
}
