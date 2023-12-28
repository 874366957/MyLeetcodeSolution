import java.util.LinkedList;

public class LC19 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        LinkedList<Integer> queue = new LinkedList<>();
        while (head != null) {
            queue.offer(head.val);
            head = head.next;
        }
        queue.remove(queue.size() - n);
        if (queue.isEmpty()) {
            return null;
        }
        ListNode res = new ListNode(queue.poll());
        ListNode curr = res;
        while (!queue.isEmpty()) {
            ListNode node = new ListNode(queue.poll());
            curr.next = node;
            curr = curr.next;
        }
        return res;
    }
}
