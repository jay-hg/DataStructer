package tree.construct;

import tree.TreeNode;

public class PreorderInorderSolution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return constructTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode constructTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart == preEnd) {
            return null;
        }
        //1.找到跟节点
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIdx = findRootIdx(inorder, inStart, inEnd, root.val); //找到跟节点在inorder的位置
        int inorderLeft = inStart;
        int inorderLeftEnd = rootIdx;
        int inorderRight = rootIdx+1;
        int inorderRightEnd = inEnd;
        int preorderLeft = preStart+1;
        int preorderLeftEnd = preStart+1+rootIdx-inStart;
        int preorderRight = preorderLeftEnd;
        int preorderRightEnd = preEnd;

        //2.递归构建左子树
        root.left = constructTree(preorder, preorderLeft, preorderLeftEnd, inorder, inorderLeft, inorderLeftEnd);
        //3.递归构建右子树
        root.right = constructTree(preorder, preorderRight, preorderRightEnd, inorder, inorderRight, inorderRightEnd);
        return root;
    }

    private int findRootIdx(int[] inorder, int inStart, int inEnd, int val) {
        while (inStart < inEnd) {
            if (val == inorder[inStart]) {
                return inStart;
            }
            inStart++;
        }
        return inEnd;
    }
}
