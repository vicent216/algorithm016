package org.geekbang;

import org.geekbang.bean.ListNode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: vi.wei
 * Date: 2020-09-13
 * Time: 16:10
 */
public class SwapPairs {

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(2);

        ListNode listNode = swapPairs(head);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode prev = new ListNode(-1);
        prev.next = head;

        ListNode temp = prev;

        while (temp.next != null && temp.next.next != null) {

            ListNode first = temp.next;
            ListNode second = first.next;

            first.next = second.next;
            temp.next = second;
            second.next = first;

            temp = first;
        }
        return prev.next;
    }

}
