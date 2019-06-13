package tree;

public class JudgeBST {
    private int last = Integer.MIN_VALUE;
    private boolean lastEnable = false;
    public boolean isValidBST(TreeNode root) {
        return inorderTravel(root);
    }

    private boolean inorderTravel(TreeNode root) {
        if (root == null) {
            return true;
        }

        //访问左子树
        if (!inorderTravel(root.left)) {
            return false;
        }

        //访问父节点
        if (lastEnable && root.val <= last) {
            return false;
        }
        last = root.val;
        lastEnable = true;

        //访问右子树
        if (!inorderTravel(root.right)) {
            return false;
        }

        return true;
    }
}
