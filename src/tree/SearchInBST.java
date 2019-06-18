package tree;

public class SearchInBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        return searchBST(val > root.val ? root.right : root.left, val);
    }
}
