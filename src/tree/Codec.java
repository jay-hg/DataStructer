package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BST的序列化与反序列化
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //利用层序遍历进行序列化
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode == null) {
                continue;
            }
            sb.append(treeNode.val).append("#");
            queue.offer(treeNode.left);
            queue.offer(treeNode.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("")) {
            return null;
        }
        String[] nums = data.split("#");
        TreeNode root = new TreeNode(Integer.parseInt(nums[0]));
        for (int i = 1; i < nums.length; i++) {
            Integer val = Integer.parseInt(nums[i]);
            TreeNode insert = searchInsert(root, val);
            TreeNode newNode = new TreeNode(val);
            if (insert.val < val) {
                insert.right = newNode;
            } else {
                insert.left = newNode;
            }
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
