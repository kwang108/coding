/**
 * Created by kkwang on 7/26/2014.
 */
public class SwapTwoNodes {
    /*
        For nodes in the middle of the list, swap two nodes, say node A->B, is simple:
        1. Find the node, say node N, ahead of the two nodes (i.e. ahead of node A, N->A->B) and store its next node (i.e. node A) to a temp node;
        2. Set node B as the next node of N;
        3. Set node B's next as the next node of A;
        4. Set node A as the next node of B;
        5. Forward N to A and repeat above steps if it has two next nodes.
     */
    private static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;

        while(curr.next != null && curr.next.next != null) {
            ListNode temp = curr.next;  //1
            curr.next = curr.next.next; //2
            temp.next = curr.next.next; //3
            curr.next.next = temp;      //4
            curr = temp;                //5
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
        head = swapPairs(head);
        while(head != null) {
            System.out.print(head.val+"->");
            head = head.next;
        }
    }
}
