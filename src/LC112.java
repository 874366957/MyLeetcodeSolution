public class LC112 {
    private boolean found = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        dfs(root, 0, targetSum);
        return found;
    }

    void dfs(TreeNode root, int sum, int targetSum) {
        if (found) {
            return;
        }
        sum = sum + root.val;
        if (root.left == null && root.right == null) {
            found = sum == targetSum;
            return;
        }
        if (null != root.left) {
            dfs(root.left, sum, targetSum);
        }
        if (null != root.right) {
            dfs(root.right, sum, targetSum);
        }
    }

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
}