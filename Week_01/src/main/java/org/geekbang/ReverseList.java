package org.geekbang;

import org.geekbang.bean.ListNode;

/**
 * Created with IntelliJ IDEA.
 * Description: 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * User: vi.wei
 * Date: 2020-09-13
 * Time: 02:54
 */
public class ReverseList {


    public static ListNode reverseListRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reverse = reverseListRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return reverse;
    }

    public static ListNode reverseList3(ListNode head) {

        ListNode first = null;
        ListNode second = head;

        while (second != null) {
            ListNode temp = second.next;
            second.next = first;
            first = second;
            second = temp;
        }

        return first;
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
