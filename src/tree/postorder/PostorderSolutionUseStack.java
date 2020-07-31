package tree.postorder;

import sun.reflect.generics.tree.Tree;
import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderSolutionUseStack {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        //根节点入栈
        if (root != null) {
            stack.push(root);
        }

        TreeNode pre = null;
        TreeNode cur = null;
        while (!stack.isEmpty()) {
            if (pre == null || preIsBrother(pre,stack.peek())) {
                //上次访问的节点为空或是当前栈顶节点的兄弟
                //则栈顶节点当成一棵从未访问过的子树处理
                gotoHLVFL(stack);
            }
            //否则出栈访问
            cur = stack.pop();
            list.add(cur.val);
            pre = cur;
        }

        return list;
    }

    private boolean preIsBrother(TreeNode pre, TreeNode peek) {
        //即pre不是peek的左儿子或右儿子
        return peek.left != pre && peek.right != pre;
    }

    private void gotoHLVFL(Stack<TreeNode> stack) {
        while (stack.peek() != null) {
            TreeNode t = stack.peek();
            if (t.left != null) {
                if (t.right != null) {
                    stack.push(t.right);
                }
                stack.push(t.left);
            } else {
                stack.push(t.right);
            }
        }
        stack.pop();
    }
}
