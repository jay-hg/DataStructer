package tree.inorder;


import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历递归实现
 */
public class InorderSolution {
    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }

        //1.遍历左子树
        inorderTraversal(root.left);

        //2.访问父节点
        list.add(root.val);

        //3.遍历右子树
        inorderTraversal(root.right);

        return list;
    }

    public static void main(String[] args) {
        InorderSolution solution = new InorderSolution();
        TreeNode root = new TreeNode(1);
        solution.inorderTraversal(root).forEach((x)->{
            System.out.println(x);
        });
    }
}
