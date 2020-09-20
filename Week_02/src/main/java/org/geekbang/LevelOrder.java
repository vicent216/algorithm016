package org.geekbang;

import org.geekbang.bean.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description: 429. N叉树的层序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 * User: vi.wei
 * Date: 2020-09-20
 * Time: 21:28
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.remove();
                level.add(node.val);
                List<Node> children = node.children;
                queue.addAll(children);
            }
            result.add(level);
        }

        return result;
    }

}
