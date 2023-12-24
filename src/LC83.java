public class LC83 {
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
        ListNode curr = head;
        while (curr != null) {
            if (curr.next != null) {
                if (curr.val == curr.next.val) {
                    curr.next = curr.next.next;
                }
            }
            curr = curr.next;
        }
        return head;
    }
}
