import java.util.LinkedList;

public class LC100 {
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null) {
            return false;
        }
        if (q == null && p != null) {
            return false;
        }
        if (q == null && p == null) {
            return true;
        }
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode pNode = queue1.poll();
            TreeNode qNode = queue2.poll();
            if (pNode == null && qNode != null) {
                return false;
            }
            if (qNode == null && pNode != null) {
                return false;
            }
            if (qNode == null && pNode == null) {
                continue;
            }
            if (pNode.val != qNode.val) {
                return false;
            }
            queue1.offer(pNode.left);
            queue1.offer(pNode.right);
            queue2.offer(qNode.left);
            queue2.offer(qNode.right);
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
