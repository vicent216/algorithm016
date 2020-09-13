package org.geekbang;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: vi.wei
 * Date: 2020-09-11
 * Time: 18:36
 */
public class MaxArea {

    public static void main(String[] args) {
        int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int area = maxArea2(input);
        System.out.println(area);
    }


    public static int maxArea2(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int first = 0;
        int last = height.length - 1;

        int result = 0;

        while (first < last) {

            result = Math.max(result, Math.min(height[first], height[last]) * (last - first));

            if (height[first] < height[last]) {
                first++;
            } else {
                last--;
            }
        }

        return result;
    }


    public static int maxArea(int[] height) {

        if (height == null) {
            return 0;
        }
        int first = 0;
        int max = 0;
        int last = height.length - 1;
        while (first < last) {
            int edge;
            if (height[first] < height[last]) {
                edge = height[first];
                first++;
            } else {
                edge = height[last];
                last--;
            }

            // 因为上面已经移动过指针了，所以要加1
            int area = edge * (last + 1 - first);
            if (area > max) {
                max = area;
            }
        }

        return max;
    }
}
