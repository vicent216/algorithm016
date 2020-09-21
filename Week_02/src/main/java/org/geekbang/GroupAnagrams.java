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

    public List<List<String>> groupAnagrams2(String[] strs) {

        Map<String, List<String>> sortMap = new HashMap<>();

        for (String str : strs) {
            char[] keyArray = str.toCharArray();
            Arrays.sort(keyArray);

            String key = Arrays.toString(keyArray);
            List<String> list = sortMap.getOrDefault(key, new ArrayList<>());
            list.add(str);
            sortMap.put(key, list);
        }
        return new ArrayList<>(sortMap.values());
    }


    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> result = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String key = Arrays.toString(chars);

            // 这个方法挺好用的
            List<String> groupList = result.computeIfAbsent(key, k -> new ArrayList<>());
            groupList.add(str);
        }

        return new ArrayList<>(result.values());
    }
}
