package org.geekbang;

import org.geekbang.bean.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: 589. N叉树的前序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
 * User: vi.wei
 * Date: 2020-09-20
 * Time: 21:21
 */
public class Preorder {

    public List<Integer> preorder(Node root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        if (root.children == null) {
            result.add(root.val);
            return result;
        }

        result.add(root.val);
        for (Node child : root.children) {
            result.addAll(preorder(child));
        }
        return result;
    }
}
