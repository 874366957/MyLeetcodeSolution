import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC95 {
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

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if(n==0){
            return res;
        }
        res = dfs(1,n);
        return res;
    }

    List<TreeNode> dfs(int lowest, int biggest) {
        List<TreeNode> allNodes = new LinkedList<TreeNode>();
        if (lowest > biggest) {
            allNodes.add(null);
            return allNodes;
        }
        if (lowest == biggest) {
            allNodes.add(new TreeNode(lowest));
            return allNodes;
        }
        for (int i = lowest; i <= biggest; i++) {
            List<TreeNode> leftNodes = dfs(lowest, i - 1);
            List<TreeNode> rightNodes = dfs(i + 1, biggest);
            for (int l = 0; l < leftNodes.size(); l++) {
                for (int r = 0; r < rightNodes.size(); r++) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftNodes.get(l);
                    node.right = rightNodes.get(r);
                    allNodes.add(node);
                }
            }
        }
        return allNodes;
    }
}
