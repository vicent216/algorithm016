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

    public static void main(String[] args) {
        int i = nthUglyNumber(1365);
        System.out.println(i);

        int a = 430000000;
        int maxValue = Integer.MAX_VALUE;
        System.out.println(maxValue);
    }

    public static int nthUglyNumber(int n) {

        int[] uglyNumbers = {2, 3, 5};

        PriorityQueue<Long> queue = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();

        queue.add(1L);

        while (set.size() < n) {

            Long poll = queue.poll();

            if (set.contains(poll)) {
                continue;
            }

            set.add(poll);
            if (set.size() == n) {
                return poll.intValue();
            }

            for (int uglyNumber : uglyNumbers) {
                long addItem = poll * uglyNumber;
                queue.add(addItem);
            }
        }

        return -1;
    }


}
