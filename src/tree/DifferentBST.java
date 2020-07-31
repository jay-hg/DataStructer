package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DifferentBST {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<>(0);
        }
        return generateTrees(1,n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> res = new LinkedList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = generateTrees(start,i-1);
            List<TreeNode> rights = generateTrees(i + 1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
