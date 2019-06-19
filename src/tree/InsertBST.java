package tree;

public class InsertBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode insert = searchInsert(root, val);
        TreeNode newNode = new TreeNode(val);
        if (insert.val < val) {
            insert.right = newNode;
        } else {
            insert.left = newNode;
        }
        return root;
    }

    private TreeNode searchInsert(TreeNode root, Integer val) {
        //假设root必存在
        if (root.val < val) {
            return root.right == null ? root : searchInsert(root.right, val);
        } else {
            return root.left == null ? root : searchInsert(root.left, val);
        }
    }
}
