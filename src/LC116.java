import java.util.LinkedList;

public class LC116 {
    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        LinkedList<Node> queue = new LinkedList<>();
        root.next = null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            LinkedList<Node> nextQueue = new LinkedList<>();
            Node nextVal = null;
            while (!queue.isEmpty()) {
                Node poll = queue.pollLast();
                poll.next = nextVal;
                nextVal = poll;
                if (poll.right != null) {
                    nextQueue.push(poll.right);
                    nextQueue.push(poll.left);
                }
            }
            queue = nextQueue;
        }
        return root;
    }
}
