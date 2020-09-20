package org.geekbang;

import org.geekbang.bean.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: 590. N叉树的后序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 * User: vi.wei
 * Date: 2020-09-20
 * Time: 21:15
 */
public class Postorder {

    public List<Integer> postorder(Node root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        if (root.children == null) {
            result.add(root.val);
            return result;
        }

        for (Node child : root.children) {
            result.addAll(postorder(child));
        }

        result.add(root.val);
        return result;
    }
}
