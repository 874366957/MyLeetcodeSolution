public class LC337 {
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

    public int rob(TreeNode root) {
        return dfs(root, true);
    }

    int dfs(TreeNode root, boolean taken) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (taken) {
            int pickedup = dfs(root.left, false) + dfs(root.right, false) + root.val;
            int nopickedup = dfs(root.left, true) + dfs(root.right, true);
            res = Math.max(pickedup, nopickedup);
        } else {
            res = dfs(root.left, true) + dfs(root.right, true);
        }
        return res;
    }
}
