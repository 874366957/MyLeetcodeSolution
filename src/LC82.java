import java.util.LinkedList;

public class LC82 {
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

    public ListNode deleteDuplicates(ListNode head) {
        LinkedList<Integer> queue = new LinkedList<>();
        boolean popflag = false;
        while (head != null) {
            if (queue.isEmpty()) {
                queue.add(head.val);
                head = head.next;
                continue;
            }
            if (queue.peekLast().equals(head.val)) {
                popflag = true;
            } else {
                if (popflag) {
                    queue.pollLast();
                    popflag = false;
                }
                queue.add(head.val);
            }
            head = head.next;
        }
        if (popflag) {
            queue.pollLast();
        }
        if (queue.isEmpty()) {
            return null;
        }
        ListNode listNode = new ListNode(queue.pollFirst());
        ListNode curr = listNode;
        while (!queue.isEmpty()) {
            curr.next = new ListNode(queue.pollFirst());
            curr = curr.next;
        }
        return listNode;
    }
}
