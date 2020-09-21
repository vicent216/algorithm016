package org.geekbang;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description: 347. 前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * User: vi.wei
 * Date: 2020-09-21
 * Time: 18:32
 */
public class TopKFrequent {

    public static void main(String[] args) {
        int[] ints = {3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5, 6};
        topKFrequent(ints, 10);
    }

    public static int[] topKFrequent(int[] nums, int k) {


        Map<Integer, Integer> frequentMap = new HashMap<>();
        for (int num : nums) {
            Integer value = frequentMap.get(num);
            if (value == null) {
                frequentMap.put(num, 1);
            } else {
                frequentMap.put(num, ++value);
            }
        }


        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(frequentMap::get));


        for (int num : frequentMap.keySet()) {
            if (queue.size() < k) {
                queue.add(num);
                continue;
            }
            if (frequentMap.get(num) > frequentMap.get(queue.peek())) {
                queue.poll();
                queue.add(num);
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }

        return result;
    }
}
