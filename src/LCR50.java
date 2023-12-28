public class LCR50 {
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

        long target;
        int ans = 0;

        public void dfs(TreeNode u, long sum) {
            if (u == null) return;
            if (sum + u.val == target){
                ans++;
            }
            dfs(u.left, sum + u.val);
            dfs(u.right, sum + u.val);
        }

        public void dfs1(TreeNode u){
            if(u == null) return;
            dfs(u, 0);
            dfs1(u.left);
            dfs1(u.right);

        }
        public int pathSum(TreeNode root, int targetSum) {
            this.target = targetSum;
            dfs1(root);
            return ans;
        }

    }
}
