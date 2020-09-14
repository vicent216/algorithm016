package org.geekbang;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: vi.wei
 * Date: 2020-09-14
 * Time: 20:39
 */
public class TwoSum {


    public static int[] twoSum2(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int item = nums[i];
            if (map.containsKey(item)) {
                return new int[]{i, map.get(item)};
            }
            map.put(target - item, i);
        }
        return null;
    }

}
