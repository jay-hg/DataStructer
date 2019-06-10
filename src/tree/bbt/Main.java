package tree.bbt;

import tree.TreeNode;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        TreeNode root = new TreeNode(0);
        Main main = new Main();
        System.out.println("tree is balanced? "+main.isBalanced(root));
    }

    public int getHeight(TreeNode treeNode) {
        if(treeNode == null) return -1;
        int leftHeight = treeNode.left != null ? getHeight(treeNode.left) : -1;
        int rightHeight = treeNode.right != null ? getHeight(treeNode.right) : -1;
        return 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
    }

    public boolean nodeIsBalanced(TreeNode treeNode) {
        if(treeNode == null) return true;
        int leftHeight = treeNode.left != null ? getHeight(treeNode.left) : -1;
        int rightHeight = treeNode.right != null ? getHeight(treeNode.right) : -1;
        return Math.abs(leftHeight - rightHeight) < 2;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        //遍历每一个节点
        //1.访问主节点
        if(!nodeIsBalanced(root)) return false;

        //2.访问左子树
        if(!isBalanced(root.left)) return false;

        //3.访问右子树
        if(!isBalanced(root.right)) return false;

        return true;
    }
}
