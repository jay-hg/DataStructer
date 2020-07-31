package tree.inorder;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderSolutionUseStack {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        //辅助栈
        Stack<TreeNode> stack = new Stack<>();

        while (true) {
            //节点及其左边入栈
            pushLeftNode(root, stack);
            if (stack.isEmpty()) {
                break;
            }

            //出栈即访问，处理右子树
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    private void pushLeftNode(TreeNode root, Stack<TreeNode> stack) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public static void main(String[] args) {
        InorderSolutionUseStack solution = new InorderSolutionUseStack();
        TreeNode root = new TreeNode(1);
        solution.inorderTraversal(root).forEach((x)->{
            System.out.println(x);
        });
    }
}
