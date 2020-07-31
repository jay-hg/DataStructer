package tree.levelorder;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        levelOrderView(root, ans);
        return ans;
    }

    private void levelOrderView(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return ;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int m = 1;
        int n = 0;
        while (!queue.isEmpty()) {
            TreeNode tn = queue.poll();
            if (tn.left != null) {
                queue.offer(tn.left);
                n ++;
            }

            if (tn.right != null) {
                queue.offer(tn.right);
                n ++;
            }
            m --;

            if (m == 0) {
                ans.add(tn.val);
                m = n;
                n = 0;
            }
        }
    }
}
