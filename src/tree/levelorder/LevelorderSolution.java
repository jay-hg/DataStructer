package tree.levelorder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelorderSolution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answerList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        Queue<TreeNode> q1 = new ArrayDeque<>();
        Queue<TreeNode> q2 = new ArrayDeque<>();

        if (root != null) {
            q1.offer(root);
        }

        while (!q1.isEmpty()) {
            TreeNode t = q1.poll();
            tempList.add(t.val);

            if (t.left != null) {
                q2.offer(t.left);
            }
            if (t.right != null) {
                q2.offer(t.right);
            }

            if (q1.isEmpty()) {
                answerList.add(tempList);
                tempList = new ArrayList<>();
                q1 = q2;
                q2 = new ArrayDeque<>();
            }
        }
        return answerList;
    }
}
