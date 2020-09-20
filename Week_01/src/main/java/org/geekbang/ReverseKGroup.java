package org.geekbang;

import org.geekbang.bean.ListNode;

/**
 * Created with IntelliJ IDEA.
 * Description: 25. K 个一组翻转链表
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * User: vi.wei
 * Date: 2020-09-14
 * Time: 21:13
 */
public class ReverseKGroup {

    public static void main(String[] args) {
        ListNode list = ListNode.generateList();


        ListNode print = list;
        while (print != null) {
            System.out.print(print.val + " ");
            print = print.next;
        }
        System.out.println();

        ListNode listNode = reverseKGroup(list, 4);

        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;

        ListNode tail;
        while ((tail = getKElementTail(prev.next, k)) != null) {
            ListNode next = tail.next;
            ListNode newTail = prev.next;
            tail.next = null;
            prev.next = reverseKList(prev.next);
            newTail.next = next;
            prev = newTail;
        }

        return dummy.next;
    }

    private static ListNode reverseKList(ListNode head) {

        if (head == null) {
            return null;
        }

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


    public static ListNode getKElementTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode curr = head;
        for (int i = 1; i < k; i++) {
            curr = curr.next;
            if (curr == null) {
                return null;
            }
        }
        return curr;
    }
}
