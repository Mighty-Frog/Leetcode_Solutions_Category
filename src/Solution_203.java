public class Solution_203 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
        public ListNode removeElements(ListNode head, int val) {
            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;
            while(head.next != null){
                if((head.next.val == val) && (head.next.next != null)){
                    p.next = new ListNode(head.next.next.val);
                    p = p.next;
                    head = head.next;
                }
                else if((head.next.val == val) && (head.next.next == null)) {
                    p.next = null;
                    return dummy.next;
                }
                p = new ListNode(head.next.val);
                p = p.next;
                head = head.next;
            }
            return dummy.next;

        }
}
