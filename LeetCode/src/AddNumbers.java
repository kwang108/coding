import java.util.List;

/**
 * Created by kkwang on 7/12/14.
 */
public class AddNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        int value = l1.val + l2.val;
        int carry = value / 10;

        ListNode current = new ListNode(value % 10);
        ListNode result = current;
        while(l1.next != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
            value = l1.val + l2.val + carry;
            ListNode digit = new ListNode(value % 10);
            carry = value / 10;
            current.next = digit;
            current = current.next;
        }
        ListNode node = l1.next!=null ? l1.next : l2.next;
        while(node != null) {
            value = node.val + carry;
            carry = value / 10;
            current.next = new ListNode(value % 10);
            current = current.next;
            node = node.next;
        }
        if(carry > 0) {
            current.next = new ListNode(carry);
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(6);

        ListNode result = addTwoNumbers(l1, l2);
        printNumber(result);
    }

    private static void printNumber(ListNode node) {
        while(node != null) {
            System.out.print(node.val);
            node = node.next;
        }
    }
}

