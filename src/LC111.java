public class LC111 {
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

    int minH = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        dfs(root, 1);
        return minH;
    }

    void dfs(TreeNode root, int height) {
        if (root.left == null && root.right == null) {
            minH = Math.min(height, minH);
            return;
        }
        if (root.left != null) {
            dfs(root.left, height + 1);
        }
        if (root.right != null) {
            dfs(root.right, height + 1);
        }
    }
}
