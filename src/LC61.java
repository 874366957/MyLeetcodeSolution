import java.util.LinkedList;

public class LC61 {
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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        LinkedList<ListNode> queue = new LinkedList<>();
        while (head != null) {
            ListNode listNode = new ListNode(head.val);
            queue.add(listNode);
            head = head.next;
        }
        int times = k % queue.size();
        while (times > 0) {
            ListNode listNode = queue.pollLast();
            queue.offerFirst(listNode);
            times--;
        }
        ListNode res = queue.get(0);
        ListNode cur = res;
        for (int i = 1; i < queue.size(); i++) {
            cur.next = queue.get(i);
            cur = cur.next;
        }
        return res;
    }
}
