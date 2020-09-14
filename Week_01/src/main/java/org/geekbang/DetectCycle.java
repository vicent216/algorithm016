package org.geekbang;

import org.geekbang.bean.ListNode;

/**
 * Created with IntelliJ IDEA.
 * Description: 环形链表 II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * User: vi.wei
 * Date: 2020-09-14
 * Time: 19:18
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);

        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

}
