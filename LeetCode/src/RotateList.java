/**
 * Created by kkwang on 9/6/2014.
 *
 * Given a list, rotate the list to the right by n places, where n is non-negative.
 *
 */
public class RotateList {
    public static ListNode rotateRight(ListNode head, int n) {
        ListNode n1 = head, n2 = head;
        if(head == null || head.next == null || n <= 0) return head;

        for(int i = 1; i <= n; i++) {
            if(n2.next == null) n2.next = head; //If n is larger than length of the list, make the list circular
            n2 = n2.next;
        }
        while(n2.next != null && n2.next != head) {
            n1 = n1.next;
            n2 = n2.next;
        }
        n2.next = head;
        head = n1.next;
        n1.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = head;
        int size = 4;
        for(int i = 2; i <= size ; i++) {
            ListNode node = new ListNode(i);
            n1.next = node;
            n1 = node;
        }
        ListNode result = rotateRight(head, 5);
        for(int i = 1; i <= size; i++) {
            System.out.print(result.val+ " ");
            result = result.next;
        }
    }
}
