package org.geekbang;

import org.geekbang.bean.ListNode;

/**
 * Created with IntelliJ IDEA.
 * Description: 141. 环形链表
 * https://leetcode-cn.com/problems/linked-list-cycle/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china
 * User: vi.wei
 * Date: 2020-09-14
 * Time: 17:36
 */
public class HasCycle {

    public static boolean hasCycle2(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode first = head;
        ListNode second = head;

        while (second.next != null
                && second.next.next != null) {

            first = first.next;
            second = second.next.next;
            if (first == second) {
                return true;
            }
        }

        return false;
    }


    public static boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }


        return true;
    }

}
