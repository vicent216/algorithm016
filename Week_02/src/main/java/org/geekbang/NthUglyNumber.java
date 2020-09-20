package org.geekbang;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description: 剑指 Offer 49. 丑数
 * https://leetcode-cn.com/problems/chou-shu-lcof/
 * https://leetcode-cn.com/problems/get-kth-magic-number-lcci/
 * User: vi.wei
 * Date: 2020-09-20
 * Time: 23:25
 */
public class NthUglyNumber {

    public int nthUglyNumber(int n) {

        int[] uglyNumbers = {2, 3, 5};

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();

        queue.add(1);

        while (set.size() < n) {

            Integer poll = queue.poll();
            set.add(poll);
            if (set.size() == n) {
                return poll;
            }

            for (int uglyNumber : uglyNumbers) {
                int addItem = poll * uglyNumber;
                if (!set.contains(addItem)) {
                    queue.add(addItem);
                }
            }
        }

        return -1;
    }


}
