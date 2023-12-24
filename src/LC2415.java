import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LC2415 {
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

    public TreeNode reverseOddLevels(TreeNode root) {
        int layer = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (true) {
            if (queue.isEmpty()) {
                break;
            }
            if (layer % 2 == 1) {
                int l = 0, r = queue.size() - 1;
                while (l < r) {
                    TreeNode left = queue.get(l);
                    TreeNode right = queue.get(r);
                    int temp = left.val;
                    left.val = right.val;
                    right.val = temp;
                    l++;
                    r--;
                }
            }
            LinkedList<TreeNode> next = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.pollFirst();
                if (treeNode.left != null) {
                    next.add(treeNode.left);
                    next.add(treeNode.right);
                }
            }
            queue = next;
            layer++;
        }
        return root;
    }

}
