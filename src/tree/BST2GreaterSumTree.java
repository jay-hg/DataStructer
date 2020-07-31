package tree;

public class BST2GreaterSumTree {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        //反向中序遍历并求和
        inOrderTravelAndSum(root);
        return root;
    }

    private void inOrderTravelAndSum(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTravelAndSum(root.right);
        sum += root.val;
        root.val = sum;
        inOrderTravelAndSum(root.left);
    }
}
