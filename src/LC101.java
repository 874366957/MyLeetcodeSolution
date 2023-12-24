import java.util.LinkedList;

public class LC101 {
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

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        LinkedList<TreeNode> leftQueue = new LinkedList<>();
        LinkedList<TreeNode> rightQueue = new LinkedList<>();
        leftQueue.offer(root.left);
        rightQueue.offer(root.right);
        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            TreeNode leftNode = leftQueue.poll();
            TreeNode rightNode = rightQueue.poll();
            if (leftNode == null && rightNode != null) {
                return false;
            }
            if (rightNode == null && leftNode != null) {
                return false;
            }
            if (leftNode == null && rightNode == null) {
                continue;
            }
            if (leftNode.val != rightNode.val) {
                return false;
            }
            leftQueue.offer(leftNode.left);
            rightQueue.offer(rightNode.right);
            leftQueue.offer(leftNode.right);
            rightQueue.offer(rightNode.left);
        }
        return true;
    }
}
