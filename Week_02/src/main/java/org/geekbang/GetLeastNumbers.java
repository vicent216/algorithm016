package org.geekbang;

import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description: 剑指 Offer 40. 最小的k个数
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * User: vi.wei
 * Date: 2020-09-20
 * Time: 22:02
 */
public class GetLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {

        if (arr == null || arr.length <= k) {
            return arr;
        }

        if (k == 0) {
            return new int[0];
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        for (int num : arr) {
            if (queue.size() < k) {
                queue.offer(num);
            } else if (num < queue.peek()) {
                queue.poll();
                queue.offer(num);
            }
        }

        int[] result = new int[k];
        int i = 0;
        for (Integer integer : queue) {
            result[i++] = integer;
        }

        return result;
    }

}
