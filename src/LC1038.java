public class LC1038 {
    public static void main(String[] args) {

    }

    private int dfs(TreeNode node, int sum) {
        if (null == node) {
            return 0;
        }
        int right = dfs(node.right, sum);
        int left = dfs(node.left, sum + right + node.val);
        node.val = sum + right;
        return node.val + left;
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
