package org.geekbang;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 15. 三数之和
 * https://leetcode-cn.com/problems/3sum/
 * User: vi.wei
 * Date: 2020-09-13
 * Time: 01:24
 */
public class ThreeSum {

    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{34, 55, 79, 28, 46, 33, 2, 48, 31, -3, 84, 71, 52, -3, 93, 15,
                21, -43, 57, -6, 86, 56, 94, 74, 83, -14, 28, -66, 46, -49, 62, -11, 43, 65, 77, 12, 47, 61, 26, 1,
                13, 29, 55, -82, 76, 26, 15, -29, 36, -29, 10, -70, 69, 17, 49});
        System.out.println(lists);
    }


    public static List<List<Integer>> threeSum2(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int item = nums[i];

            int first = i + 1;
            int last = nums.length - 1;

            while (first < last) {
                int sum = nums[first] + nums[last] + item;

                if (sum > 0) {
                    while (first < last && nums[last - 1] == nums[last]){
                        last--;
                    }
                    last--;
                    continue;
                }
                if (sum < 0) {
                    while (first < last && nums[first] == nums[first + 1]) {
                        first++;
                    }
                    first++;
                    continue;
                }

                result.add(Arrays.asList(item, nums[first], nums[last]));
                while (first < last && nums[last - 1] == nums[last]){
                    last--;
                }
                last--;
                while (first < last && nums[first] == nums[first + 1]) {
                    first++;
                }
                first++;

            }
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }


    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            if (nums[i] > 0) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = -nums[i];

            int first = i + 1;
            int last = nums.length - 1;

            while (first < last) {
                int firstItem = nums[first];
                int lastItem = nums[last];

                int sum = firstItem + lastItem;


                if (sum < target) {
                    first++;
                    while (first < last && nums[first] == nums[first - 1]) {
                        first++;
                    }
                } else if (sum > target) {
                    last--;
                    while (first < last && nums[last] == nums[last + 1]) {
                        last--;
                    }
                } else {

                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(firstItem);
                    list.add(lastItem);
                    result.add(list);

                    first++;
                    while (first < last && nums[first] == nums[first - 1]) {
                        first++;
                    }
                    last--;
                    while (first < last && nums[last] == nums[last + 1]) {
                        last--;
                    }
                }

            }
        }
        return result;
    }
}
