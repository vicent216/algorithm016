package org.geekbang;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: 242. 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/description/
 * User: vi.wei
 * Date: 2020-09-17
 * Time: 02:40
 */
public class IsAnagram {

    public static void main(String[] args) {
        isAnagram("anagram", "nagaram");
    }

    public static boolean isAnagram(String s, String t) {

        char[] firstString = s.toCharArray();

        Map<Character, Integer> charCountMap = new HashMap<>();

        for (char c : firstString) {
            Integer count = charCountMap.get(c);
            if (count == null) {
                count = 0;
            }
            charCountMap.put(c, ++count);
        }

        for (char c : t.toCharArray()) {
            Integer count = charCountMap.get(c);
            if (count == null) {
                return false;
            }
            count--;
            if (count < 0) {
                return false;
            }
            if (count == 0) {
                charCountMap.remove(c);
            } else {
                charCountMap.put(c, count);
            }
        }

        return charCountMap.isEmpty();
    }
}
