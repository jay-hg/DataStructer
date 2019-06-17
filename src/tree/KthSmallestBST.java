package tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestBST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inorderList = new ArrayList<>();
        inorderVisist(root,inorderList);
        return inorderList.get(k-1);
    }

    private void inorderVisist(TreeNode root, List<Integer> inorderList) {
        if (root == null) {
            return;
        }
        inorderVisist(root.left, inorderList);
        inorderList.add(root.val);
        inorderVisist(root.right, inorderList);
    }
}
