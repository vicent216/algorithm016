package org.geekbang;

import org.geekbang.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: 94. 二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * User: vi.wei
 * Date: 2020-09-20
 * Time: 17:23
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> left = inorderTraversal(root.left);
        List<Integer> right = inorderTraversal(root.right);

        List<Integer> result = new ArrayList<>(left);
        result.add(root.val);
        result.addAll(right);

        return result;
    }

}
