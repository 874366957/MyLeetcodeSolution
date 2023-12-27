import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

public class LC2583 {
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

    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        ArrayList<Long> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            LinkedList<TreeNode> nextQueue = new LinkedList<>();
            long floorSum = 0;
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                floorSum += poll.val;
                if (poll.left != null) {
                    nextQueue.offer(poll.left);
                }
                if (poll.right != null) {
                    nextQueue.offer(poll.right);
                }
            }
            queue = nextQueue;
            res.add(floorSum);
        }
        if (k > res.size()) {
            return -1;
        }
        res.sort(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return o1.compareTo(o2);
            }
        });
        return res.get(res.size() - k);
    }
}
