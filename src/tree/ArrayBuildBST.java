package tree;

public class ArrayBuildBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length <= 0) {
            return null;
        }
        return buildBST(nums, 0, nums.length);
    }

    private TreeNode buildBST(int[] nums, int start, int end) {
        if (start > end || start == nums.length) {
            return null;
        }
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, start, mid - 1);
        root.right = buildBST(nums, mid + 1, end);
        return root;
    }
}
