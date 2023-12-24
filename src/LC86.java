import java.util.LinkedList;

public class LC86 {
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

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        LinkedList<Integer> leftQueue = new LinkedList<>();
        LinkedList<Integer> rightQueue = new LinkedList<>();
        while (head != null) {
            if (head.val <= x) {
                leftQueue.add(head.val);
            } else {
                rightQueue.add(head.val);
            }
            head = head.next;
        }
        leftQueue.addAll(rightQueue);
        ListNode listNode = new ListNode(leftQueue.pollFirst());
        ListNode curr = listNode;
        while (!leftQueue.isEmpty()) {
            Integer poll = leftQueue.pollFirst();
            curr.next = new ListNode(poll);
            curr = curr.next;
        }
        return listNode;
    }
}
