import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC199 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            LinkedList<TreeNode> nextQueue = new LinkedList<>();
            int flag = 0;
            while (!queue.isEmpty()) {
                TreeNode poll = queue.pollLast();
                if (flag == 0) {
                    res.add(poll.val);
                }
                if (poll.right != null) {
                    nextQueue.push(poll.right);
                }
                if (poll.left != null) {
                    nextQueue.push(poll.left);
                }
                flag++;
            }
            queue = nextQueue;
        }
        return res;
    }
}
