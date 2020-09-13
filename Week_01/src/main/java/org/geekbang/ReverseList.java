package org.geekbang;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: vi.wei
 * Date: 2020-09-13
 * Time: 02:54
 */
public class ReverseList {


    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    // recurse version
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reverse = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return reverse;
    }

    public static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
