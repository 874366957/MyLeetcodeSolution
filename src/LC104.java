public class LC104 {
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

    int maxH = 0;

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        dfs(root, 1);
        return maxH;
    }

    void dfs(TreeNode root, int height) {
        if (root.left == null && root.right == null) {
            maxH = Math.max(height, maxH);
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
