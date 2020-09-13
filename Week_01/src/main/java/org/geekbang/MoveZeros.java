package org.geekbang;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: vi.wei
 * Date: 2020-09-10
 * Time: 21:34
 */
public class MoveZeros {


    public static void main(String[] args) {

        int[] nums = {1, 0, 5, 2, 0, 3, 0, 4};
        moveZeros2(nums);

        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static void moveZeros2(int[] nums) {

        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num != 0) {
                nums[index] = num;
                if (i != index) {
                    nums[i] = 0;
                }
                index++;
            }
        }

    }


    public static void moveZeros(int[] nums) {
        if (nums == null) {
            return;
        }

        int point = 0;

        for (int i = 0; i < nums.length; i++) {
            int item = nums[i];

            if (item != 0) {
                nums[point] = item;
                point++;
            }
        }

        for (int i = point; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
