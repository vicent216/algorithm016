package org.geekbang;

import org.geekbang.bean.ListNode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: vi.wei
 * Date: 2020-09-14
 * Time: 17:36
 */
public class HasCycle {

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
