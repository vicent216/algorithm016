package org.geekbang;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: vi.wei
 * Date: 2020-09-11
 * Time: 19:30
 */
public class ClimbStairs {

    public static void main(String[] args) {
        int result = climbStairs2(4);
        System.out.println(result);
    }

    private static int climbStairs2(int n) {

        if (n <= 2) {
            return n;
        }

        int first = 1;
        int second = 2;

        for (int i = 3; i <= n; i++) {
            int tmp = second;
            second = first + second;
            first = tmp;
        }

        return second;
    }


    private static int climbStairs(int n) {
        int[] cache = new int[n + 1];
        return calc(n, cache);
    }

    private static int calc(int n, int[] cache) {
        if (cache[n] != 0) {
            return cache[n];
        }
        if (n <= 2) {
            return n;
        }
        int result = calc(n - 1, cache) + calc(n - 2, cache);
        cache[n] = result;
        return result;
    }
}
