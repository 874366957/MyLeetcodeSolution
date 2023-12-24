public class LC2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode curr = res;
        dfs(l1, l2, res, 0);
        return res.next;
    }

    void dfs(ListNode l1, ListNode l2, ListNode curr, int bit) {
        if (l1 == null && l2 == null) {
            if (bit == 1) {
                curr.next = new ListNode(1);
            }
            return;
        }
        int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + bit;
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        bit = sum / 10;
        dfs(l1 == null ? l1 : l1.next, l2 == null ? l2 : l2.next, curr, bit);
    }

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
}
