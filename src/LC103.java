import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LC103 {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int floorCnt = 1;
        int cnt = 1;
        while (!queue.isEmpty()) {
            ArrayList<Integer> floor = new ArrayList<>();
            int nextCount = 0;
            while (cnt > 0) {
                TreeNode poll = queue.poll();
                floor.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                    nextCount++;
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                    nextCount++;
                }
                cnt--;
            }
            cnt = nextCount;
            if (!floor.isEmpty()) {
                if (floorCnt % 2 == 0) {
                    Collections.reverse(floor);
                }
                res.add(floor);
            }
            floorCnt++;
        }
        return res;
    }
}
