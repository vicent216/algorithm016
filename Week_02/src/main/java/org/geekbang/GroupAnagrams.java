package org.geekbang;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 49. 字母异位词分组
 * https://leetcode-cn.com/problems/group-anagrams/
 * User: vi.wei
 * Date: 2020-09-17
 * Time: 03:06
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> result = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String key = Arrays.toString(chars);

            List<String> groupList = result.get(key);
            if (groupList == null) {
                groupList = new ArrayList<>();
                result.put(key, groupList);
            }
            groupList.add(str);
        }

        return new ArrayList<>(result.values());
    }
}
