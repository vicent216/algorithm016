package org.geekbang;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: vi.wei
 * Date: 2020-09-13
 * Time: 01:08
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] input = new int[]{2, 7, 11, 15};
        int[] result = twoSum(input, 9);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int item = nums[i];
            if (map.containsKey(item)) {
                return new int[]{i, map.get(item)};
            }
            map.put(target - item, i);
        }
        return new int[0];
    }
}
