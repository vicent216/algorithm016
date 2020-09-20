package org.geekbang;

import org.geekbang.bean.ListNode;

/**
 * Created with IntelliJ IDEA.
 * Description: 24. 两两交换链表中的节点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * User: vi.wei
 * Date: 2020-09-13
 * Time: 16:10
 */
public class SwapPairs {

    public static void main(String[] args) {


        ListNode listNode = swapPairs(ListNode.generateList());
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    public static ListNode swapPairs2(ListNode head) {

        ListNode dummy = new ListNode(-1);

        dummy.next = head;

        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {

            ListNode first = prev.next;
            ListNode second = prev.next.next;

            prev.next = second;
            first.next = second.next;
            second.next = first;

            prev = first;
        }

        return dummy.next;
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
