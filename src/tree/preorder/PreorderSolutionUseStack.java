package tree.preorder;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderSolutionUseStack {
    List<Integer> list = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        while (true) {
            vistAlongLeftBrunch(root);
            if (stack.isEmpty()) {
                break;
            }
            root = stack.pop();
        }
        return list;
    }

    private void vistAlongLeftBrunch(TreeNode treeNode) {
        while (treeNode != null) {
            list.add(treeNode.val);
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            treeNode = treeNode.left;
        }
    }
}
