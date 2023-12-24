import java.util.LinkedList;

public class LC92 {
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        int i = 1;
        LinkedList<Integer> list = new LinkedList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int start = left - 1, end = right - 1;
        while (start < end) {
            Integer leftVal = list.get(start);
            Integer rightVal = list.get(end);
            list.set(start, rightVal);
            list.set(end, leftVal);
            start++;
            end--;
        }
        ListNode res = new ListNode(list.pollFirst());
        ListNode curr = res;
        while (!list.isEmpty()) {
            curr.next = new ListNode(list.pollFirst());
            curr = curr.next;
        }
        return res;
    }
}
